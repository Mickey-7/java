package com.example.CommandLineRunner.commandLineRunner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class CustomCommandLineRunner implements CommandLineRunner {

    private static  final Logger LOG = LoggerFactory.getLogger(CustomCommandLineRunner.class);

    //underline will appear on class above, just hover then implement method
    @Override
    public void run(String... args) throws Exception {
        LOG.info("Custom command line runner is executed with command line arguments: {}", Arrays.toString(args));
    }
}
