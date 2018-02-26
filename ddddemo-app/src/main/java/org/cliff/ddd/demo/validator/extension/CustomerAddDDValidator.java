/*
 * Copyright 2017 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shdemo not disclose such Confidential Information and shdemo
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package org.cliff.ddd.demo.validator.extension;

import com.alibaba.sofa.exception.ParamException;
import com.alibaba.sofa.extension.Extension;
import com.alibaba.sofa.logger.Logger;
import com.alibaba.sofa.logger.LoggerFactory;
import com.alibaba.sofa.validator.ValidatorCompoiste;
import org.cliff.ddd.demo.common.BizCode;
import org.cliff.ddd.demo.dto.CustomerAddCmd;
import org.cliff.ddd.demo.validator.CustomerAddValidator;
import org.cliff.ddd.demo.validator.extensionpoint.CustomerAddValidatorExtPt;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * CustomerAddDDValidator
 * 
 * @author fulan.zjf 2017-11-04
 */
@Extension(bizCode = BizCode.DD)
public class CustomerAddDDValidator extends ValidatorCompoiste implements CustomerAddValidatorExtPt{

	private Logger logger = LoggerFactory.getLogger(CustomerAddDDValidator.class);
	
    @Autowired
    private CustomerAddValidator customerAddValidator;

    @Autowired
    private CustomerAddCGSValidator customerAddCGSValidator;

    @Override
    protected void addOtherValidators() {
        // just for demo, 假设钉钉的校验逻辑是在common和CGS的基础上，还有自己额外的校验
        add(customerAddValidator);
    }

    @Override
    protected void doValidate(Object candidate) {
        logger.debug("Do DingDing validation");
        CustomerAddCmd addCustomerCmd = (CustomerAddCmd) candidate;
        //For DD Biz CustomerType could not be null
        if (addCustomerCmd.getCustomer().getCustomerType() == null)
            throw new ParamException("CustomerType could not be null");

    }

}
