package com.magic.generator.enums;

/**
 * <br>Filename:    MapperType  <br>
 * Description:     mapper 生成类型
 * <br>Copyright:   Copyright (c) 2016-2017 All Rights Reserved.<br>
 * Company:     golden-soft.com Inc.<br>
 * author:     lvcyong <br>
 * version:    1.0  <br>
 * Create at:   2017-09-27 13:58 <br>
 * <p>
 * Modification History:
 * <br>Date    &nbsp;     Author      Version     Description  <br>
 * ------------------------------------------------------------------  <br>
 * 2017-09-27    lvcyong      1.0         1.0 Version  <br>
 */
public enum MapperType {
    /**
     * 所有的方法都在XML中，接口调用依赖XML文件
     */
    XMLMAPPER {
        @Override
        public String getType() {
            return "XMLMAPPER";
        }
    },
    /**
     * XML和注解的混合形式，(上面这种情况中的)SqlProvider注解方法会被XML替代<br>
     *     targetRuntime=MyBatis3 独有
     */
    MIXEDMAPPER {
        @Override
        public String getType() {
            return "MIXEDMAPPER";
        }
    },
    /**
     * 基于注解的Mapper接口，不会有对应的XML映射文件
     */
    ANNOTATEDMAPPER {
        @Override
        public String getType() {
            return "ANNOTATEDMAPPER";
        }
    },
    /**
     *
     */
    MAPPER {
        @Override
        public String getType() {
            return "MAPPER";
        }
    }
    ;

    public abstract String getType();
}
