package winstar.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by zl on 2019/5/13
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "marketing_communal_coupon_template")
public class CouponTemplate {

    /**
     * 唯一标识
     */
    @Id
    @GenericGenerator(name="idGenerator", strategy="uuid")
    @GeneratedValue(generator="idGenerator")
    @Column(columnDefinition = "varchar(50) comment '主键id'")
    private String id;

    /**
     * 优惠券名称
     */
    @Column(columnDefinition = "varchar(200) comment '优惠券名称'")
    private String name;

    /**
     * 副标题
     */
    @Column(columnDefinition = "varchar(255) comment '副标题'")
    private String subTitle;

    /**
     * 金额类型
     */
    @Column(columnDefinition = "varchar(10) comment '金额类型'")
    private String amountType;

    /**
     * 固定金额
     */
    @Column(columnDefinition = "double(10,2) comment '固定金额'")
    private double amount;

    /**
     * 随机最低金额
     */
    @Column(columnDefinition = "double(10,2) comment '随机最低金额'")
    private double minAmount;

    /**
     * 随机最高金额
     */
    @Column(columnDefinition = "double(10,2) comment '随机最高金额'")
    private double maxAmount;

    /**
     * 使用规则表达式
     */
    @Column(columnDefinition = "varchar(1000) comment '使用规则表达式'")
    private String useRuleExpression;

    /**
     * 备注
     */
    @Column(columnDefinition = "varchar(255) comment '备注'")
    private String remark;

    /**
     * 状态
     */
    @Column(columnDefinition = "varchar(5) comment '关闭/开启状态'")
    private String status;

    /**
     * 创建时间
     */
    @Column(columnDefinition = "datetime comment '创建时间'")
    private Date createdAt;

}
