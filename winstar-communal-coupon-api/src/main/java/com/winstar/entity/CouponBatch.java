package com.winstar.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * created by s on 2019/5/13
 * */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "marketing_communal_batch")
public class CouponBatch {
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
     * 批次号
     * */
    @Column(columnDefinition = "varchar(50) comment '批次号'")
    private String  batchNumber;
    /**
     * 批次总量
     * */
    @Column(columnDefinition = "int  comment '批次总量'")
    private int totalNumber;
    /**
     * 模板ID
     * */
    @Column(columnDefinition = "varchar(50) comment '模板ID'")
    private String templateId;
    /**
     * 渠道（wechat/app/ccb）
     * */
    @Column(columnDefinition = "varchar(50) comment '渠道wechat/app/ccb'")
    private String channels;
    /**
     *创建时间
     * */
    @Column(columnDefinition = "datetime comment '创建时间'")
    private Date createdAt;



}
