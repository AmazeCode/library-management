package com.book.management;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;

import java.util.Random;


@Slf4j
@SpringBootApplication
public class LibraryManagementApplication {

	/**
	 * 注册错误页面
	 * @return
	 */
	@Bean
	public ErrorPageRegistrar errorPageRegistrar(){

		return registry ->{
			registry.addErrorPages(
					new ErrorPage(HttpStatus.NOT_FOUND, "/404.jsp"),
					new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500.jsp")
			);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(LibraryManagementApplication.class, args);
		//log.info("项目启动成功！");
	}

}
