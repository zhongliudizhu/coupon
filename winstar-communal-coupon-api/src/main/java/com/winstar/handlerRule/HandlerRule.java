package com.winstar.handlerRule;

import com.alibaba.fastjson.JSON;
import com.winstar.common.RuleEum;
import com.winstar.common.RuleResolveUtil;
import com.winstar.rule.RuleHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zl on 2019/5/14
 * 处理规则
 */
public class HandlerRule {

    private static final Logger logger = LoggerFactory.getLogger(HandlerRule.class);

    /**
     * 处理规则
     * @param rules 规则
     * @param param 参数
     */
    public static boolean handlerRules(String rules, Map<String, Object> param) {
        if (StringUtils.isEmpty(rules)) {
            return true;
        }
        boolean result = true;
        List<String> ruleList = RuleResolveUtil.formatRuleExpression(rules);
        logger.info("格式化后的规则：" + JSON.toJSONString(ruleList));
        for (String ruleKey : ruleList) {
            RuleEum ruleEum = RuleEum.getRuleEnumByKey(ruleKey);
            logger.info("ruleEnum:" + JSON.toJSONString(ruleEum));
            if (!ObjectUtils.isEmpty(ruleEum)) {
                String paramKey = ruleEum.getRuleHandlerParam();
                String handlerClass = ruleEum.getRuleHandlerClass();
                logger.info("paramKey=" + paramKey + ",handlerClass=" + handlerClass);
                if (!StringUtils.isEmpty(paramKey)) {
                    RuleHandler ruleHandler = null;
                    try {
                        Class clz = Class.forName(handlerClass);
                        ruleHandler = (RuleHandler) clz.newInstance();
                    } catch (Exception e) {
                        logger.error("反射加载规则处理类出现异常");
                    }
                    if (ruleHandler != null) {
                        if (!(boolean) ruleHandler.handler(rules, ruleKey, param)) {
                            logger.info("验证规则不通过！");
                            result = false;
                            break;
                        }
                    }

                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Map<String, Object> param = new HashMap<>();
        param.put(RuleEum.FULL.getRuleHandlerParam(), 200);
        param.put(RuleEum.LIMIT_TIME.getRuleHandlerParam(), "2017/09/06 21:59:59");
        param.put(RuleEum.LIMIT_ITEM.getRuleHandlerParam(), "4");
        System.out.println(handlerRules("[doorSill]full-200_[limited]limitTime-(2017/09/6 10:00:00 ~ 2017/09/6 22:00:00)_[limited]limitItem-(1~2~3)", param));
    }

}
