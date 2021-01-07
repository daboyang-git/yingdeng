package com.yindeng.register;

import org.mybatis.spring.annotation.MapperScan; 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = {"com.yindeng.register"})
@EnableEurekaClient
@SpringBootApplication
/**
 * @ImportResource注解可以加载配置文件,包括spring的配置文件,sql语句的xml文件等等所有的配置文件
 * 以下例子中两个扫描的路径不同,
 * classpath:mapper/*Mapper.xml在resources目录下,
 * classpath*:/dao/*.xml在com/zl/dao目录下,
 * 扫描com.zl.dao包下所有的.xml文件 @ImportResource(locations = {"classpath:mapper/*Mapper.xml"})
 */
//@ImportResource(locations = {"classpath:mapper/*Mapper.xml"}) //一次性扫描/mapper文件夹下的所有Mapper接口
//@ImportResource(locations = {"classpath*:/dao/*.xml"})

/**一次性扫描com.zl.dao包下的所有Mapper接口*/
@MapperScan("com.yindeng.register.dao")
public class RegisterServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegisterServerApplication.class, args);
	}
}
