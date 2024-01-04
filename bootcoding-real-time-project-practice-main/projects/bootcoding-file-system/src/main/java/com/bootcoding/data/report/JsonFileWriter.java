package com.bootcoding.data.report;

import com.bootcoding.data.model.BedroomsCount;
import com.bootcoding.data.model.MetricResult;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
import java.util.List;

public class JsonFileWriter implements IFileWriter {
    ObjectMapper objectMapper = new ObjectMapper();

    public static void write(BedroomsCount metricResult) {
        try{

            ObjectMapper om = new ObjectMapper();
            String s = om.writeValueAsString(metricResult);
            FileWriter fw = new FileWriter(new File("/Users/bootcoding/code/" + Instant.now() + ".json"));
            fw.write(s);
            fw.flush();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void write(List data) {

    }

    @Override
    public void write(List data, String outputPath) {
        // write data into .json file

        try{
            String s = objectMapper.writeValueAsString(data);
            FileWriter fw = new FileWriter(new File(outputPath));
            fw.write(s);
            fw.flush();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
