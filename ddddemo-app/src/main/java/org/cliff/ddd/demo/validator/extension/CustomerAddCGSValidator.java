/*
 * Copyright 2017 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shdemo not disclose such Confidential Information and shdemo
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package org.cliff.ddd.demo.validator.extension;

import com.alibaba.sofa.exception.BizException;
import com.alibaba.sofa.extension.Extension;
import com.alibaba.sofa.logger.Logger;
import com.alibaba.sofa.logger.LoggerFactory;
import com.alibaba.sofa.validator.ValidatorCompoiste;
import org.cliff.ddd.demo.common.BizCode;
import org.cliff.ddd.demo.dto.CustomerAddCmd;
import org.cliff.ddd.demo.dto.clientobject.CustomerType;
import org.cliff.ddd.demo.validator.CustomerAddValidator;
import org.cliff.ddd.demo.validator.extensionpoint.CustomerAddValidatorExtPt;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * CustomerAddCGSValidator
 * 
 * @author fulan.zjf 2017-11-04
 */
@Extension(bizCode = BizCode.CGS)
public class CustomerAddCGSValidator extends ValidatorCompoiste implements CustomerAddValidatorExtPt {

	private Logger logger = LoggerFactory.getLogger(CustomerAddCGSValidator.class);
	
    @Autowired
    private CustomerAddValidator customerAddValidator;

    @Override
    protected void addOtherValidators() {
        add(customerAddValidator);
    }

    @Override
    protected void doValidate(Object candidate) {
    	logger.debug("This is CGS validation");
        CustomerAddCmd addCustomerCmd = (CustomerAddCmd) candidate;
        //For CGS BIZ CustomerTYpe could not be VIP
        if(CustomerType.VIP == addCustomerCmd.getCustomer().getCustomerType())
            throw new BizException("VIP Customer can not be added by CGS");
    }

}
