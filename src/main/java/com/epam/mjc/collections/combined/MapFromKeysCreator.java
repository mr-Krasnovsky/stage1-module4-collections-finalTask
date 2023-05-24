package com.epam.mjc.collections.combined;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MapFromKeysCreator {
    public Map<Integer, Set<String>> createMap(Map<String, Integer> sourceMap) {
        Map<Integer, Set<String>> result = new TreeMap<>();
        for (Map.Entry<String, Integer> entry : sourceMap.entrySet()) {
            String value = entry.getKey();
            int key = value.length();
            if (!result.containsKey(key)) {
                result.put(key, new LinkedHashSet<String>(Set.of(value)));
            } else if (result.containsKey(key)) {
                Set<String> valueSet = result.get(key);
                valueSet.add(value);
                result.put(key, valueSet);
            }
        }
        return result;
    }
}
