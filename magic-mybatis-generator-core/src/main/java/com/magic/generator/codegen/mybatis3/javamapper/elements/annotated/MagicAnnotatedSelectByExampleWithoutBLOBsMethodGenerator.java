package com.magic.generator.codegen.mybatis3.javamapper.elements.annotated;

import com.magic.generator.constant.MagicConstants;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.codegen.mybatis3.javamapper.elements.annotated.AnnotatedSelectByExampleWithoutBLOBsMethodGenerator;

import java.util.Set;
import java.util.TreeSet;

import static org.mybatis.generator.internal.util.messages.Messages.getString;

/**
 * <br>Filename:    MagicAnnotatedSelectByExampleWithoutBLOBsMethodGenerator  <br>
 * Description:
 * <br>Copyright:   Copyright (c) 2016-2017 All Rights Reserved.<br>
 * Company:     lvcyong.com Inc.<br>
 * author:     lvcyong <br>
 * version:    1.0  <br>
 * Create at:   2017-09-27 15:18 <br>
 * <p>
 * Modification History:
 * <br>Date    &nbsp;     Author      Version     Description  <br>
 * ------------------------------------------------------------------  <br>
 * 2017-09-27    lvcyong      1.0         1.0 Version  <br>
 */
public class MagicAnnotatedSelectByExampleWithoutBLOBsMethodGenerator
        extends AnnotatedSelectByExampleWithoutBLOBsMethodGenerator {

    @Override
    public void addInterfaceElements(Interface interfaze) {

        Set<FullyQualifiedJavaType> importedTypes = new TreeSet<FullyQualifiedJavaType>();
        FullyQualifiedJavaType type = new FullyQualifiedJavaType(
                introspectedTable.getExampleType());
        importedTypes.add(type);
        importedTypes.add(FullyQualifiedJavaType.getNewListInstance());

        Method method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);

        FullyQualifiedJavaType returnType = FullyQualifiedJavaType
                .getNewListInstance();
        FullyQualifiedJavaType listType;
        if (introspectedTable.getRules().generateBaseRecordClass()) {
            listType = new FullyQualifiedJavaType(introspectedTable
                    .getBaseRecordType());
        } else if (introspectedTable.getRules().generatePrimaryKeyClass()) {
            listType = new FullyQualifiedJavaType(introspectedTable
                    .getPrimaryKeyType());
        } else {
            throw new RuntimeException(getString("RuntimeError.12")); //$NON-NLS-1$
        }

        importedTypes.add(listType);
        returnType.addTypeArgument(listType);
        method.setReturnType(returnType);

        method.setName(introspectedTable.getSelectByExampleStatementId());
        //FIXME >>>>>>>>>>
        method.addParameter(new Parameter(type,
                MagicConstants.EXAMPLE_PARAM_NAME,
                "@Param(\"" + MagicConstants.EXAMPLE_PARAM_NAME + "\")")); //$NON-NLS-1$

        method.addParameter(new Parameter(new FullyQualifiedJavaType("String..."),
                MagicConstants.SELECT_COLUMNS_PARAM_NAME,
                "@Param(\"" + MagicConstants.SELECT_COLUMNS_PARAM_NAME + "\")"));
        //<<<<<<<<<<

        context.getCommentGenerator().addGeneralMethodComment(method,
                introspectedTable);

        addMapperAnnotations(interfaze, method);

        //FIXME >>>>>>>>>>
        // 导入 provider
        importedTypes.add(new FullyQualifiedJavaType(introspectedTable.getMyBatis3SqlProviderType()));
        //<<<<<<<<<<

        if (context.getPlugins()
                .clientSelectByExampleWithoutBLOBsMethodGenerated(method,
                        interfaze, introspectedTable)) {
            interfaze.addImportedTypes(importedTypes);
            interfaze.addMethod(method);
        }


        super.addInterfaceElements(interfaze);

    }
}
