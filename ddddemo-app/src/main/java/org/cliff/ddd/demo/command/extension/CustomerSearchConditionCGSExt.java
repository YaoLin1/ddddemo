package org.cliff.ddd.demo.command.extension;

import org.cliff.ddd.demo.command.extensionpoint.CustomerCheckConflictSearchConditionExtPt;
import org.cliff.ddd.demo.common.BizCode;
import com.alibaba.sofa.extension.Extension;

@Extension(bizCode = BizCode.CGS)
public class CustomerSearchConditionCGSExt implements CustomerCheckConflictSearchConditionExtPt {

    @Override
    public String getSearchCondition(String condition) {
        return "CGS Search Condition";
    }

}
