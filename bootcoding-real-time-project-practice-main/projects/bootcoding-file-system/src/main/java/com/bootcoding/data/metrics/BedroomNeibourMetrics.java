package com.bootcoding.data.metrics;

import com.bootcoding.data.model.BedroomsCount;
import com.bootcoding.data.model.House;
import com.bootcoding.data.model.MetricResult;
import com.bootcoding.data.model.NeighbourhoodCount;
import com.bootcoding.data.report.JsonFileWriter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BedroomNeibourMetrics implements MetricCollector{
    @Override
    public void collect(List<House> data) {

        // How to collect
        Map<Integer, List<House>> bedrooms = data.stream()
                .collect(Collectors.groupingBy(House::getBedrooms));

        bedrooms.forEach((bhk, records) -> {
            Map<String, List<House>> bhkNebours = records.stream().collect(Collectors.groupingBy(House::getNeighbourhood));
            System.out.print(bhk + " BHK:" + records.size());
            bhkNebours.forEach((k,v) -> System.out.print("["+ k+":"+ v.size()+"],"));
            System.out.println();
        });


        // data
        // bedrooms
        // neighbourhoods

        Map<Integer, NeighbourhoodCount> countData = new HashMap<>();
        bedrooms.forEach((bhk, records) -> {
            Map<String, List<House>> bhkNebours = records.stream().collect(Collectors.groupingBy(House::getNeighbourhood));
            System.out.print(bhk + " BHK:" + records.size());
            final NeighbourhoodCount neighbourhoodCount = NeighbourhoodCount.builder().total(records.size()).build();
            bhkNebours.entrySet().forEach((entry) -> {
                setValues(entry, neighbourhoodCount);
            });
            countData.put(bhk, neighbourhoodCount);
        });

        BedroomsCount bedroomsCount = BedroomsCount.builder().bedrooms(countData).build();
        JsonFileWriter.write(bedroomsCount);

        // 1) Build Object


        // 2) Write Objects to JSON


    }

    private static void setValues(Map.Entry<String, List<House>> entry, NeighbourhoodCount neighbourhoodCount) {
        if("Rural".equals(entry.getKey())){
            neighbourhoodCount.setRural(entry.getValue().size());
        } else if("Suburb".equals(entry.getKey())){
            neighbourhoodCount.setSuburb(entry.getValue().size());
        } else if("Urban".equals(entry.getKey())){
            neighbourhoodCount.setUrban(entry.getValue().size());
        }
    }
}
