package com.junmoyu.venus.cloud.starter.core.util;

import com.junmoyu.venus.cloud.starter.core.exception.BizException;
import org.apache.commons.lang3.StringUtils;

/**
 * SQL 工具类
 *
 * @author moyu.jun
 * @date 2021/12/18
 */
public class SqlUtils {
    /**
     * 仅支持字母、数字、下划线、空格、逗号、小数点（支持多个字段排序）
     */
    public static String SQL_PATTERN = "[a-zA-Z0-9_ ,.]+";

    /**
     * 检查字符，防止注入绕过
     */
    public static String escapeOrderBySql(String value) {
        if (StringUtils.isNotEmpty(value) && !isValidOrderBySql(value)) {
            throw new BizException("参数不符合规范，不能进行查询");
        }
        return value;
    }

    /**
     * 验证 order by 语法是否符合规范
     */
    public static boolean isValidOrderBySql(String value) {
        return value.matches(SQL_PATTERN);
    }
}
