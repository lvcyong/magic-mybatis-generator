package com.magic.generator.plugins.comment;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.config.PropertyRegistry;
import org.mybatis.generator.internal.util.StringUtility;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import static org.mybatis.generator.internal.util.StringUtility.isTrue;

/**
 * <br>Filename:    MagicCommentGenerator  <br>
 * Description:     生成自定义注释
 * <br>Copyright:   Copyright (c) 2016-2017 All Rights Reserved.<br>
 * Company:     lvcyong.com Inc.<br>
 * author:     lvcyong <br>
 * version:    1.0  <br>
 * Create at:   2017-09-25 11:05 <br>
 * <p>
 * Modification History:
 * <br>Date    &nbsp;     Author      Version     Description  <br>
 * ------------------------------------------------------------------  <br>
 * 2017-09-25    lvcyong      1.0         1.0 Version  <br>
 */
public class MagicCommentGenerator implements CommentGenerator {

    /**
     * 属性
     */
    private Properties properties;

    /**
     * 是否生成日期注释
     */
    private boolean suppressDate;

    /**
     * 是否生成注释
     */
    private boolean suppressAllComments;

    /**
     * 是否添加表及字段说明注释
     */
    private boolean addRemarkComments;

    /**
     * 日式格式化
     */
    private SimpleDateFormat dateFormat;

    /**
     * 注释作者
     */
    private String author;

    public MagicCommentGenerator() {
        this.properties = new Properties();
        this.suppressDate = false;
        this.suppressAllComments = false;
        this.addRemarkComments = false;
        this.author = "";
    }

    /**
     * Adds properties for this instance from any properties configured in the
     * CommentGenerator configuration.
     * <p>
     * This method will be called before any of the other methods.
     *
     * @param properties All properties from the configuration
     */
    public void addConfigurationProperties(Properties properties) {
        this.properties.putAll(properties);

        suppressDate = isTrue(properties
                .getProperty(PropertyRegistry.COMMENT_GENERATOR_SUPPRESS_DATE));

        suppressAllComments = isTrue(properties
                .getProperty(PropertyRegistry.COMMENT_GENERATOR_SUPPRESS_ALL_COMMENTS));

        addRemarkComments = isTrue(properties
                .getProperty(PropertyRegistry.COMMENT_GENERATOR_ADD_REMARK_COMMENTS));

        String dateFormatString = properties.getProperty(PropertyRegistry.COMMENT_GENERATOR_DATE_FORMAT);
        if (StringUtility.stringHasValue(dateFormatString)) {
            dateFormat = new SimpleDateFormat(dateFormatString);
        }

        // 作者
        String authorString = properties.getProperty("author");
        if (StringUtility.stringHasValue(authorString)) {
            author = authorString;
        } else {
            author = "";
        }
    }

    /**
     * 数据库列对应字段添加注释
     *
     * @param field              字段
     * @param introspectedTable  表
     * @param introspectedColumn 列
     *
     * @author  lvcyong
     * @date    2017/9/26 14:12
     */
    public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        if (suppressAllComments) {
            return;
        }

        field.addJavaDocLine("/**"); //$NON-NLS-1$

        String remarks = introspectedColumn.getRemarks();
        if (remarks == null) {
            remarks = "";
        } else {
            remarks = remarks.trim();
        }

        if (addRemarkComments && StringUtility.stringHasValue(remarks)) {
            String[] remarkLines = remarks.split(System.getProperty("line.separator"));  //$NON-NLS-1$
            for (String remarkLine : remarkLines) {
                field.addJavaDocLine(" * " + remarkLine);  //$NON-NLS-1$
            }
        }

        field.addJavaDocLine(" * <br>"); //$NON-NLS-1$

        String sb = " * 该字段对应的数据库列为 " +
                introspectedTable.getFullyQualifiedTable() +
                '.' +
                introspectedColumn.getActualColumnName();
        field.addJavaDocLine(sb);

        addJavadocTag(field, false);

