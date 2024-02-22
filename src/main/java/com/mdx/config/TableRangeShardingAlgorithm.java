package com.mdx.config;

import com.google.common.collect.Range;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

import static cn.hutool.core.util.ObjectUtil.isNull;

/**
 * @author Mengdl
 * @date 2024/02/22
 */
@Component
public class TableRangeShardingAlgorithm implements RangeShardingAlgorithm<Long> {

    @Override
    public Collection<String> doSharding(Collection<String> tableNames, RangeShardingValue<Long> rangeShardingValue) {
        Set<String> result = new LinkedHashSet<>();
        Range<Long> valueRange = rangeShardingValue.getValueRange();
        Long upper = valueRange.hasUpperBound() ? valueRange.upperEndpoint() : null;
        Long lower = valueRange.hasLowerBound() ? valueRange.lowerEndpoint() : null;

        //无边界就全部返回
        if (isNull(upper) || isNull(lower)) {
            return tableNames;
        }

        for (Long i = lower; i <= upper; i++ ) {
            for (String tableName : tableNames) {
                if (tableName.endsWith(i % 2 + "")) {
                    result.add(tableName);
                }
            }
        }
        return result;
    }

}
