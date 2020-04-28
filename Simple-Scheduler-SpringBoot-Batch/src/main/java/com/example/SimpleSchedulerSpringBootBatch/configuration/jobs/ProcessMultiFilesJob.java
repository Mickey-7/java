package com.example.SimpleSchedulerSpringBootBatch.configuration.jobs;

import com.example.SimpleSchedulerSpringBootBatch.task.FileDeletingTasklet;
import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.batch.core.repository.support.MapJobRepositoryFactoryBean;
import org.springframework.batch.support.transaction.ResourcelessTransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

@Configuration
@EnableBatchProcessing
//The @EnableBatchProcessing annotation enables Spring Batch features
//and provides a base configuration for setting up batch jobs.
public class ProcessMultiFilesJob {

    //Our sample project has only one job that is configured with an injected JobBuilderFactory and StepBuilderFactory.
    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private SimpleJobLauncher simpleJobLauncher;

    @Value("file:C:\\Users\\mmacaranas\\Documents\\try")
    private Resource directory;

    @Bean
    //Spring @Bean annotation tells that a method produces a bean to be managed by the Spring container.
    //It is a method-level annotation. During Java configuration ( @Configuration ),
    //the method is executed and its return value is registered as a bean within a BeanFactory .
    public ResourcelessTransactionManager transactionManager(){
        System.out.println("Config ResourcelessTransactionManager");
        return  new ResourcelessTransactionManager();
    }

    @Bean
    public MapJobRepositoryFactoryBean mapJobRepositoryFactoryBean(ResourcelessTransactionManager resourcelessTransactionManager) throws Exception {
        //invoke ResourcelessTransactionManager
        MapJobRepositoryFactoryBean factoryBean = new MapJobRepositoryFactoryBean(resourcelessTransactionManager);
        factoryBean.afterPropertiesSet();
        System.out.println("Config MapJobRepositoryFactoryBean");
        return factoryBean;
    }

    @Bean
    public JobRepository jobRepository(MapJobRepositoryFactoryBean mapJobRepositoryFactoryBean) throws Exception {
        System.out.println("Config JobRepository");
        return mapJobRepositoryFactoryBean.getObject();
    }



    @Scheduled(cron = "*/5 * * * * *")
    public void perform() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
        System.out.println("Job Started at : "+new Date());
        JobParameters parameters = new JobParametersBuilder().addString(
                "JobID",
                String.valueOf(System.currentTimeMillis())
        ).toJobParameters();
        JobExecution execution = simpleJobLauncher.run(readFiles(), parameters);
        System.out.println("Job finished with status : "+execution.getStatus());
    }

    @Bean
    public Job readFiles() {
        System.out.println("Config Job");
        return jobBuilderFactory.get("readFiles")
                .incrementer(new RunIdIncrementer())
                .flow(step1())
                .end()
                .build();

    }
    @Bean
    public Step step1() {
        System.out.println("Config Step");
        return stepBuilderFactory.get("step1")
                .tasklet(fileDeletingTasklet())
                .build();
    }

    @Bean
    //invoking FileDeletingTasklet
    public FileDeletingTasklet fileDeletingTasklet() {
        FileDeletingTasklet tasklet = new FileDeletingTasklet();
        tasklet.setDirectory(directory);
        System.out.println("Config set tasklet to directory");
        return tasklet;
    }
    @Bean
    public SimpleJobLauncher jobLauncher(JobRepository jobRepository){
        System.out.println("Config SimpleJobLauncher");
        SimpleJobLauncher launcher = new SimpleJobLauncher();
        launcher.setJobRepository(jobRepository);
        return launcher;
    }


}
