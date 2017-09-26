package com.lvcyong.magic.generator.plugins.comment;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.internal.DefaultCommentGenerator;

import java.util.Properties;

/**
 * <br>Filename:    MagicCommentGenerator  <br>
 * Description:     生成自定义注释
 * <br>Copyright:   Copyright (c) 2016-2017 All Rights Reserved.<br>
 * Company:     golden-soft.com Inc.<br>
 * author:     lvcyong <br>
 * version:    1.0  <br>
 * Create at:   2017-09-25 11:05 <br>
 * <p>
 * Modification History:
 * <br>Date    &nbsp;     Author      Version     Description  <br>
 * ------------------------------------------------------------------  <br>
 * 2017-09-25    lvcyong      1.0         1.0 Version  <br>
 */
public class MagicCommentGenerator extends DefaultCommentGenerator {

    /**
     * 是否生成注解
     */
    private boolean suppressAllComments;

    /**
     * Instantiates a new default comment generator.
     */
    public MagicCommentGenerator() {
        super();
    }

    @Override
    public void addJavaFileComment(CompilationUnit compilationUnit) {
        super.addJavaFileComment(compilationUnit);
    }

    /**
     * Adds a suitable comment to warn users that the element was generated, and when it was generated.
     *
     * @param xmlElement the xml element
     */
    @Override
    public void addComment(XmlElement xmlElement) {
        super.addComment(xmlElement);
    }

    @Override
    public void addRootComment(XmlElement rootElement) {
        super.addRootComment(rootElement);
    }

    @Override
    public void addConfigurationProperties(Properties properties) {
        super.addConfigurationProperties(properties);
    }

    /**
     * This method adds the custom javadoc tag for. You may do nothing if you do not wish to include the Javadoc tag -
     * however, if you do not include the Javadoc tag then the Java merge capability of the eclipse plugin will break.
     *
     * @param javaElement       the java element
     * @param markAsDoNotDelete
     */
    @Override
    protected void addJavadocTag(JavaElement javaElement, boolean markAsDoNotDelete) {
        super.addJavadocTag(javaElement, markAsDoNotDelete);
    }

    /**
     * This method returns a formated date string to include in the Javadoc tag
     * and XML comments. You may return null if you do not want the date in
     * these documentation elements.
     *
     * @return a string representing the current timestamp, or null
     */
    @Override
    protected String getDateString() {
        return super.getDateString();
    }

    @Override
    public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable) {
        super.addClassComment(innerClass, introspectedTable);
    }

    @Override
    public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        super.addModelClassComment(topLevelClass, introspectedTable);
    }

    @Override
    public void addEnumComment(InnerEnum innerEnum, IntrospectedTable introspectedTable) {
        super.addEnumComment(innerEnum, introspectedTable);
    }

    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        super.addFieldComment(field, introspectedTable, introspectedColumn);
    }

    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable) {
        super.addFieldComment(field, introspectedTable);
    }

    @Override
    public void addGeneralMethodComment(Method method, IntrospectedTable introspectedTable) {
        super.addGeneralMethodComment(method, introspectedTable);
    }

    @Override
    public void addGetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        super.addGetterComment(method, introspectedTable, introspectedColumn);
    }

    @Override
    public void addSetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        if (suppressAllComments) {
            return;
        }

        StringBuilder sb = new StringBuilder();

        method.addJavaDocLine("/**"); //$NON-NLS-1$

        Parameter parm = method.getParameters().get(0);
        sb.append(" * @param "); //$NON-NLS-1$
        sb.append(parm.getName());
        sb.append("  "); //$NON-NLS-1$
        sb.append(introspectedColumn.getRemarks());
        method.addJavaDocLine(sb.toString());

        sb.setLength(0);
        sb.append("* ");
        sb.append(introspectedTable.getFullyQualifiedTable());
        sb.append('.');
        sb.append(introspectedColumn.getActualColumnName());
        method.addJavaDocLine(sb.toString());

        addJavadocTag(method, false);

        method.addJavaDocLine(" */"); //$NON-NLS-1$
    }

    @Override
    public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable, boolean markAsDoNotDelete) {
        super.addClassComment(innerClass, introspectedTable, markAsDoNotDelete);
    }
}
