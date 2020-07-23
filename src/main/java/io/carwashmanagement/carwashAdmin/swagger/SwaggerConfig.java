package io.carwashmanagement.carwashAdmin.swagger;

import java.util.Collections;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {
	
	public Docket swaggerConfig(){
		return new Docket(DocumentationType.SWAGGER_2)
		.select()
		.paths(PathSelectors.ant("/api/*"))
		.apis(RequestHandlerSelectors.basePackage("com.example"))
		.build()
		.apiInfo(null);
		
	}
	
	private ApiInfo apiDetails(){
		return new ApiInfo(
				"Car Wash Api",
				"Profiles Details",
				"1.0",
				"For Customers",
				new spingfox.documentation.service.contact("kanjarla kirangoud", " kiran.c.k@capgemini.com"),
				"Api licence",
				"abc@gmail.com",
				Collections.emptyList());
		
	}

}
