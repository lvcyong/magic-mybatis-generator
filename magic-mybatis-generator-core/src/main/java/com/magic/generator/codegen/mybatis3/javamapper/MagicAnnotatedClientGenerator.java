package com.magic.generator.codegen.mybatis3.javamapper;

import com.magic.generator.codegen.mybatis3.javamapper.elements.annotated.MagicAnnotatedSelectByExampleWithoutBLOBsMethodGenerator;
import com.magic.generator.extract.ExtractMethod;
import org.mybatis.generator.api.dom.java.CompilationUnit;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.codegen.mybatis3.javamapper.AnnotatedClientGenerator;
import org.mybatis.generator.codegen.mybatis3.javamapper.elements.AbstractJavaMapperMethodGenerator;

import java.util.List;

/**
 * <br>Filename:    MagicAnnotatedClientGenerator  <br>
 * Description:
 * <br>Copyright:   Copyright (c) 2016-2017 All Rights Reserved.<br>
 * Company:     golden-soft.com Inc.<br>
 * author:     lvcyong <br>
 * version:    1.0  <br>
 * Create at:   2017-09-27 14:49 <br>
 * <p>
 * Modification History:
 * <br>Date    &nbsp;     Author      Version     Description  <br>
 * ------------------------------------------------------------------  <br>
 * 2017-09-27    lvcyong      1.0         1.0 Version  <br>
 */
public class MagicAnnotatedClientGenerator extends AnnotatedClientGenerator {

    @Override
    public List<CompilationUnit> getCompilationUnits() {
        List<CompilationUnit> unitList = super.getCompilationUnits();

        ExtractMethod.addAnnotationForJavaMapper(unitList);

        return unitList;
    }

    @Override
    protected void addSelectByExampleWithoutBLOBsMethod(Interface interfaze) {
        if (introspectedTable.getRules().generateSelectByExampleWithoutBLOBs()) {
            AbstractJavaMapperMethodGenerator methodGenerator = new MagicAnnotatedSelectByExampleWithoutBLOBsMethodGenerator();
            initializeAndExecuteGenerator(methodGenerator, interfaze);
        }
    }
}
