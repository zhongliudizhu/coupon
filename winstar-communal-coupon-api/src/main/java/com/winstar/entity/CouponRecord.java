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
@Table(name = "marketing_communal_record")
public class CouponRecord {

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
     * 优惠券ID
     * */
    @Column(columnDefinition = "varchar(50) comment '优惠券ID'")
    private String  couponId;

    /**
     * 领取商户
     * */
    @Column(columnDefinition = "varchar(50) comment '领取商户'")
    private String  merchant;
    /**
     * 领取时间
     * */
    @Column(columnDefinition = "datetime comment '领取时间'")
    private Date  createdAt;
    /**
     * 使用状态(yes/no)
     * */
    @Column(columnDefinition = "varchar(5) comment '使用状态(yes/no)'")
    private String  useStatus;
    /**
     * 使用时间
     * */
    @Column(columnDefinition = "datetime comment '使用时间'")
    private Date  useAt;
    /**
     * 失效时间
     * */
    @Column(columnDefinition = "datetime comment '失效时间'")
    private Date expireAt;
}
