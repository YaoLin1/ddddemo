package org.cliff.ddd.demo.command;

import com.alibaba.sofa.command.Command;
import com.alibaba.sofa.command.CommandExecutorI;
import com.alibaba.sofa.dto.Response;
import com.alibaba.sofa.extension.ExtensionExecutor;
import com.alibaba.sofa.validator.ValidatorExecutor;
import org.cliff.ddd.demo.domain.customer.convertor.extensionpoint.CustomerConvertorExtPt;
import org.cliff.ddd.demo.domain.customer.entity.CustomerE;
import org.cliff.ddd.demo.dto.CustomerAddCmd;
import org.cliff.ddd.demo.validator.extensionpoint.CustomerAddValidatorExtPt;
import org.springframework.beans.factory.annotation.Autowired;

@Command
public class CustomerAddCmdExe implements CommandExecutorI<Response, CustomerAddCmd>{

    @Autowired
    private ValidatorExecutor  validatorExecutor;

    @Autowired
    private ExtensionExecutor extensionExecutor;

    @Override
    public Response execute(CustomerAddCmd cmd) {
        //1, validation
    	validatorExecutor.validate(CustomerAddValidatorExtPt.class, cmd);
    	
        //2, invoke domain service or directly operate domain to do business logic process
        CustomerE customerEntity = extensionExecutor.execute(CustomerConvertorExtPt.class, extension -> extension.clientToEntity(cmd.getCustomer()));
        customerEntity.addNewCustomer();

        //3, notify by sending message out
        return Response.buildSuccess();
    }

}
