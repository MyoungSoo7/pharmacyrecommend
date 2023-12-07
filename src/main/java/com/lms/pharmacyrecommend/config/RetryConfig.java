package com.lms.pharmacyrecommend.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.retry.annotation.EnableRetry;

// AOP for retrying failed requests ( 정해진 규칙에 따라 재시도)
@EnableRetry
@Configuration
public class RetryConfig {
}
