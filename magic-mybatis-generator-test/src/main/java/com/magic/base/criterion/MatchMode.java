package com.magic.base.criterion;

/**
 * <br>Filename:    MatchMode  <br>
 * Description:     使用“like”匹配字符串的策略
 * <br>Copyright:   Copyright (c) 2016-2017 All Rights Reserved.<br>
 * Company:     golden-soft.com Inc.<br>
 * author:     lvcyong <br>
 * version:    1.0  <br>
 * Create at:   2017-09-26 15:51 <br>
 * <p>
 * Modification History:
 * <br>Date    &nbsp;     Author      Version     Description  <br>
 * ------------------------------------------------------------------  <br>
 * 2017-09-26    lvcyong      1.0         1.0 Version  <br>
 */
public enum MatchMode {
    /**
     * 将整个字符串与模式匹配
     */
    EXACT {
        @Override
        public String toMatchString(String pattern) {
            return pattern;
        }
    },

    /**
     * 将字符串的开头与模式相匹配
     */
    START {
        @Override
        public String toMatchString(String pattern) {
            return pattern + '%';
        }
    },

    /**
     * 将字符串的末尾与模式匹配
     */
    END {
        @Override
        public String toMatchString(String pattern) {
            return '%' + pattern;
        }
    },

    /**
     * 匹配字符串中任何位置的模式
     */
    ANYWHERE {
        @Override
        public String toMatchString(String pattern) {
            return '%' + pattern + '%';
        }
    };

    /**
     * 转换模式，通过追加/预设“％”
     *
     * @param pattern 需要转换的模式
     *
     * @return 转换模式
     */
    public abstract String toMatchString(String pattern);
}
