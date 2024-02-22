package com.mdx.config;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * @author Mengdl
 * @date 2024/02/22
 */
@Component
public class DataPreciseShardingAlgorithm implements PreciseShardingAlgorithm<Integer> {
    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<Integer> preciseShardingValue) {
        long num = preciseShardingValue.getValue() % 2;
        for (String dataBase : collection) {
            String dataBaseSubfix = dataBase.substring(dataBase.length() - 1);
            if (dataBaseSubfix.equals(String.valueOf(num))) {
                return dataBase;
            }
        }
        throw new IllegalArgumentException("分片库不存在");
    }

}
