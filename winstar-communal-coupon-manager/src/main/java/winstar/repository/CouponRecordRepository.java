package winstar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import winstar.entity.CouponRecord;

/**
 * Created by shibinbin on 2019/5/13
 */
public interface CouponRecordRepository extends JpaRepository<CouponRecord, String>{
}
