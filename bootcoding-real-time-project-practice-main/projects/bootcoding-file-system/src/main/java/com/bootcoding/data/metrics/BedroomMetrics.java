package com.bootcoding.data.metrics;

import com.bootcoding.data.model.House;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BedroomMetrics implements MetricCollector{
    @Override
    public void collect(List<House> data) {

        // How to collect
        Map<Integer, List<House>> bedrooms = data.stream().collect(Collectors.groupingBy(House::getBedrooms));

        bedrooms.forEach((k,v) -> System.out.println(k + " BHK:" + v.size()));
    }
}
