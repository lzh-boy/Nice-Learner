package com.example.learner;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@MapperScan("com.example.learner.mapper")
@EnableAsync//启动异步传输
public class LearnerApplication {
//private static Logger logger = LoggerFactory.getLogger(CorgiApplication.class);

	public static void main(String[] args) {
		// 程序启动入口
		// 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
		SpringApplication.run(LearnerApplication.class, args);
		//logger.error("log4j2 error!");
	}
}
