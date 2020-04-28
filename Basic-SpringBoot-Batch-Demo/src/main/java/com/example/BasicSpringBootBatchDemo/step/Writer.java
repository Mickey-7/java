package com.example.BasicSpringBootBatchDemo.step;

import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class Writer implements ItemWriter<String> {
    @Override
    public void write(List<? extends String> list) throws Exception {
        for(String msg : list){
            System.out.println("Step Writer");
            System.out.println("Writing the data "+msg);
        }
    }
}
