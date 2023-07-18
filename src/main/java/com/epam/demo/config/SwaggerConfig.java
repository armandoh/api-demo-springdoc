package com.epam.demo.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI()
                .info(new Info().title("Phone Service API")
                        .description("This service is used to manage phones"))
                .externalDocs(new ExternalDocumentation()
                        .description("Phones Wiki Documentation")
                        .url("https://phones.wiki.github.org/docs"));
    }





    public static final String PHONE_TAG = "phone service";

    /*
                    .title("Phone Service API")
                .description("This service is used to manage phones")

     public static final String PHONE_TAG = "phone service";
    @Bean
    public OpenAPI phonesOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Phone Service API")
                        .description("This service is used to manage phones.")
                        .version("v1.0.0")
                        .license(new License().name("Apache 2.0").url("http://phones-api.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("Phones Wiki Documentation")
                        .url("https://phones.wiki.github.org/docs"));
    }
    *
    * */
}
