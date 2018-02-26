package org.cliff.ddd.demo.command.query;

import com.alibaba.sofa.command.Command;
import com.alibaba.sofa.command.QueryExecutorI;
import com.alibaba.sofa.dto.MultiResponse;
import org.cliff.ddd.demo.domain.customer.convertor.CustomerConvertor;
import org.cliff.ddd.demo.domain.customer.entity.CustomerE;
import org.cliff.ddd.demo.domain.customer.repository.CustomerRepository;
import org.cliff.ddd.demo.dto.CustomerFindByCriteriaQry;
import org.cliff.ddd.demo.dto.clientobject.CustomerCO;
import org.cliff.ddd.demo.tunnel.dataobject.CustomerDO;
import org.cliff.ddd.demo.tunnel.datatunnel.CustomerTunnelI;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Command
public class CustomerFindByCriteriaQueryExe implements QueryExecutorI<MultiResponse<CustomerCO>, CustomerFindByCriteriaQry> {

    @Autowired
    CustomerTunnelI customerDBTunnel;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerConvertor customerConvertor;

    @Override
    public MultiResponse<CustomerCO> execute(CustomerFindByCriteriaQry cmd) {
        List<CustomerE> customerEList = customerRepository.findByCriteria("");
        List<CustomerCO> customerCos = new ArrayList<>();
        for(CustomerE entity:customerEList ) {
            customerCos.add(customerConvertor.entityToClient(entity));
        }
        return MultiResponse.of(customerCos, customerCos.size());
    }


    public CustomerDO get(String id) {
        CustomerDO customerDO = customerDBTunnel.get("123");
        customerDO.setCompanyType("IMPORTANT");
        customerDO.setCompanyName("jkys");
        return customerDO;
    }
}
