package com.winstar.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by zl on 2017/9/19
 * 功能描述: 规则枚举
 */
@SuppressWarnings("unused")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum RuleEum {

    /**
     * 规则枚举值
     */
    FULL("full", "满", "com.winstar.rule.FullRuleHandler", "money", ""),
    LIMIT_TIME("limitTime", "限时", "com.winstar.rule.LimitTimeHandler", "time", ""),
    LIMIT_ITEM("limitItem", "限商品", "com.winstar.rule.LimitItemHandler", "itemId", ""),

    //-------------以下暂时未使用-----------------------------
    LAST_MONTH_FULL("lastMonthFull", "上月满", "com.winstar.rule.LastMonthFullRuleHandler", "lastMonthConsumptionAmount", ""),
    ORDER_RANKING("orderRanking", "下单排行", "com.winstar.rule.OrderRankingRuleHandler", "orderRanking", ""),
    GIVE_ITEM("giveItem", "赠商品", "com.winstar.rule.GiveItemRuleHandler", "account", ""),
    GIVE_RED_PACKET("giveRedPacket", "赠红包", "com.winstar.rule.GiveRedPacketRuleHandler", "account", "com.winstar.infrastructure.domain.RedPacket"),
    GIVE_COUPON("giveCoupon", "赠券", "com.winstar.rule.GiveCouponRuleHandler", "account", "com.winstar.infrastructure.domain.Coupon"),
    REDUCE("reduce", "减", "com.winstar.rule.ReduceRuleHandler", "account", ""),
    DISCOUNT("discount", "折", "com.winstar.rule.DiscountRuleHandler", "account", ""),
    LIMIT_FREQUENCY0("limitFrequency0", "限频次-首次", "com.winstar.rule.FirstOrderLimitFrequencyRuleHandler", "isFirstOrder", ""),
    LIMIT_FREQUENCY1("limitFrequency1", "限频次-每日一次", "", "", ""),
    LIMIT_FREQUENCY2("limitFrequency2", "限频次-每周一次", "", "", ""),
    LIMIT_FREQUENCY3("limitFrequency3", "限频次-每月一次", "", "", ""),
    LIMIT_FREQUENCY4("limitFrequency4", "限频次-每季度一次", "", "", ""),
    LIMIT_FREQUENCY5("limitFrequency5", "限频次-每年一次", "", "", ""),
    LIMIT_QUANTITY("limitQuantity", "限量", "com.winstar.rule.LimitQuantityHandler", "", "");

    /**
     * 规则key
     */
    private String key;
    /**
     * 描述
     */
    private String description;
    /**
     * 规则处理类
     */
    private String ruleHandlerClass;
    /**
     * 规则处理参数
     */
    private String ruleHandlerParam;

    /**
     * 规则行为结果类
     */
    private String ruleResultClass;

    public static RuleEum getRuleEnumByKey(String key) {
        RuleEum ruleEum = null;
        RuleEum[] ruleEums = RuleEum.values();
        for (RuleEum eum : ruleEums) {
            if (eum.getKey().equals(key)) {
                ruleEum = eum;
            }
        }
        return ruleEum;
    }
}
