package com.mdx.util;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.toolkit.StringPool;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mengdl
 * @date 2024/02/27
 */
public class EntryUtil {


    /**
     * sign 签名
     * @param data 参与签名的数据
     * @param appKey 盐
     * @return
     */
    public String sign(final Map<String, Object> data, String appKey) {
        String signText = data.entrySet().stream()
                .map(entry -> StrUtil.join(StringPool.EQUALS, entry.getKey(), entry.getValue()))
                .collect(Collectors.joining(StringPool.AMPERSAND));
        return SecureUtil.sha256(signText + appKey);
    }

}
