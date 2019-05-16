
package com.winstar.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * @author UU
 * @Classname Merchant
 * @Description TODO
 * @Date 2019/5/16 14:01
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "marketing_communal_merchant")
public class Merchant {

    /**
     * 唯一标识
     */
    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    @Column(columnDefinition = "varchar(50) comment '主键id'")
    private String id;

    /**
     * 商户号
     */
    @Column(columnDefinition = "varchar(50) comment '商户号'")
    private String number;

    /**
     * 商户名称
     */
    @Column(columnDefinition = "varchar(50) comment '商户名称'")
    private String name;

    /**
     * 商户密钥
     */
    @Column(columnDefinition = "varchar(50) comment '商户密钥'")
    private String secret;

    /**
     * 商户备注
     */
    @Column(columnDefinition = "varchar(50) comment '商户备注'")
    private String remark;

    /**
     * 商户状态
     */
    @Column(columnDefinition = "varchar(10) comment '商户状态'")
    private String status;

    /**
     * 创建时间
     */
    @Column(columnDefinition = "datetime comment '创建时间'")
    private Date createdAt;

}
