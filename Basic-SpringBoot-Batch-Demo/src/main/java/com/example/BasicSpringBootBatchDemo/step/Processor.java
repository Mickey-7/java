package com.example.BasicSpringBootBatchDemo.step;

import org.springframework.batch.item.ItemProcessor;

public class Processor implements ItemProcessor<String , String> {
    @Override
    public String process(String s) throws Exception {
        System.out.println("Step Process");
        return s.toUpperCase();
    }
}
