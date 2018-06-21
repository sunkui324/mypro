package com.wolab.algorithm;

import com.wolab.model.User;

import java.util.*;

public class MapFull {

    public Map<String, List<Integer>> sharding(final List<String> serversList, final int shardingTotalCount) {
        if (serversList.isEmpty()) {
            return Collections.emptyMap();
        }
        Map<String, List<Integer>> result = shardingAliquot(serversList, shardingTotalCount);
        addAliquant(serversList, shardingTotalCount, result);
        return result;
    }

    private Map<String, List<Integer>> shardingAliquot(final List<String> serversList, final int shardingTotalCount) {
        Map<String, List<Integer>> result = new LinkedHashMap<>(serversList.size());
        int itemCountPerSharding = shardingTotalCount / serversList.size();
        int count = 0;
        for (String each : serversList) {
            List<Integer> shardingItems = new ArrayList<>(itemCountPerSharding + 1);
            for (int i = count * itemCountPerSharding; i < (count + 1) * itemCountPerSharding; i++) {
                shardingItems.add(i);
            }
            result.put(each, shardingItems);
            count++;
        }
        return result;
    }

    private void addAliquant(final List<String> serversList, final int shardingTotalCount, final Map<String, List<Integer>> shardingResult) {
        int aliquant = shardingTotalCount % serversList.size();
        int count = 0;

        for (Map.Entry<String, List<Integer>> entry : shardingResult.entrySet()) {
            if (count < aliquant) {
                entry.getValue().add(shardingTotalCount / serversList.size() * serversList.size() + count);
            }
            count++;
        }
    }

    public static void main(String[] args) {
        MapFull strategy =new MapFull();
        List<String> serversList =new ArrayList<>();
        serversList.add("server1");
        serversList.add("server2");
        serversList.add("server3");

        Map<String, List<Integer>> map= strategy.sharding(serversList,8);

        System.out.println(8/2*2 ==8/3*3);

    }
}
