package com.winstar.rule;

import com.winstar.common.RuleEum;
import com.winstar.common.RuleResolveUtil;
import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Created by zl on 2017/9/19
 * 满减规则处理
 */
public class FullRuleHandler implements RuleHandler {

    private final Logger logger = LoggerFactory.getLogger(FullRuleHandler.class);

    @Override
    public Object handler(String activityRule, String actionRule, Map<String, Object> param) {
        logger.info("满多少规则处理参数：" + activityRule + "<--->" + actionRule);
        return MapUtils.getDoubleValue(param, RuleEum.FULL.getRuleHandlerParam()) >= Integer.valueOf(getRuleValueByRules(activityRule, actionRule));
    }

    private String getRuleValueByRules(String activityRule,String rule){
        return RuleResolveUtil.getValueByKey(activityRule, rule);
    }

}
