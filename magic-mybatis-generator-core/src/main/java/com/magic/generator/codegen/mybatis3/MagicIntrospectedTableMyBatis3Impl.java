package com.magic.generator.codegen.mybatis3;

import com.magic.generator.enums.MapperType;
import org.mybatis.generator.api.ProgressCallback;
import org.mybatis.generator.codegen.AbstractJavaClientGenerator;
import org.mybatis.generator.codegen.mybatis3.IntrospectedTableMyBatis3Impl;
import org.mybatis.generator.codegen.mybatis3.javamapper.AnnotatedClientGenerator;
import org.mybatis.generator.codegen.mybatis3.javamapper.JavaMapperGenerator;
import org.mybatis.generator.codegen.mybatis3.javamapper.MixedClientGenerator;
import org.mybatis.generator.internal.ObjectFactory;

import java.util.List;

/**
 * <br>Filename:    MagicIntrospectedTableMyBatis3Impl  <br>
 * Description:
 * <br>Copyright:   Copyright (c) 2016-2017 All Rights Reserved.<br>
 * Company:     golden-soft.com Inc.<br>
 * author:     lvcyong <br>
 * version:    1.0  <br>
 * Create at:   2017-09-26 16:59 <br>
 * <p>
 * Modification History:
 * <br>Date    &nbsp;     Author      Version     Description  <br>
 * ------------------------------------------------------------------  <br>
 * 2017-09-26    lvcyong      1.0         1.0 Version  <br>
 */
public class MagicIntrospectedTableMyBatis3Impl extends IntrospectedTableMyBatis3Impl {

    /**
     * 计算 mapper 生成.
     *
     * @param javaClientGenerator java mapper 生成
     * @param warnings            the warnings
     * @param progressCallback  进度回调
     *
     * @author  lvcyong
     * @date    2017/9/27 13:55
     */
    @Override
    protected void calculateXmlMapperGenerator(AbstractJavaClientGenerator javaClientGenerator, List<String> warnings, ProgressCallback progressCallback) {
        super.calculateXmlMapperGenerator(javaClientGenerator, warnings, progressCallback);

        setCountByExampleStatementId("countByCriteria"); //$NON-NLS-1$
        setDeleteByExampleStatementId("removeByCriteria"); //$NON-NLS-1$
        setDeleteByPrimaryKeyStatementId("removeByPrimaryKey"); //$NON-NLS-1$
        setInsertStatementId("save"); //$NON-NLS-1$
        setInsertSelectiveStatementId("saveSelective"); //$NON-NLS-1$
        setSelectAllStatementId("listAll"); //$NON-NLS-1$
        setSelectByExampleStatementId("listByCriteria"); //$NON-NLS-1$
        setSelectByExampleWithBLOBsStatementId("listByCriteriaWithBLOBs"); //$NON-NLS-1$
        setSelectByPrimaryKeyStatementId("getByPrimaryKey"); //$NON-NLS-1$
        setUpdateByExampleStatementId("updateByCriteria"); //$NON-NLS-1$
        setUpdateByExampleSelectiveStatementId("updateByCriteriaSelective"); //$NON-NLS-1$
        setUpdateByExampleWithBLOBsStatementId("updateByCriteriaWithBLOBs"); //$NON-NLS-1$
        setUpdateByPrimaryKeyStatementId("updateByPrimaryKey"); //$NON-NLS-1$
        setUpdateByPrimaryKeySelectiveStatementId("updateByPrimaryKeySelective"); //$NON-NLS-1$
        setUpdateByPrimaryKeyWithBLOBsStatementId("updateByPrimaryKeyWithBLOBs"); //$NON-NLS-1$
        setBaseResultMapId("BaseResultMap"); //$NON-NLS-1$
        setResultMapWithBLOBsId("ResultMapWithBLOBs"); //$NON-NLS-1$
        setExampleWhereClauseId("Example_Where_Clause"); //$NON-NLS-1$
        setBaseColumnListId("Base_Column_List"); //$NON-NLS-1$
        setBlobColumnListId("Blob_Column_List"); //$NON-NLS-1$
        setMyBatis3UpdateByExampleWhereClauseId("Update_By_Criteria_Where_Clause"); //$NON-NLS-1$
    }

    /**
     * 创建 java mapper 生成.
     *
     * @return AbstractJavaClientGenerator
     *
     * @author  lvcyong
     * @date    2017/9/27 13:57
     */
    @Override
    protected AbstractJavaClientGenerator createJavaClientGenerator() {
        if (context.getJavaClientGeneratorConfiguration() == null) {
            return null;
        }

        String type = context.getJavaClientGeneratorConfiguration()
                .getConfigurationType();

        AbstractJavaClientGenerator javaGenerator;
        if (MapperType.XMLMAPPER.getType().equalsIgnoreCase(type)) { //$NON-NLS-1$
            javaGenerator = new JavaMapperGenerator();
        } else if (MapperType.MIXEDMAPPER.getType().equalsIgnoreCase(type)) { //$NON-NLS-1$
            javaGenerator = new MixedClientGenerator();
        } else if (MapperType.ANNOTATEDMAPPER.getType().equalsIgnoreCase(type)) { //$NON-NLS-1$
            javaGenerator = new AnnotatedClientGenerator();
        } else if (MapperType.MAPPER.getType().equalsIgnoreCase(type)) { //$NON-NLS-1$
            javaGenerator = new JavaMapperGenerator();
        } else {
            javaGenerator = (AbstractJavaClientGenerator) ObjectFactory
                    .createInternalObject(type);
        }

        return javaGenerator;
    }
}
