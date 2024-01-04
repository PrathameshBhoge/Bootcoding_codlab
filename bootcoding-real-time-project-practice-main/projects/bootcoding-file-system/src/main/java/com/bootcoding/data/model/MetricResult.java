package com.bootcoding.data.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class MetricResult {

    private List<BedroomsCount> bedrooms;
}
