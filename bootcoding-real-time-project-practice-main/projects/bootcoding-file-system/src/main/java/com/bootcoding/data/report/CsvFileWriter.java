package com.bootcoding.data.report;

import com.bootcoding.data.model.House;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvFileWriter implements IFileWriter {
    @Override
    public void write(List data) {

    }

    @Override
    public void write(List data, String outputPath) {
        try{
            File file = new File(outputPath);
            FileWriter fw = new FileWriter(file);
            data.forEach(d -> {
                try{
                    fw.write(d.toString());
                    fw.write("\n");
                }catch (IOException ex){
                    ex.printStackTrace();
                }
            });
        }catch (IOException ex){
            ex.printStackTrace();
        }

    }
}
