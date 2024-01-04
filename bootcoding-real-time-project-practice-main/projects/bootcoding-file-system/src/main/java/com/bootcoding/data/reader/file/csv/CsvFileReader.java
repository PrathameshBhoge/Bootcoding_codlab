package com.bootcoding.data.reader.file.csv;

import com.bootcoding.data.model.House;
import com.bootcoding.data.reader.file.FileReader;

import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CsvFileReader implements FileReader {

    private String path;

    public CsvFileReader(String inputFilePath){
        this.path = inputFilePath;
    }


    @Override
    public List read() {

        File file = new File(path);

        try {

            BufferedReader bReader = new BufferedReader(new java.io.FileReader(file));
            String line = bReader.readLine();
            List<House> houses = new ArrayList<>();
            while( (line = bReader.readLine()) != null){
                House house = buildHouse(line);
                houses.add(house);
            }
            return houses;

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return null;
    }



    private static House buildHouse(String line) {
        String[] tokens = line.split(",");
        return House.builder()
                .squareFeet(Integer.valueOf(tokens[0]))
                .bedrooms(Integer.valueOf(tokens[1]))
                .bathrooms(Integer.valueOf(tokens[2]))
                .neighbourhood(tokens[3])
                .year(Integer.valueOf(tokens[4]))
                .price(Double.valueOf(tokens[5]))
                .build();
    }

}
