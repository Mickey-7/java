package com.example.CommandLineRunner.commandLineOrdering;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class CustomCommandLineOrdering implements CommandLineRunner, Ordered {

    private static final Logger LOG = LoggerFactory.getLogger(CustomCommandLineOrdering.class);

    //underline will appear on class above, just hover then implement method
    @Override
    public void run(String...args) throws Exception {
        LOG.info("Custom command line ordering is executed with command line arguments: {}", Arrays.toString(args));
    }

    @Override
    public int getOrder() {
        return 2;
    }
}