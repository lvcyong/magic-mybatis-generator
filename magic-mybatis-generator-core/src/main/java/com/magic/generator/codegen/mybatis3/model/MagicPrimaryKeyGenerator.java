package com.magic.generator.codegen.mybatis3.model;

import com.magic.generator.internal.rules.HibernateModelRules;
import org.mybatis.generator.codegen.mybatis3.model.PrimaryKeyGenerator;

/**
 * <br>Filename:    MagicPrimaryKeyGenerator  <br>
 * Description:
 * <br>Copyright:   Copyright (c) 2016-2017 All Rights Reserved.<br>
 * Company:     golden-soft.com Inc.<br>
 * author:     lvcyong <br>
 * version:    1.0  <br>
 * Create at:   2017-09-28 18:38 <br>
 * <p>
 * Modification History:
 * <br>Date    &nbsp;     Author      Version     Description  <br>
 * ------------------------------------------------------------------  <br>
 * 2017-09-28    lvcyong      1.0         1.0 Version  <br>
 */
public class MagicPrimaryKeyGenerator extends PrimaryKeyGenerator {

    @Override
    public String getRootClass() {
        if (introspectedTable.getRules() instanceof HibernateModelRules) {
            return null;
        }

        return super.getRootClass();
    }
}
