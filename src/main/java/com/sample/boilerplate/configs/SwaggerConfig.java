//package com.sample.boilerplate.configs;
//
//import org.springframework.context.annotation.Bean;
//
//public class SwaggerConfig {
//    @Bean
//    public GroupedOpenApi api() {
//        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
//                .apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
//                .build();
//    }
//
//
//
//
//}