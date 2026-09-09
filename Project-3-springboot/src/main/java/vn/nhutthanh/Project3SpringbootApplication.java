package vn.nhutthanh;

import org.springframework.boot.SpringApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import vn.nhutthanh.configs.CustomSiteMeshFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;

@SpringBootApplication
@Configuration
public class Project3SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(Project3SpringbootApplication.class, args);
	}

	@Bean

	FilterRegistrationBean<CustomSiteMeshFilter> siteMeshFilter() {

		FilterRegistrationBean<CustomSiteMeshFilter> filterRegistrationBean = new FilterRegistrationBean<CustomSiteMeshFilter>();

		filterRegistrationBean.setFilter(new CustomSiteMeshFilter()); // adding sitemesh filter ??

		filterRegistrationBean.addUrlPatterns("/*");

		return filterRegistrationBean;

	}

	@Bean

	@Order(Ordered.HIGHEST_PRECEDENCE)

	CharacterEncodingFilter characterEncodingFilter() {

		CharacterEncodingFilter filter = new CharacterEncodingFilter();

		filter.setEncoding("UTF-8");

		filter.setForceEncoding(true);

		return filter;

	}

}
