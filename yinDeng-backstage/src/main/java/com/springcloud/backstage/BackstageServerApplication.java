package com.springcloud.backstage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 扫描跨端口访问规则,也就是commom模块中的com.zl.client包下的所有接口,
 * 例如可以扫描com.zl.client.LoginServiceClient类
 */
/**
 * 该注解说明,这是个客户端,类似于多人聊天系统中的客户端
 *提供同一种服务的客户端可以有很多,相当于一个tomcat集群提供同一种服务,
 *服务器会自动找其中某一个客户端提供服务,只有当该服务的所有客户端全部
 *宕机,才会无法提供该服务,因此容灾性大大提高
 */
/**
 * 启动方式1
 */
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
@MapperScan("com.springcloud.backstage.dao") 
public class BackstageServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(BackstageServerApplication.class, args);
	}
}