        field.addJavaDocLine(" */"); //$NON-NLS-1$
    }

    /**
     * 字段添加注释
     *
     * @param field             字段
     * @param introspectedTable 表
     *
     * @author  lvcyong
     * @date    2017/9/26 14:13
     */
    public void addFieldComment(Field field, IntrospectedTable introspectedTable) {
        /*if (suppressAllComments) {
            return;
        }

        StringBuilder sb = new StringBuilder();

        field.addJavaDocLine("*//**"); //$NON-NLS-1$
        field
                .addJavaDocLine(" * This field was generated by MyBatis Generator."); //$NON-NLS-1$

        sb.append(" * This field corresponds to the database table "); //$NON-NLS-1$
        sb.append(introspectedTable.getFullyQualifiedTable());
        field.addJavaDocLine(sb.toString());

        addJavadocTag(field, false);

        field.addJavaDocLine(" *//*"); //$NON-NLS-1$*/
    }

    /**
     * Model 类注释
     *
     * @param topLevelClass     类
     * @param introspectedTable 表
     *
     * @author  lvcyong
     * @date    2017/9/26 14:15
     */
    public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        if (suppressAllComments  || !addRemarkComments) {
            return;
        }

        topLevelClass.addJavaDocLine("/**"); //$NON-NLS-1$

        String remarks = introspectedTable.getRemarks();
        if (remarks == null) {
            remarks = "";
        } else {
            remarks = remarks.trim();
        }

        if (addRemarkComments && StringUtility.stringHasValue(remarks)) {
            topLevelClass.addJavaDocLine(" * 说明:");
            String[] remarkLines = remarks.split(System.getProperty("line.separator"));  //$NON-NLS-1$
            for (String remarkLine : remarkLines) {
                topLevelClass.addJavaDocLine(" *   " + remarkLine);  //$NON-NLS-1$
            }
        } else {
            topLevelClass.addJavaDocLine(" * 说明: ");
        }
        topLevelClass.addJavaDocLine(" * <br>"); //$NON-NLS-1$


        StringBuilder sb = new StringBuilder();
        sb.append(" * 该实体类对应的数据库表为 ");
        sb.append(introspectedTable.getFullyQualifiedTable());

        topLevelClass.addJavaDocLine(sb.toString());
        topLevelClass.addJavaDocLine(" *");
        topLevelClass.addJavaDocLine(" * @author " + author);
        topLevelClass.addJavaDocLine(" * @date " + getDateString());

        addJavadocTag(topLevelClass, true);

        topLevelClass.addJavaDocLine(" */"); //$NON-NLS-1$

    }

    /**
     * 添加内部类注释.
     *
     * @param innerClass        类
     * @param introspectedTable 表
     */
    public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable) {
        if (suppressAllComments) {
            return;
        }

        StringBuilder sb = new StringBuilder();

        innerClass.addJavaDocLine("/**"); //$NON-NLS-1$
        sb.append(" * 该类对应的数据库表为 ");
        sb.append(introspectedTable.getFullyQualifiedTable());
        innerClass.addJavaDocLine(sb.toString());

        addJavadocTag(innerClass, false);

        innerClass.addJavaDocLine(" */"); //$NON-NLS-1$
    }

    /**
     * 添加内部类注释.
     *
     * @param innerClass        内部类
     * @param introspectedTable 表
     * @param markAsDoNotDelete 是否标记为不能删除
     *
     * @author  lvcyong
     * @date    2017/9/26 14:00
     */
    public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable, boolean markAsDoNotDelete) {
        if (suppressAllComments) {
            return;
        }

        StringBuilder sb = new StringBuilder();

        innerClass.addJavaDocLine("/**"); //$NON-NLS-1$
        sb.append(" * 该类对应的数据库表为 ");
        sb.append(introspectedTable.getFullyQualifiedTable());
        innerClass.addJavaDocLine(sb.toString());

        addJavadocTag(innerClass, markAsDoNotDelete);

        innerClass.addJavaDocLine(" */"); //$NON-NLS-1$
    }

    /**
     * 添加内部枚举类注释
     *
     * @param innerEnum         枚举
     * @param introspectedTable 表
     *
     * @author  lvcyong
     * @date    2017/9/26 13:58
     */
    public void addEnumComment(InnerEnum innerEnum, IntrospectedTable introspectedTable) {
        if (suppressAllComments) {
            return;
        }

        StringBuilder sb = new StringBuilder();

        innerEnum.addJavaDocLine("/**"); //$NON-NLS-1$
        innerEnum
                .addJavaDocLine(" * This enum was generated by MyBatis Generator."); //$NON-NLS-1$

        sb.append(" * This enum corresponds to the database table "); //$NON-NLS-1$
        sb.append(introspectedTable.getFullyQualifiedTable());
        innerEnum.addJavaDocLine(sb.toString());

        addJavadocTag(innerEnum, false);

        innerEnum.addJavaDocLine(" */"); //$NON-NLS-1$
    }

    /**
     * 添加 getter 方法注释.
     *
     * @param method             方法
     * @param introspectedTable  表
     * @param introspectedColumn 列
     *
     * @author  lvcyong
     * @date    2017/9/26 13:47
     */
    public void addGetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        if (suppressAllComments) {
            return;
        }

        StringBuilder sb = new StringBuilder();

        method.addJavaDocLine("/**"); //$NON-NLS-1$

        method.addJavaDocLine(" * 获取 " + introspectedColumn.getRemarks()); //$NON-NLS-1$
        method.addJavaDocLine(" *");

        sb.setLength(0);
        sb.append(" * @return "); //$NON-NLS-1$
        sb.append(introspectedTable.getFullyQualifiedTable());
        sb.append('.');
        sb.append(introspectedColumn.getActualColumnName());
        method.addJavaDocLine(sb.toString());

        addJavadocTag(method, false);

        method.addJavaDocLine(" */"); //$NON-NLS-1$
    }

    /**
     * 添加 setter 方法注释.
     *
     * @param method             方法
     * @param introspectedTable  表
     * @param introspectedColumn 列
     *
     * @author  lvcyong
     * @date    2017/9/26 13:46
     */
    public void addSetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        if (suppressAllComments) {
            return;
        }

        StringBuilder sb = new StringBuilder();

        method.addJavaDocLine("/**"); //$NON-NLS-1$
        method.addJavaDocLine(" * 设置 " + introspectedColumn.getRemarks());
        method.addJavaDocLine(" *");

        sb.append(" * @param "); //$NON-NLS-1$
        sb.append(method.getParameters().get(0).getName());
        sb.append(" "); //$NON-NLS-1$
        sb.append(introspectedColumn.getRemarks());
        method.addJavaDocLine(sb.toString());

        sb.setLength(0);
        sb.append(" * ");
        sb.append(introspectedTable.getFullyQualifiedTable());
        sb.append('.');
        sb.append(introspectedColumn.getActualColumnName());
        method.addJavaDocLine(sb.toString());

        addJavadocTag(method, false);

        method.addJavaDocLine(" */"); //$NON-NLS-1$
    }

    /**
     * 添加方法注释.
     *
     * @param method            方法
     * @param introspectedTable 表
     *
     * @author  lvcyong
     * @date    2017/9/26 13:55
     */
    public void addGeneralMethodComment(Method method, IntrospectedTable introspectedTable) {
        if (suppressAllComments) {
            return;
        }

        // 方法注释
        String methodComm = "";
        // 参数
        List<Parameter> paramList = method.getParameters();
        // 参数注释
        List<String> paramCommList = new ArrayList<>();
        paramList.forEach(it -> paramCommList.add(""));

        if ("deleteByPrimaryKey".equals(method.getName())) {
            methodComm = "通过主键删除";
            paramCommList.add(0, "主键");
        } else if ("insert".equals(method.getName())) {
            methodComm = "插入";
            paramCommList.add(0, "插入数据");
        } else if ("insertSelective".equals(method.getName())) {
            methodComm = "选择性插入(只插入非 null 数据)";
            paramCommList.add(0, "插入数据");
        } else if ("selectByPrimaryKey".equals(method.getName())) {
            methodComm = "通过主键查询";
            paramCommList.add(0, "主键");
        } else if ("updateByPrimaryKey".equals(method.getName())) {
            methodComm = "通过主键更新";
            paramCommList.add(0, "更新数据");
        } else if ("updateByPrimaryKeySelective".equals(method.getName())) {
            methodComm = "通过主键选择性更新(只更新非 null 数据)";
            paramCommList.add(0, "更新数据");
        } else if ("selectAll".equals(method.getName())) {
            methodComm = "查询全部";
        } else if ("countByExample".equals(method.getName())) {
            methodComm = "通过 ClauseExample 条件统计数量";
            paramCommList.add(0, "条件");
        } else if ("deleteByExample".equals(method.getName())) {
            methodComm = "通过 ClauseExample 条件删除";
            paramCommList.add(0, "条件");
            paramCommList.add(1, "查询列");
        } else if ("selectByExample".equals(method.getName())) {
            methodComm = "通过 ClauseExample 条件查询";
            paramCommList.add(0, "条件");
            paramCommList.add(1, "查询列");
        } else if ("updateByExampleSelective".equals(method.getName())) {
            methodComm = "通过 ClauseExample 条件选择性更新(只更新非 null 数据)";
            paramCommList.add(0, "更新数据");
            paramCommList.add(1, "条件");
        } else if ("updateByExample".equals(method.getName())) {
            methodComm = "通过 ClauseExample 条件更新";
            paramCommList.add(0, "更新数据");
            paramCommList.add(1, "条件");
        } else if ("selectByExampleWithBLOBs".equals(method.getName())) {
            methodComm = "通过 ClauseExample 条件查询(含BLOBs)";
            paramCommList.add(0, "条件");
            paramCommList.add(1, "查询列");
        } else if ("updateByExampleWithBLOBs".equals(method.getName())) {
            methodComm = "通过 ClauseExample 条件更新(含BLOBs)";
            paramCommList.add(0, "更新数据");
            paramCommList.add(1, "条件");
        } else if ("updateByPrimaryKeyWithBLOBs".equals(method.getName())) {
            methodComm = "通过主键更新(含BLOBs)";
            paramCommList.add(0, "更新数据");
        }

        method.addJavaDocLine("/**");
        method.addJavaDocLine(" * " + methodComm);

        if (!paramList.isEmpty()) {
            method.addJavaDocLine(" *");
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < paramList.size(); i++) {
                sb.setLength(0);
                sb.append(" * @param "); //$NON-NLS-1$
                sb.append(paramList.get(i).getName());
                sb.append(" "); //$NON-NLS-1$
                sb.append(paramCommList.get(i));
                method.addJavaDocLine(sb.toString());
            }
        }


        method.addJavaDocLine(" *");
        method.addJavaDocLine(" * @author " + author);
        method.addJavaDocLine(" * @date " + getDateString());

        method.addJavaDocLine(" */");
    }

    /**
     * This method is called to add a file level comment to a generated java file. This method could be used to add a
     * general file comment (such as a copyright notice). However, note that the Java file merge function in Eclipse
     * does not deal with this comment. If you run the generator repeatedly, you will only retain the comment from the
     * initial run.
     * <p>
     * <p>
     * The default implementation does nothing.
     *
     * @param compilationUnit the compilation unit
     */
    public void addJavaFileComment(CompilationUnit compilationUnit) {

    }

    /**
     * This method should add a suitable comment as a child element of the specified xmlElement to warn users that the
     * element was generated and is subject to regeneration.
     *
     * @param xmlElement the xml element
     */
    public void addComment(XmlElement xmlElement) {

    }

    /**
     * This method is called to add a comment as the first child of the root element. This method could be used to add a
     * general file comment (such as a copyright notice). However, note that the XML file merge function does not deal
     * with this comment. If you run the generator repeatedly, you will only retain the comment from the initial run.
     * <p>
     * <p>
     * The default implementation does nothing.
     *
     * @param rootElement the root element
     */
    public void addRootComment(XmlElement rootElement) {

    }

    /**
     * 添加自定义javadoc标签
     * @param javaElement 元素
     * @param markAsDoNotDelete 是否标记为不能删除
     *
     * @author  lvcyong
     * @date    2017/9/26 11:58
     */
    protected void addJavadocTag(JavaElement javaElement,
                                 boolean markAsDoNotDelete) {

        /*javaElement.addJavaDocLine(" *"); //$NON-NLS-1$
        StringBuilder sb = new StringBuilder();
        sb.append(" * "); //$NON-NLS-1$
        sb.append(MergeConstants.NEW_ELEMENT_TAG);
        if (markAsDoNotDelete) {
            sb.append(" 合并时不删除 "); //$NON-NLS-1$
        }
        String s = getDateString();
        if (s != null) {
            sb.append(' ');
            sb.append(s);
        }
        javaElement.addJavaDocLine(sb.toString());*/
    }

    /**
     * 获取当前日期
     * @return yyyy-MM-dd
     *
     * @author  lvcyong
     * @date    2017/9/26 11:47
     */
    protected String getDateString() {
        if (suppressDate) {
            return null;
        } else if (dateFormat != null) {
            return dateFormat.format(new Date());
        } else {
            return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm"));
        }
    }
}
