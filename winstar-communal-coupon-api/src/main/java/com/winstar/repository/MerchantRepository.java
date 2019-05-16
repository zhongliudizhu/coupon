package com.winstar.repository;

import com.winstar.entity.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by zl on 2019/5/16
 */
public interface MerchantRepository extends JpaRepository<Merchant, String> {

    Merchant findByNumberAndStatus(String number, String status);

}
