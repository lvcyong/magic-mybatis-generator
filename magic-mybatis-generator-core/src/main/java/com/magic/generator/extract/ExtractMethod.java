package com.magic.generator.extract;

import org.mybatis.generator.api.dom.java.CompilationUnit;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;

import java.util.List;

/**
 * <br>Filename:    ExtractMethod  <br>
 * Description:
 * <br>Copyright:   Copyright (c) 2016-2017 All Rights Reserved.<br>
 * Company:     golden-soft.com Inc.<br>
 * author:     lvcyong <br>
 * version:    1.0  <br>
 * Create at:   2017-09-28 11:21 <br>
 * <p>
 * Modification History:
 * <br>Date    &nbsp;     Author      Version     Description  <br>
 * ------------------------------------------------------------------  <br>
 * 2017-09-28    lvcyong      1.0         1.0 Version  <br>
 */
public class ExtractMethod {

    /**
     * java mapper 文件添加注解
     * @param unitList 文件
     *
     * @author  lvcyong
     * @date    2017/9/28 11:23
     */
    public static void addAnnotationForJavaMapper(List<CompilationUnit> unitList) {
        unitList.stream()
                .filter(it -> it instanceof Interface)
                .forEach(it -> {
                    Interface anInterface = (Interface) it;

                    anInterface
                            .addImportedType(new FullyQualifiedJavaType("org.apache.ibatis.annotations.Mapper"));

                    anInterface
                            .addImportedType(new FullyQualifiedJavaType("org.springframework.stereotype.Repository"));

                    anInterface.addAnnotation("@Repository");
                    anInterface.addAnnotation("@Mapper");
                });
    }

}
