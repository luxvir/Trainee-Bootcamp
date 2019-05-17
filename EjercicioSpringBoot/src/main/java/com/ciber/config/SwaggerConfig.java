package com.ciber.config;

/*
import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
*/
import static springfox.documentation.builders.PathSelectors.regex;

import com.google.common.base.Predicate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

  /** Enable Swagger. **/
  /*
   * @Bean public Docket productApi() { return new
   * Docket(DocumentationType.SWAGGER_2) .select()
   * .apis(RequestHandlerSelectors.basePackage("com.ciber"))
   * .paths(regex("/parents.*")) .build() .apiInfo(metaInfo()); }
   * 
   * private ApiInfo metaInfo() {
   * 
   * ApiInfo apiInfo = new ApiInfo("Spring Boot Swagger rest",
   * "Rest api de personas", "1.0", "Terms of Service", new Contact("TechPrimers",
   * "https://www.youtube.com/TechPrimers", "techPrimerschanne@gmail.com"),
   * "Apache License Version 2.0", "https://www.apache.org/licesen.html");
   * 
   * return apiInfo; }
   */

  /**
   * Documento Swagger.
   * 
   * @return doc.
   */
  @Bean
  public Docket usersApi() {

    return new Docket(DocumentationType.SWAGGER_2)

        .apiInfo(usersApiInfo())

        .select()

        .paths(userPaths())

        .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))

        .build()

        .useDefaultResponseMessages(false);

  }

  private ApiInfo usersApiInfo() {

    return new ApiInfoBuilder()

        .title("Documentacion Swagger")

        .version("1.0")

        .license("Apache License Version 2.0")

        .build();

  }

  private Predicate<String> userPaths() {

    return regex("/api/v1/swagger.*");

  }
}
