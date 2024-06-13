package com.versoft.foodosbackend.Shared.Infrastructure.Documentation.OpenApi.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.media.FileSchema;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class OpenApiConfiguration{

    @Bean
    public OpenAPI FoodOs_Backend(){
        var openApi = new OpenAPI();

        openApi
                .info(new Info()
                        .title("FoodOs Backend")
                        .description("Backend of FoodOs Backend ")
                        .version("v0.0.1")
                        .license(new License().name("Apache 2.0")
                                .url("https://springdoc.org")));

        final String securitySchemeName = "bearerAuth";

        openApi.addSecurityItem(new SecurityRequirement()
                        .addList(securitySchemeName))
                .components(new Components()
                        .addSecuritySchemes(securitySchemeName,
                                new SecurityScheme()
                                        .name(securitySchemeName)
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")));



        return openApi;
    }

}
