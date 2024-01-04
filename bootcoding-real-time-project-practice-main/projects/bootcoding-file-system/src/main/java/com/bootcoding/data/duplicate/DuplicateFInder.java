package com.bootcoding.data.duplicate;

import com.bootcoding.data.model.House;

import java.util.List;

public class DuplicateFInder {

    public static void findDuplicates(List<House> data){

        data.forEach(d -> {
            long count = duplicateCount(d, data);
            if(count > 1){
                System.out.println(count + ": " + d);
            }
        });
        // Define House1 and House2
    }

    public static long duplicateCount(House house, List<House> data){
        return data.stream().filter(h -> isDuplicate(house, h)).count();
    }

    public static boolean isDuplicate(House left, House right){
        if (!left.getNeighbourhood().equals(right.getNeighbourhood())) {
            return false;
        }
        if (left.getBedrooms() != right.getBedrooms()) {
            return false;
        }
        if (left.getBathrooms() != right.getBathrooms()) {
            return false;
        }
        if (left.getSquareFeet() != right.getSquareFeet()) {
            return false;
        }

        if (left.getYear() != right.getYear()) {
            return false;
        }

        return true;
    }
}
