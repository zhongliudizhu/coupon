package com.winstar.rule;

import java.util.Map;

/**
 * Created by zl on 2019/5/14
 * 规则处理接口
 */
public interface RuleHandler {

    /**
     * 处理规范
     * @param activityRule 活动整体规则
     * @param rule         处理规则
     * @param param        参数map
     * @return 处理结果
     */
    Object handler(String activityRule, String rule, Map<String, Object> param);

}
