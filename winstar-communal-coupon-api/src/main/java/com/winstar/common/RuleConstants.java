package com.winstar.common;

/**
 * Created by zl on 2017/9/19
 * 功能描述: 规则常量
 */
public class RuleConstants {

    public final static String DOOR_SILL = "[doorSill]";
    public final static String ACTION = "[action]";
    public final static String LIMITED = "[limited]";
    public final static String SPLIT = "-";
    public final static String TYPE_SPLIT = "_";
    public final static String AND = "\\+";
    public final static String OR = "\\|\\|";
    public final static String SECTION = "~";
    public final static String GREATER = ">";
    public final static String LESS = "<";
    public final static String VARIABLE_TEMPLATE_PREFIX = "{{";
    public final static String VARIABLE_TEMPLATE_SUFFIX = "}}";
    public final static String TYPE_SUFFIX = "]";
    public final static String BRACKET_PREFIX = "(";
    public final static String BRACKET_SUFFIX = ")";

    public static String getTemplateKey(String key) {
        return VARIABLE_TEMPLATE_PREFIX + key + VARIABLE_TEMPLATE_SUFFIX;
    }
}
