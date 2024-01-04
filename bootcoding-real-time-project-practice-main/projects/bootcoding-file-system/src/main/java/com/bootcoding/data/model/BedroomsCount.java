package com.bootcoding.data.model;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class BedroomsCount {
    private Map<Integer, NeighbourhoodCount> bedrooms;
}
