package org.cliff.ddd.demo.domain.customer.convertor.extension;

import org.cliff.ddd.demo.common.AppConstants;
import org.cliff.ddd.demo.common.BizCode;
import org.cliff.ddd.demo.tunnel.dataobject.CustomerDO;
import org.cliff.ddd.demo.domain.customer.convertor.CustomerConvertor;
import org.cliff.ddd.demo.domain.customer.convertor.extensionpoint.CustomerConvertorExtPt;
import org.cliff.ddd.demo.domain.customer.entity.CustomerE;
import org.cliff.ddd.demo.domain.customer.valueobject.SourceType;
import org.cliff.ddd.demo.dto.clientobject.CustomerCO;
import com.alibaba.sofa.extension.Extension;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * CustomerCGSConvertorExt
 *
 * @author Frank Zhang
 * @date 2018-01-07 3:05 AM
 */
@Extension(bizCode = BizCode.CGS)
public class CustomerCGSConvertorExt implements CustomerConvertorExtPt {

    @Autowired
    private CustomerConvertor customerConvertor;//Composite basic convertor to do basic conversion

    @Override
    public CustomerE clientToEntity(CustomerCO customerCO){
        CustomerE customerEntity = customerConvertor.clientToEntity(customerCO);
        //In this business, if customers from RFQ and Advertisement are both regarded as Advertisement
        if(AppConstants.SOURCE_AD.equals(customerCO.getSource()) || AppConstants.SOURCE_RFQ.equals(customerCO.getSource()))
        {
            customerEntity.setSourceType(SourceType.AD);
        }
        return customerEntity;
    }

    public CustomerCO dataToClient(CustomerDO customerDO){
        return customerConvertor.dataToClient(customerDO);
    }
}
