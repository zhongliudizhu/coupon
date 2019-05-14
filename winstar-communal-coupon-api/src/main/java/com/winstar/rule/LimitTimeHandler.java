package com.winstar.rule;

import com.winstar.common.RuleEum;
import com.winstar.common.RuleResolveUtil;
import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

/**
 * Created by zl on 2019/5/14
 * 限时规则处理
 */
public class LimitTimeHandler implements RuleHandler{

    private final Logger logger = LoggerFactory.getLogger(LimitTimeHandler.class);

    @Override
    public Object handler(String activityRule, String actionRule, Map<String, Object> param) {
        logger.info("限时规则处理参数：" + activityRule + "<--->" + actionRule);
        String[] timeArray = getRuleValueByRules(activityRule, actionRule);
        String time = MapUtils.getString(param, RuleEum.LIMIT_TIME.getRuleHandlerParam());
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        try {
            return format.parse(time).after(format.parse(timeArray[0])) && format.parse(time).before(format.parse(timeArray[1]));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

    private String[] getRuleValueByRules(String activityRule,String rule){
        return RuleResolveUtil.getOrValueByKey(activityRule, rule);
    }

}
