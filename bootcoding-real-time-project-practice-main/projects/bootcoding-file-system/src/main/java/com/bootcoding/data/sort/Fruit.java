package com.bootcoding.data.sort;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Fruit implements Comparable{
    int quantity;
    String name;
    String desc;

    @Override
    public int compareTo(Object o) {
        Fruit second = (Fruit) o;
        return this.quantity - second.quantity;
    }
}
