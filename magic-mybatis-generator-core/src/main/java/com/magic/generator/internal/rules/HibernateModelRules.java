package com.magic.generator.internal.rules;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.internal.rules.BaseRules;

/**
 * <br>Filename:    HibernateModelRules  <br>
 * Description:
 * <br>Copyright:   Copyright (c) 2016-2017 All Rights Reserved.<br>
 * Company:     golden-soft.com Inc.<br>
 * author:     lvcyong <br>
 * version:    1.0  <br>
 * Create at:   2017-09-28 17:04 <br>
 * <p>
 * Modification History:
 * <br>Date    &nbsp;     Author      Version     Description  <br>
 * ------------------------------------------------------------------  <br>
 * 2017-09-28    lvcyong      1.0         1.0 Version  <br>
 */
public class HibernateModelRules extends BaseRules {

    /**
     * Instantiates a new base rules.
     *
     * @param introspectedTable the introspected table
     */
    public HibernateModelRules(IntrospectedTable introspectedTable) {
        super(introspectedTable);
    }

    /**
     * Implements the rule for determining whether to generate a primary key
     * class. If you return false from this method, and the table has primary
     * key columns, then the primary key columns will be added to the base
     * class.
     *
     * @return true if a separate primary key class should be generated
     */
    @Override
    public boolean generatePrimaryKeyClass() {
        return introspectedTable.hasPrimaryKeyColumns()
                && introspectedTable.getPrimaryKeyColumns().size() > 1;
    }

    /**
     * Implements the rule for generating a base record.
     *
     * @return true if the class should be generated
     */
    @Override
    public boolean generateBaseRecordClass() {
        return true;
    }

    /**
     * Implements the rule for generating a record with BLOBs. If you return
     * false from this method, and the table had BLOB columns, then the BLOB
     * columns will be added to the base class.
     *
     * @return true if the record with BLOBs class should be generated
     */
    @Override
    public boolean generateRecordWithBLOBsClass() {
        return false;
    }
}
