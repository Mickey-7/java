package com.example.BasicSpringBootBatchDemo.configuration;

import com.example.BasicSpringBootBatchDemo.listener.JobCompletionListener;
import com.example.BasicSpringBootBatchDemo.step.Processor;
import com.example.BasicSpringBootBatchDemo.step.Reader;
import com.example.BasicSpringBootBatchDemo.step.Writer;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class BatchConfig {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;
    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    //Spring @Bean Annotation is applied on a method to specify that it returns a bean to be managed by Spring context.
    //Spring Bean annotation is usually declared in Configuration classes methods.
    //In this case, bean methods may reference other @Bean methods in the same class by calling them directly
    public Job processJob(){
        System.out.println("Config Job");
        return jobBuilderFactory.get("processJob")
                    .incrementer(new RunIdIncrementer())
                    .flow(orderStep1()).end().build();

    }

    @Bean
    public Step orderStep1(){
        System.out.println("Config Step");
        return stepBuilderFactory.get("orderStep1")
                    .<String, String> chunk(1)
                    .reader(new Reader())
                    .processor(new Processor())
                    .writer(new Writer())
                    .build();

    }

    @Bean
    public JobExecutionListener listener(){
        System.out.println("Config Listener");
        return new JobCompletionListener();
    }
}
