package com.winstar.repository;

import com.winstar.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by shibinbin on 2019/5/13
 */
public interface CouponRepository extends JpaRepository<Coupon, String>{
}
