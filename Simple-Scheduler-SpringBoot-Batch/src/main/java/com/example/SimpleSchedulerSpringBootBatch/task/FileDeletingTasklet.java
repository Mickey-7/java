package com.example.SimpleSchedulerSpringBootBatch.task;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.UnexpectedJobExecutionException;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.Resource;
import org.springframework.util.Assert;

import java.io.File;

public class FileDeletingTasklet implements Tasklet, InitializingBean {
    //pertains to a file
    private Resource directory;
    //getter
    public Resource getDirectory() {
        return directory;
    }
    //setter
    public void setDirectory(Resource directory) {
        this.directory = directory;
    }

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        //invoke the file
        File dir = directory.getFile();
        File[] files = dir.listFiles();
        for (int i = 0; i < files.length; i++) {
            boolean deleted = files[i].delete();
            if (!deleted){
                throw  new UnexpectedJobExecutionException("Could not delete file "+files[i].getName());
            }else {
                System.out.println(files[i].getPath() + " is deleted!");
            }
        }

        return RepeatStatus.FINISHED;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (directory != null ){
            System.out.println("directory is set");
        }else {
            System.out.println("directory must be set");
        }
    }
}
