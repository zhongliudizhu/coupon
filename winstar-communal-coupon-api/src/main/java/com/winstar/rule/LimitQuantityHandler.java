package com.winstar.rule;

import java.util.Map;

/**
 * Created by zl on 2019/5/14
 * 限量规则处理
 */
public class LimitQuantityHandler implements RuleHandler {

    @Override
    public Object handler(String activityRule, String actionRule, Map<String, Object> param) {
        return true;
    }

}
