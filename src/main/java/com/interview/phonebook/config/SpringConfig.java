package com.interview.phonebook.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class SpringConfig {




    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder){

        return restTemplateBuilder.build();

    }


    @Bean
    public BasicAuthenticationInterceptor basicAuthenticationInterceptor(){
      return new BasicAuthenticationInterceptor("sabamosleh","66978716s");

    }


    @Bean (name = "taskExecutor")
    public Executor taskExecutor() {

//        LOGGER.debug("Creating Async Task Executor");

        final ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

        executor.setCorePoolSize(2);

        executor.setMaxPoolSize(2);

        executor.setQueueCapacity(100);

        executor.setThreadNamePrefix("TestThread-");

        executor.initialize();

        return executor;

    }




}
