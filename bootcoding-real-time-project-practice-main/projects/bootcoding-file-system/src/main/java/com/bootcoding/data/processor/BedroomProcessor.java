package com.bootcoding.data.processor;

import com.bootcoding.data.model.House;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BedroomProcessor {

    public List<House> getHouses(List<House> houses, int bedroomSize){
        List<House> bhkList = houses.stream().filter(h -> h.getBedrooms() == bedroomSize)
                .collect(Collectors.toList());

        Collections.sort(bhkList);
        return bhkList;

    }


}
