package winstar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import winstar.entity.Coupon;

/**
 * Created by shibinbin on 2019/5/13
 */
public interface CouponRepository extends JpaRepository<Coupon, String>{
}
