package org.cliff.ddd.demo.domain.customer.convertor;

import com.alibaba.sofa.common.ApplicationContextHelper;
import com.alibaba.sofa.convertor.ConvertorI;
import org.cliff.ddd.demo.domain.customer.entity.CustomerE;
import org.cliff.ddd.demo.domain.customer.valueobject.CompanyType;
import org.cliff.ddd.demo.dto.clientobject.CustomerCO;
import org.cliff.ddd.demo.dto.clientobject.CustomerType;
import org.cliff.ddd.demo.tunnel.dataobject.CustomerDO;
import org.springframework.stereotype.Component;

/**
 * CustomerConvertor
 *
 * @author Frank Zhang
 * @date 2018-01-07 3:08 AM
 */
@Component
public class CustomerConvertor implements ConvertorI<CustomerCO, CustomerE, CustomerDO> {

    @Override
    public CustomerE clientToEntity(CustomerCO customerCO){
        CustomerE customerEntity = (CustomerE) ApplicationContextHelper.getBean(CustomerE.class);
        customerEntity.setCompanyName(customerCO.getCompanyName());
        customerEntity.setCompanyType(CompanyType.valueOf(customerCO.getCustomerType().name()));
        return customerEntity;
    }

    @Override
    public CustomerCO entityToClient(CustomerE entity){
        CustomerCO customerCO = new CustomerCO();
        customerCO.setCustomerId(entity.getCustomerId());
        customerCO.setCompanyName(entity.getCompanyName());
        customerCO.setMemberId(entity.getMemberId());
        customerCO.setSource(entity.getSourceType()!=null?entity.getSourceType().name():null);

        return customerCO;
    }

    @Override
    public CustomerCO dataToClient(CustomerDO dataObject) {
        CustomerCO customerCO = new CustomerCO();
        customerCO.setCustomerName(dataObject.getCompanyName());
        customerCO.setCustomerType(CustomerType.valueOf(dataObject.getCompanyType()));
        customerCO.setMemberId(dataObject.getMemberId());
        customerCO.setCustomerId(dataObject.getCustomerId());
        return customerCO;
    }

    public CustomerE dataToEntity(CustomerDO dataObject){
        CustomerE customerEntity = (CustomerE) ApplicationContextHelper.getBean(CustomerE.class);
        customerEntity.setCustomerId(dataObject.getCustomerId());
        customerEntity.setCompanyName(dataObject.getCompanyName());
        if(dataObject.getCompanyType()!=null) {
            customerEntity.setCompanyType(CompanyType.valueOf(dataObject.getCompanyType()));
        }
        return customerEntity;
    }
}
