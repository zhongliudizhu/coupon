package com.winstar.common;

import com.winstar.entity.Merchant;
import com.winstar.repository.MerchantRepository;
import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by zl on 2019/5/16
 * 签名验签类
 */
@Component
public class SignUtil {

    private static MerchantRepository merchantRepository;

    @Autowired
    private void setMerchantRepository(MerchantRepository merchantRepository){
        SignUtil.merchantRepository = merchantRepository;
    }

    private static final Logger logger = LoggerFactory.getLogger(SignUtil.class);

    public static String sign(Map<String, String> parameters) {
        Merchant merchant = merchantRepository.findByNumberAndStatus(MapUtils.getString(parameters, "merchant"), "normal");
        if(ObjectUtils.isEmpty(merchant)){
            logger.info("该商户不存在或已被禁停");
            return null;
        }
        StringBuilder param = new StringBuilder();
        TreeMap<String, String> map = new TreeMap<>(parameters);
        Set es = map.entrySet();
        for (Object e : es) {
            Map.Entry entry = (Map.Entry) e;
            String key = (String) entry.getKey();
            Object value = entry.getValue();
            if (!StringUtils.isEmpty(value)) {
                param.append(key).append("=").append(value).append("&");
            }
        }
        param.append(merchant.getSecret());
        logger.info("待签名字符串：" + param.toString());
        return MD5Util.encrypt(param.toString());
    }

    public static boolean checkSign(Map<String, String> parameters) {
        String sign = MapUtils.getString(parameters, "sign");
        parameters.remove("sign");
        return sign.equals(sign(parameters));
    }

}
