package com.assignment.emp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {

  @Override
  public void addResourceHandlers(final ResourceHandlerRegistry registry) {

    registry.addResourceHandler("swagger-ui.html")
        .addResourceLocations("classpath:/META-INF/resources/");

    registry.addResourceHandler("/webjars/**")
        .addResourceLocations("classpath:/META-INF/resources/webjars/");
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder().title("Consumer Web Application Service")
        .description("This page lists all the rest endpoints for Consumer Web Application Service.")
        .version("1..0.0_SNAPSHOT").build();
  }

  @Bean
  public CorsFilter corsFilter() {
    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

    // Allow anyone and anything access. Probably ok for Swagger spec
    final CorsConfiguration config = new CorsConfiguration();
    config.setAllowCredentials(true);
    config.addAllowedOrigin("*");
    config.addAllowedHeader("*");
    config.addAllowedMethod("*");

    source.registerCorsConfiguration("/v1/api-docs", config);
    return new CorsFilter(source);
  }

  @Bean
  public Docket produceApi(@Value("${swagger.enabled}") final Boolean enabled) {

    return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
        .apis(RequestHandlerSelectors.basePackage("com.assignment.emp.controller")).build()
        .enable(enabled);
  }
}
