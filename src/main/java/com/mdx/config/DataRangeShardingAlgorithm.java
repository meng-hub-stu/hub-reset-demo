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
public class DataRangeShardingAlgorithm implements RangeShardingAlgorithm<Integer> {
    @Override
    public Collection<String> doSharding(Collection<String> dataBaseNames, RangeShardingValue<Integer> rangeShardingValue) {
        Set<String> result = new LinkedHashSet<>();
        Range<Integer> valueRange = rangeShardingValue.getValueRange();
        Integer upper = valueRange.hasUpperBound() ? valueRange.upperEndpoint() : null;
        Integer lower = valueRange.hasLowerBound() ? valueRange.lowerEndpoint() : null;

        //无边界就全部返回
        if (isNull(upper) || isNull(lower)) {
            return dataBaseNames;
        }

        for (Integer i = lower; i <= upper; i++ ) {
            for (String dataBaseName : dataBaseNames) {
                if (dataBaseName.endsWith(i % 2 + "")) {
                    result.add(dataBaseName);
                }
            }
        }
        return result;
    }

}
