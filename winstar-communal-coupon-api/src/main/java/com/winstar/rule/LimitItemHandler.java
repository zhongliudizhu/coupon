package com.winstar.rule;

import com.winstar.common.RuleEum;
import com.winstar.common.RuleResolveUtil;
import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Map;

/**
 * Created by zl on 2019/5/14
 * 限商品规则处理
 */
public class LimitItemHandler implements RuleHandler {

    private final Logger logger = LoggerFactory.getLogger(LimitItemHandler.class);

    @Override
    public Object handler(String activityRule, String actionRule, Map<String, Object> param) {
        logger.info("限商品规则处理参数：" + activityRule + "<--->" + actionRule);
        String[] itemArray = getRuleValueByRules(activityRule, actionRule);
        String item = MapUtils.getString(param, RuleEum.LIMIT_ITEM.getRuleHandlerParam());
        return Arrays.asList(itemArray).contains(item);
    }

    private String[] getRuleValueByRules(String activityRule,String rule){
        return RuleResolveUtil.getOrValueByKey(activityRule, rule);
    }

}
