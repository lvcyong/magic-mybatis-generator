package com.magic.base.criterion;

import org.apache.ibatis.jdbc.SQL;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * <br>Filename:    ClauseExample  <br>
 * Description:     mybatis 样例语句
 * <br>Copyright:   Copyright (c) 2016-2017 All Rights Reserved.<br>
 * Company:     golden-soft.com Inc.<br>
 * author:     lvcyong <br>
 * version:    1.0  <br>
 * Create at:   2017-04-10 14:08 <br>
 * <p>
 * Modification History:
 * <br>Date    &nbsp;     Author      Version     Description  <br>
 * ------------------------------------------------------------------  <br>
 * 2017-04-10    lvcyong      1.0         1.0 Version  <br>
 */
@SuppressWarnings("all")
public class Restrictions {

    public static final String IS_NULL = " IS NULL ";
    public static final String IS_NOT_NULL = " IS NOT NULL ";
    public static final String EQ = " = ";
    public static final String NE = " <> ";
    public static final String GT = " > ";
    public static final String GE = " >= ";
    public static final String LT = " < ";
    public static final String LE = " <= ";
    public static final String IN = " IN ";
    public static final String NOT_IN = " NOT IN ";
    public static final String LIKE = " LIKE ";
    public static final String NOT_LIKE = " NOT LIKE ";
    public static final String BETWEEN = " BETWEEN ";
    public static final String NOT_BETWEEN = " NOT BETWEEN ";

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public Restrictions() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * 设置排序 eg. xx desc, xxx asc
     * @param orderByClause 排序语句
     *
     * @author  lvcyong
     * @date    2017/4/11 14:09
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * 获取 排序语句
     * @return String
     *
     * @author  lvcyong
     * @date    2017/4/11 14:12
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * 设置 是否排除相同数据项
     * @param distinct true - 是， false - 否
     *
     * @author  lvcyong
     * @date    2017/4/11 14:12
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * 获取 是否排除相同数据项
     * @return boolean
     *
     * @author  lvcyong
     * @date    2017/4/11 14:13
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * 所有通过 or 链接的 Criteria
     * @return List<Criteria>
     *
     * @author  lvcyong
     * @date    2017/4/11 13:58
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * 通过 or 链接 Criteria
     * @param criteria 条件组合
     *
     * @author  lvcyong
     * @date    2017/4/11 13:59
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * 创建一个新的 Criteria，加入oredCriteria中，并与 oredCriteria 中其他 Criteria用 or 连接
     *
     * @author  lvcyong
     * @date    2017/4/11 13:59
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * 创建一个新的Criteria， 如果oredCriteria中已存在其他Criteria，则不加入 oredCriteria 中， <br>
     *     若oredCriteria中不存在其他Criteria，则加入 oredCriteria 中
     * @return Criteria
     *
     * @author  lvcyong
     * @date    2017/4/11 14:04
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * 内部创建 Criteria
     * @return Criteria
     *
     * @author  lvcyong
     * @date    2017/4/11 14:05
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * 清理所有条件
     *
     * @author  lvcyong
     * @date    2017/4/11 14:05
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * 通用 Criteria
     *
     * @author  lvcyong
     * @date    2017/4/11 14:06
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
//            if (condition == null) {
//                throw new RuntimeException("Value for condition cannot be null");
//            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value) {
//            if (value == null) {
//                throw new RuntimeException("Value for " + property + " cannot be null");
//            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2) {
//            if (value1 == null || value2 == null) {
//                throw new RuntimeException("Between values for " + property + " cannot be null");
//            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value) {
//            if (value == null) {
//                throw new RuntimeException("Value for " + property + " cannot be null");
//            }
            addCriterion(condition, new java.sql.Date(value.getTime()));
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values) {
//            if (values == null || values.size() == 0) {
//                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
//            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date((iter.next()).getTime()));
            }
            addCriterion(condition, dateList);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2) {
//            if (value1 == null || value2 == null) {
//                throw new RuntimeException("Between values for " + property + " cannot be null");
//            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()));
        }

        //----------------------------------------------------------

        /**
         * 是null column is null
         * @param column 列名
         * @return Criteria
         *
         * @author  lvcyong
         * @date    2017/4/11 10:33
         */
        public Criteria isNull(String column) {
            if (column == null) {
//                throw new RuntimeException("Is null for column cannot be null");
                return (Criteria) this;
            }
            addCriterion(column + IS_NULL);
            return (Criteria) this;
        }

        /**
         * 不是null column is not null
         * @param column 列名
         * @return Criteria
         *
         * @author  lvcyong
         * @date    2017/4/11 10:34
         */
        public Criteria isNotNull(String column) {
            if (column == null) {
//                throw new RuntimeException("Is not null for column cannot be null");
                return (Criteria) this;
            }
            addCriterion(column + IS_NOT_NULL);
            return (Criteria) this;
        }

        /**
         * 等于 column = value
         * @param column 列名
         * @param value 值
         * @return Criteria
         *
         * @author  lvcyong
         * @date    2017/4/11 10:52
         */
        public Criteria eq(String column, Object value) {
            if (value == null) {
//                throw new RuntimeException("Value for " + column + " cannot be null");
                return (Criteria) this;
            }
            if (value instanceof Date) {
                addCriterionForJDBCDate(column + EQ, (Date) value);
            } else {
                addCriterion(column + EQ, value);
            }
            return (Criteria) this;
        }

        /**
         * 不等于 column <> value
         * @param column 列名
         * @param value 值
         * @return Criteria
         *
         * @author  lvcyong
         * @date    2017/4/11 10:52
         */
        public Criteria ne(String column, Object value) {
            if (value == null) {
//                throw new RuntimeException("Value for " + column + " cannot be null");
                return (Criteria) this;
            }
            if (value instanceof Date) {
                addCriterionForJDBCDate(column + NE, (Date) value);
            } else {
                addCriterion(column + NE, value);
            }
            return (Criteria) this;
        }

        /**
         * 大于 column > value
         * @param column 列名
         * @param value 值
         * @return Criteria
         *
         * @author  lvcyong
         * @date    2017/4/11 10:52
         */
        public Criteria gt(String column, Object value) {
            if (value == null) {
//                throw new RuntimeException("Value for " + column + " cannot be null");
                return (Criteria) this;
            }
            if (value instanceof Date) {
                addCriterionForJDBCDate(column + GT, (Date) value);
            } else {
                addCriterion(column + GT, value);
            }
            return (Criteria) this;
        }

        /**
         * 大于或等于 column >= value
         * @param column 列名
         * @param value 值
         * @return Criteria
         *
         * @author  lvcyong
         * @date    2017/4/11 10:52
         */
        public Criteria ge(String column, Object value) {
            if (value == null) {
//                throw new RuntimeException("Value for " + column + " cannot be null");
                return (Criteria) this;
            }
            if (value instanceof Date) {
                addCriterionForJDBCDate(column + GE, (Date) value);
            } else {
                addCriterion(column + GE, value);
            }
            return (Criteria) this;
        }

        /**
         * 小于 column < value
         * @param column 列名
         * @param value 值
         * @return Criteria
         *
         * @author  lvcyong
         * @date    2017/4/11 10:52
         */
        public Criteria lt(String column, Object value) {
            if (value == null) {
//                throw new RuntimeException("Value for " + column + " cannot be null");
                return (Criteria) this;
            }
            if (value instanceof Date) {
                addCriterionForJDBCDate(column + LT, (Date) value);
            } else {
                addCriterion(column + LT, value);
            }
            return (Criteria) this;
        }

        /**
         * 小于或等于 column <= value
         * @param column 列名
         * @param value 值
         * @return Criteria
         *
         * @author  lvcyong
         * @date    2017/4/11 10:52
         */
        public Criteria le(String column, Object value) {
            if (value == null) {
//                throw new RuntimeException("Value for " + column + " cannot be null");
                return (Criteria) this;
            }
            if (value instanceof Date) {
                addCriterionForJDBCDate(column + LE, (Date) value);
            } else {
                addCriterion(column + LE, value);
            }
            return (Criteria) this;
        }

        /**
         * 开始以 column like value%
         * @param column 列名
         * @param value 值
         * @return Criteria
         *
         * @author  lvcyong
         * @date    2017/4/11 10:52
         */
        public Criteria startWith(String column, String value) {
            if (value == null) {
//                throw new RuntimeException("Value for " + column + " cannot be null");
                return (Criteria) this;
            }

            addCriterion(column + LIKE, value + "%");

            return (Criteria) this;
        }

        /**
         * 结束以 column like %value
         * @param column 列名
         * @param value 值
         * @return Criteria
         *
         * @author  lvcyong
         * @date    2017/4/11 10:52
         */
        public Criteria endWith(String column, String value) {
            if (value == null) {
//                throw new RuntimeException("Value for " + column + " cannot be null");
                return (Criteria) this;
            }

            addCriterion(column + LIKE, "%" + value);

            return (Criteria) this;
        }

        /**
         * 包含 column like %value%
         * @param column 列名
         * @param value 值
         * @return Criteria
         *
         * @author  lvcyong
         * @date    2017/4/11 10:52
         */
        public Criteria like(String column, String value) {
            if (value == null) {
//                throw new RuntimeException("Value for " + column + " cannot be null");
                return (Criteria) this;
            }

            addCriterion(column + LIKE, "%" + value + "%");

            return (Criteria) this;
        }

        /**
         * 不包含 column not like %value%
         * @param column 列名
         * @param value 值
         * @return Criteria
         *
         * @author  lvcyong
         * @date    2017/4/11 10:52
         */
        public Criteria notLike(String column, String value) {
            if (value == null) {
//                throw new RuntimeException("Value for " + column + " cannot be null");
                return (Criteria) this;
            }

            addCriterion(column + NOT_LIKE, "%" + value + "%");

            return (Criteria) this;
        }

        /**
         * 在列表中 column in values
         * @param column 列名
         * @param values 值
         * @return Criteria
         *
         * @author  lvcyong
         * @date    2017/4/11 10:52
         */
        public Criteria in(String column, List<?> values) {
            if (values == null || values.isEmpty()) {
//                throw new RuntimeException("Value list for " + column + " cannot be null or empty");
                return (Criteria) this;
            }
            if (values.get(0) instanceof Date) {
                addCriterionForJDBCDate(column + IN, (List<Date>) values);
            } else {
                addCriterion(column + IN, values);
            }
            return (Criteria) this;
        }

        /**
         * 不在列表中 column not in values
         * @param column 列名
         * @param values 值
         * @return Criteria
         *
         * @author  lvcyong
         * @date    2017/4/11 10:52
         */
        public Criteria notIn(String column, List<?> values) {
            if (values == null || values.isEmpty()) {
//                throw new RuntimeException("Value list for " + column + " cannot be null or empty");
                return (Criteria) this;
            }
            if (values.get(0) instanceof Date) {
                addCriterionForJDBCDate(column + NOT_IN , (List<Date>) values);
//                addCriterionForJDBCDate(column + NOT_IN, (List<Date>) values);
            } else {
                addCriterion(column + NOT_IN, values);
            }
            return (Criteria) this;
        }

        /**
         * 介于 column between value and secondValue
         * @param column 列名
         * @param value 值1
         * @param secondValue 值2
         * @return Criteria
         *
         * @author  lvcyong
         * @date    2017/4/11 10:52
         */
        public Criteria between(String column, Object value, Object secondValue) {
            if (value == null || secondValue == null) {
//                throw new RuntimeException("Between values for " + column + " cannot be null");
                return (Criteria) this;
            }
            if (!value.getClass().equals(secondValue.getClass())) {
//                throw new RuntimeException("Between values for " + column + " cannot the same type");
                return (Criteria) this;
            }
            if (value instanceof Date) {
                addCriterionForJDBCDate(column + BETWEEN, (Date) value, (Date) secondValue);
            } else {
                addCriterion(column + BETWEEN, value, secondValue);
            }
            return (Criteria) this;
        }

        /**
         * 非介于 column not between value and secondValue
         * @param column 列名
         * @param value 值1
         * @param secondValue 值2
         * @return Criteria
         *
         * @author  lvcyong
         * @date    2017/4/11 10:52
         */
        public Criteria notBetween(String column, Object value, Object secondValue) {
            if (value == null || secondValue == null) {
//                throw new RuntimeException("Between values for " + column + " cannot be null");
                return (Criteria) this;
            }
            if (!value.getClass().equals(secondValue.getClass())) {
//                throw new RuntimeException("Between values for " + column + " cannot the same type");
                return (Criteria) this;
            }
            if (value instanceof Date) {
                addCriterionForJDBCDate(column + NOT_BETWEEN, (Date) value, (Date)secondValue);
            } else {
                addCriterion(column + NOT_BETWEEN, value, secondValue);
            }
            return (Criteria) this;
        }
        //----------------------------------------------------------

    }

    /**
     * 组合条件
     *
     * @author  lvcyong
     * @date    2017/4/11 14:08
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * 单一条件
     *
     * @author  lvcyong
     * @date    2017/4/11 14:08
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }

    public static void applyWhere(SQL sql, Restrictions example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }

        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }

        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }

                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }

                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }

        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }

    public static void selectColumns(Restrictions example, String[] selectColumns, SQL sql) {
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT(selectColumns[0].contains(".")
                    ? selectColumns[0] + " as " + selectColumns[0].replace(".", "_")
                    : selectColumns[0]);
        } else {
            sql.SELECT(selectColumns[0].contains(".")
                    ? selectColumns[0] + " as " + selectColumns[0].replace(".", "_")
                    : selectColumns[0]);
            for (int i = 1; i < selectColumns.length; i++) {
                String selectColumn = selectColumns[i];
                sql.SELECT(selectColumn.contains(".")
                        ? selectColumn + " as " + selectColumn.replace(".", "_")
                        : selectColumn);
            }
        }
    }
}
