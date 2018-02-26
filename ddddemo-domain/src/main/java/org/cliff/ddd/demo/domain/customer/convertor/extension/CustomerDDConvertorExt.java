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
 * CustomerDDConvertorExt
 *
 * @author Frank Zhang
 * @date 2018-01-08 1:57 PM
 */
@Extension(bizCode = BizCode.DD)
public class CustomerDDConvertorExt implements CustomerConvertorExtPt {

    @Autowired
    private CustomerConvertor customerConvertor;//Composite basic convertor to do basic conversion

    @Override
    public CustomerE clientToEntity(CustomerCO customerCO) {
        CustomerE customerEntity = customerConvertor.clientToEntity(customerCO);
        //In this business, AD and RFQ are regarded as different source
        if(AppConstants.SOURCE_AD.equals(customerCO.getSource()))
        {
            customerEntity.setSourceType(SourceType.AD);
        }
        if (AppConstants.SOURCE_RFQ.equals(customerCO.getSource())){
            customerEntity.setSourceType(SourceType.RFQ);
        }
        return customerEntity;
    }

    public CustomerCO dataToClient(CustomerDO customerDO){
        return customerConvertor.dataToClient(customerDO);
    }
}
