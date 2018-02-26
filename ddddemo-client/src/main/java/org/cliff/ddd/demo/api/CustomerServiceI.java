package org.cliff.ddd.demo.api;

import com.alibaba.sofa.dto.MultiResponse;
import com.alibaba.sofa.dto.Response;
import org.cliff.ddd.demo.dto.CustomerAddCmd;
import org.cliff.ddd.demo.dto.CustomerCheckConflictCmd;
import org.cliff.ddd.demo.dto.CustomerFindByCriteriaQry;
import org.cliff.ddd.demo.dto.clientobject.CustomerCO;

public interface CustomerServiceI {

    public Response addCustomer(CustomerAddCmd customerAddCmd);
    
    public MultiResponse<CustomerCO> checkConflict(CustomerCheckConflictCmd customerCheckConflictCmd);
    
    public MultiResponse<CustomerCO> findByCriteria(CustomerFindByCriteriaQry CustomerFindByCriteriaQry);
}
