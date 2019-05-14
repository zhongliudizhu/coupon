package com.winstar.common;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by zl on 2017/9/19
 * 功能描述: 表达式解析工具
 */
public class RuleResolveUtil {

    private static final Logger logger = LoggerFactory.getLogger(RuleResolveUtil.class);

    /**
     * 格式化规则表达式
     * @param expression 表达式
     * @return 格式化结果
     */
    public static List<String> formatRuleExpression(String expression) {
        List<String> list = new ArrayList<>();
        String[] rules = expression.split("_");
        for (String rule : rules) {
            list.addAll(Arrays.asList(rule.replaceAll("\\[.*]", "").replaceAll("-.*", "").split("\\+")));
        }
        return list;
    }

    /**
     * 解析某种类型的表达式
     *
     * @param expression 表达式
     * @param type       类型
     * @return 解析后的表达式结果
     */
    private static String getRuleByType(String expression, String type) {
        return Arrays.stream(expression.split(RuleConstants.TYPE_SPLIT)).filter(rule -> rule.contains(type)).findFirst().get().replace(type, "");
    }

    /**
     * 解析和关系
     *
     * @param expression 表达式
     * @return 解析结果集合
     */
    private static List<String> resolveAndRelationship(String expression) {
        return Arrays.stream(expression.split(RuleConstants.AND)).collect(Collectors.toList());
    }

    /**
     * 解析规则表达式map
     *
     * @param expression 表达式
     * @return 解析结果map
     */
    private static Map<String, String> resolveRuleMap(String expression) {
        Map<String, String> map = new HashMap<>();
        if (expression.contains(RuleConstants.SPLIT)) {
            List list = Arrays.stream(expression.split(RuleConstants.SPLIT)).collect(Collectors.toList());
            if (list.size() == 2) {
                map.put(list.get(0).toString(), list.get(1).toString());
            }
        } else {
            map.put(expression, "");
        }
        return map;
    }

    /**
     * 获取某种类型的属性集合
     *
     * @param expression 表达式
     * @param type       类型
     * @return 属性集合
     */
    private static List<Map> getMapListByType(String expression, String type) {
        List<Map> list = new ArrayList<>();
        String typeExpression = getRuleByType(expression, type);
        List<String> typeList = resolveAndRelationship(typeExpression);
        for (String exp : typeList) {
            Map map = resolveRuleMap(exp);
            list.add(map);
        }
        return list;
    }


    /**
     * 从规则表达式中查询某个key值
     *
     * @param expression 表达式
     * @param key        key
     * @return 对应值
     */
    public static String getValueByKey(String expression, String key) {
        String ruleValue = "";
        String value = Arrays.stream(expression.split(RuleConstants.TYPE_SPLIT))
                .filter(exp -> exp.contains(key) && !exp.contains(RuleConstants.getTemplateKey(key)))
                .findFirst().get();
        String groupKey = value.substring(0, value.indexOf(RuleConstants.TYPE_SUFFIX) + 1);
        List<Map> list = getMapListByType(value, groupKey);
        for (Map map : list) {
            if (map.keySet().contains(key)) {
                ruleValue = (String) map.get(key);
            }
        }
        return ruleValue;
    }

    public static String[] getOrValueByKey(String expression, String key){
        String values = getValueByKey(expression, key);
        String[] valueArray = values.replace(RuleConstants.BRACKET_PREFIX, "").replace(RuleConstants.BRACKET_SUFFIX, "").split(RuleConstants.SECTION);
        logger.info(JSON.toJSONString(valueArray));
        return valueArray;
    }

    /**
     * 解析多条件中的表单式结果
     *
     * @param expression 表单式
     * @param value      当前值
     * @return 判断结果
     */
    public static String getOrRelationshipRuleId(String expression, int value) {
        System.out.println(expression);
        String ruleId = "";
        String[] childExpression = expression.replace(RuleConstants.BRACKET_PREFIX, "")
                .replace(RuleConstants.BRACKET_SUFFIX, "").split(RuleConstants.OR);
        for (String exp : childExpression) {
            if(exp.matches("=.*\\?.*")){
                if(value == Integer.valueOf(exp.replace("=", "").replaceAll("\\?.*", ""))){
                    ruleId = exp.replaceAll("=.*\\?", "");
                }
            }
            if (exp.matches("<.*\\?.*")) {
                if (exp.matches("<=.*\\?.*")) {
                    if (value <= Integer.valueOf(exp.replace("<=", "").replaceAll("\\?.*", ""))) {
                        ruleId = exp.replaceAll("<=.*\\?", "");
                    }
                } else {
                    if (value < Integer.valueOf(exp.replace("<", "").replaceAll("\\?.*", ""))) {
                        ruleId = exp.replaceAll("<.*\\?", "");
                    }
                }

            }
            if (exp.matches(">.*\\?.*")) {
                if (exp.matches(">=.*\\?.*")) {
                    if (value >= Integer.valueOf(exp.replace(">=", "").replaceAll("\\?.*", ""))) {
                        ruleId = exp.replaceAll(">=.*\\?", "");
                    }
                } else if(exp.matches(">.*<=.*\\?.*")){
                    if (value > Integer.valueOf(exp.replace(">", "").replaceAll("<=.*", "")) && value <= Integer.valueOf(exp.replaceAll(">.*<=", "").replaceAll("\\?.*", ""))) {
                        ruleId = exp.replaceAll(">.*\\?", "");
                    }
                } else if(exp.matches(">=.*<=.*\\?.*")){
                    if (value >= Integer.valueOf(exp.replace(">=", "").replaceAll("<=.*", "")) && value <= Integer.valueOf(exp.replaceAll(">=.*<=", "").replaceAll("\\?.*", ""))) {
                        ruleId = exp.replaceAll(">.*\\?", "");
                    }
                }else{
                    if (value > Integer.valueOf(exp.replace(">", "").replaceAll("\\?.*", ""))) {
                        ruleId = exp.replaceAll(">.*\\?", "");
                    }
                }
            }
        }
        return ruleId;
    }

}
