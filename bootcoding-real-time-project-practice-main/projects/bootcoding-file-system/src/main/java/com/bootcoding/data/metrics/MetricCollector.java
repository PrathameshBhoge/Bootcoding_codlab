package com.bootcoding.data.metrics;

import com.bootcoding.data.model.House;

import java.util.List;

public interface MetricCollector {

    void collect(List<House> data);
}
