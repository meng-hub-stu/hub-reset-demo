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
public class TablePreciseShardingAlgorithm implements PreciseShardingAlgorithm<Long> {

    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<Long> preciseShardingValue) {
        long num = preciseShardingValue.getValue() % 2;
        for (String table : collection) {
            String tableSubfix = table.substring(table.length() - 1);
            if (tableSubfix.equals(String.valueOf(num))) {
                return table;
            }
        }
        throw new IllegalArgumentException("分片表不存在");
    }

}
