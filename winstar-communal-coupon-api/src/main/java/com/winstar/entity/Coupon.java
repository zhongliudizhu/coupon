package com.winstar.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * created by shibinbin on 2019/5/13
 * */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "marketing_communal_coupon")
public class Coupon {

    /***
     *
     *主键id
     */
    @Id
    @GenericGenerator(name="idGenerator", strategy="uuid")
    @GeneratedValue(generator="idGenerator")
    @Column(columnDefinition = "varchar(50) comment '主键id'")
    private String   id;
    /**
     * 优惠券编码
     * */
    @Column(columnDefinition = "varchar(50) comment '优惠券编码'")
    private String  code;
    /**
     * 名称
     * */
    @Column(columnDefinition = "varchar(200)  comment '名称'")
    private String name;
    /**
     *副标题
     * */
    @Column(columnDefinition = "varchar(255) comment '副标题'")
    private String subTitle;
    /**
     *金额
     * */
    @Column(columnDefinition = "double(10,2) comment '金额'")
    private Double amount;


    /**
     * 批次号
     * */
    @Column(columnDefinition = "varchar(50) comment '批次号'")
    private String batchNumber;


    /**
     *渠道 （wechat/app/ccb）
     * */
    @Column(columnDefinition = "varchar(50) comment '渠道'")
    private String channels;



    /**
     *使用规则表达式
     * */
    @Column(columnDefinition = "varchar(1000) comment '使用规则表达式'")
    private String useRuleExpression;


    /**
     *显示状态（yes/no）
     * */
    @Column(columnDefinition = "varchar(5) comment '显示状态'")
    private String showStatus;


    /**
     *领取状态(yes/no）
     * */
    @Column(columnDefinition = "varchar(5) comment '领取状态'")
    private String receiveStatus ;


    /**
     * 状态  del/normal
     * */
    @Column(columnDefinition = "varchar(5) comment '状态'")
    private String status ;

    /**
     *创建时间
     * */
    @Column(columnDefinition = "datetime comment '创建时间'")
    private Date createdAt;


}
