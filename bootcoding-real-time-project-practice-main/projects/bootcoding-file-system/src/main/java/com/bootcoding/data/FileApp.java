package com.bootcoding.data;

import com.bootcoding.data.duplicate.DuplicateFInder;
import com.bootcoding.data.metrics.BedroomMetrics;
import com.bootcoding.data.metrics.BedroomNeibourMetrics;
import com.bootcoding.data.metrics.MetricCollector;
import com.bootcoding.data.metrics.NeighbourhoodMetrics;
import com.bootcoding.data.processor.BedroomProcessor;
import com.bootcoding.data.reader.file.FileReader;
import com.bootcoding.data.reader.file.csv.CsvFileReader;
import com.bootcoding.data.report.CsvFileWriter;
import com.bootcoding.data.report.IFileWriter;
import com.bootcoding.data.report.JsonFileWriter;

import java.util.List;

public class FileApp {
    public static void main(String[] args) {


        // 1 read data from File

        FileReader fileReader = new CsvFileReader("/Users/bootcoding/code/bootcoding-real-time-project-practice/projects/bootcoding-file-system/housing_price_dataset.csv");
        BedroomProcessor bp = new BedroomProcessor();
        IFileWriter fw = new CsvFileWriter();

        IFileWriter jsonWriter = new JsonFileWriter();

        List data = fileReader.read();

        DuplicateFInder.findDuplicates(data);
        MetricCollector collector = new NeighbourhoodMetrics();
        collector.collect(data);

        MetricCollector bCollector = new BedroomNeibourMetrics();
        bCollector.collect(data);
        // Count of specific condition - Metrics


        fw.write(bp.getHouses(data, 2), "/Users/bootcoding/tasks/2bhk.csv");
        fw.write(bp.getHouses(data, 3), "/Users/bootcoding/tasks/3bhk.csv");
        fw.write(bp.getHouses(data, 4), "/Users/bootcoding/tasks/4bhk.csv");
        fw.write(bp.getHouses(data, 5), "/Users/bootcoding/tasks/5bhk.csv");


        jsonWriter.write(bp.getHouses(data, 2), "/Users/bootcoding/tasks/2bhk.json");


        // 2bhk, 2bhk.csv
        // 3 bhk , 3bhk.csv
        // Write data to File (Output / Report)
        // which files, filename, file extension
    }
}
