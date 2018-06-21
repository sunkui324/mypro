package com.wolab.algorithm;

import java.util.*;

/**
 * 基于平均分配算法的分片策略.
 *
 * <p>
 * 如果分片不能整除, 则不能整除的多余分片将依次追加到序号小的服务器.
 * 如:
 * 1. 如果有3台服务器, 分成9片, 则每台服务器分到的分片是: 1=[0,1,2], 2=[3,4,5], 3=[6,7,8].
 * 2. 如果有3台服务器, 分成8片, 则每台服务器分到的分片是: 1=[0,1,6], 2=[2,3,7], 3=[4,5].
 * 3. 如果有3台服务器, 分成10片, 则每台服务器分到的分片是: 1=[0,1,2,9], 2=[3,4,5], 3=[6,7,8].
 * </p>
 *
 * @author zhangliang
 */
public class AverageAllocationJobSharding {

    /**
     * 如果分片不能整除, 则不能整除的多余分片将依次追加到序号小的服务器.
     * 如:
     * 1. 如果有3台服务器, 分成9片, 则每台服务器分到的分片是: 1=[0,1,2], 2=[3,4,5], 3=[6,7,8].
     * 2. 如果有3台服务器, 分成8片, 则每台服务器分到的分片是: 1=[0,1,6], 2=[2,3,7], 3=[4,5].
     * 3. 如果有3台服务器, 分成10片, 则每台服务器分到的分片是: 1=[0,1,2,9], 2=[3,4,5], 3=[6,7,8].
     *
     * @param serversList         服务列表
     * @param shardingTotoalCount 分片总数
     * @return 每台服务器得到的分片信息
     * @author bruce.sun
     * @date 2018/6/15
     */
    public Map<String, List<Integer>> sharding(final List<String> serversList, final int shardingTotoalCount) {
        if (serversList.isEmpty()) {
            return Collections.emptyMap();
        }

        Map<String, List<Integer>> map = new HashMap<>(serversList.size());
        // 每台服务最少的分片数
        int minShardingPerServer = shardingTotoalCount / serversList.size();
        // 多余的分片数
        int less = shardingTotoalCount % serversList.size();

        for (int j = 0; j < serversList.size(); j++) {
            String each = serversList.get(j);
            List<Integer> list = new ArrayList<>(minShardingPerServer+1);
            for (int i = j * minShardingPerServer; i < (j+1) * shardingTotoalCount; i++) {
                list.add(minShardingPerServer);
            }
            map.put(each, list);
        }

        int count =0;
        for(Map.Entry<String, List<Integer>> entry:map.entrySet()){
            int aliquant= shardingTotoalCount % serversList.size();
            if(count<aliquant){
                entry.getValue().add(shardingTotoalCount/serversList.size() * serversList.size() + count);
            }
        }


        return map;

    }


}
