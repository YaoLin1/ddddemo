package org.cliff.ddd.demo.domain.customer.rule.extension;

import org.cliff.ddd.demo.common.BizCode;
import org.cliff.ddd.demo.domain.customer.entity.CustomerE;
import org.cliff.ddd.demo.domain.customer.rule.extensionpoint.CustomerRuleExtPt;
import org.cliff.ddd.demo.domain.customer.valueobject.SourceType;
import com.alibaba.sofa.exception.BizException;
import com.alibaba.sofa.extension.Extension;

/**
 * CustomerDDRuleExt
 *
 * @author Frank Zhang
 * @date 2018-01-07 12:10 PM
 */
@Extension(bizCode = BizCode.DD)
public class CustomerDDRuleExt implements CustomerRuleExtPt {

    @Override
    public boolean addCustomerCheck(CustomerE customerEntity) {
        if(SourceType.AD == customerEntity.getSourceType()){
            throw new BizException("Sorry, Customer from advertisement can not be added in this period");
        }
        return true;
    }
}
