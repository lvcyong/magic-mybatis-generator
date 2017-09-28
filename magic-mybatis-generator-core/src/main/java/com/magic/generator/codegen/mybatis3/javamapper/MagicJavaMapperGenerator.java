package com.magic.generator.codegen.mybatis3.javamapper;

import com.magic.generator.extract.ExtractMethod;
import org.mybatis.generator.api.dom.java.CompilationUnit;
import org.mybatis.generator.codegen.mybatis3.javamapper.JavaMapperGenerator;

import java.util.List;

/**
 * <br>Filename:    MagicJavaMapperGenerator  <br>
 * Description:
 * <br>Copyright:   Copyright (c) 2016-2017 All Rights Reserved.<br>
 * Company:     golden-soft.com Inc.<br>
 * author:     lvcyong <br>
 * version:    1.0  <br>
 * Create at:   2017-09-27 14:46 <br>
 * <p>
 * Modification History:
 * <br>Date    &nbsp;     Author      Version     Description  <br>
 * ------------------------------------------------------------------  <br>
 * 2017-09-27    lvcyong      1.0         1.0 Version  <br>
 */
public class MagicJavaMapperGenerator extends JavaMapperGenerator {

    @Override
    public List<CompilationUnit> getCompilationUnits() {
        List<CompilationUnit> unitList = super.getCompilationUnits();

        ExtractMethod.addAnnotationForJavaMapper(unitList);

        return unitList;
    }
}
