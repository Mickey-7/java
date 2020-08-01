package com.example.lazyloading;

import com.example.lazyloading.service.ServiceX;
import com.example.lazyloading.service.ServiceY;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

@SpringBootApplication
public class LazyLoadingApplication {

	@Bean(name = "serviceX")
	public ServiceX getServiceX(){
		return new ServiceX();
	}

	@Bean(name = "serviceY")
	@Lazy(value = false)
	public ServiceY getServiceY(){
		return new ServiceY();
	}

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(LazyLoadingApplication.class, args);

		System.out.println("Application context initialization");

		ServiceX serviceX = applicationContext.getBean("serviceX", ServiceX.class);
		serviceX.printSomething();

		ServiceY serviceY = applicationContext.getBean("serviceY", ServiceY.class);
		serviceY.printSomething();

	}

}
