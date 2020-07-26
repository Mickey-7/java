package com.example.CommandLineRunner.commandLineOrdering;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Order(1)
@Component
public class CustomCommandLineOrdering2 implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(CustomCommandLineOrdering2.class);

    //underline will appear on class above, just hover then implement method
    @Override
    public void run(String...args) throws Exception {
        LOG.info("Calling second command line runner with arguments {}", Arrays.toString(args));
    }
}
