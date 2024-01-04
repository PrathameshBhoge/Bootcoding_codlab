package com.bootcoding.data.report;

import java.util.List;

public interface IFileWriter extends DataWriter {
    public void write(List data, String outputPath);
}
