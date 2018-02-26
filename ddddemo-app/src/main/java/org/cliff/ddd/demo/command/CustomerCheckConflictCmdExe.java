package org.cliff.ddd.demo.command;

import com.alibaba.sofa.command.Command;
import com.alibaba.sofa.command.CommandExecutorI;
import com.alibaba.sofa.dto.MultiResponse;
import com.alibaba.sofa.extension.ExtensionExecutor;
import org.cliff.ddd.demo.command.extensionpoint.CustomerCheckConflictSearchConditionExtPt;
import org.cliff.ddd.demo.dto.CustomerCheckConflictCmd;
import org.cliff.ddd.demo.dto.clientobject.CustomerCO;
import org.springframework.beans.factory.annotation.Autowired;

@Command
public class CustomerCheckConflictCmdExe implements CommandExecutorI<MultiResponse<CustomerCO>, CustomerCheckConflictCmd>{

    @Autowired
    private ExtensionExecutor extensionExecutor;
    
    @Override
    public MultiResponse<CustomerCO> execute(CustomerCheckConflictCmd cmd) {
        System.out.println("Shared logic");
        String searchCondition = extensionExecutor.execute(
                                   CustomerCheckConflictSearchConditionExtPt.class,
                                   extension -> extension.getSearchCondition("condition"));
        System.out.println("Shared logic with "+ searchCondition);
        return MultiResponse.of(null, 0);
    }

}
