package com.bootcoding.data.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@Builder
@ToString
public class House implements Comparable{
    
     int squareFeet;
     int bedrooms;
     int bathrooms;
     String neighbourhood;
     int year;
     double price;


     public String toString(){
          return squareFeet + "," + bedrooms + "," + bathrooms + "," + neighbourhood + "," + year + "," + price;
     }

     @Override
     public int compareTo(Object o) {
          House h = (House) o;
          return this.neighbourhood.compareTo(h.neighbourhood);
     }

}
