package com.fromnowwon.rnaiplatform.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
      return new OpenAPI()
        .info(new Info()
          .title("Platform API")
          .description("Platform API 문서")
          .version("1.0.0")
        )
        .externalDocs(new ExternalDocumentation()
          .description("Platform Docs")
          // .url("")
        );
    }
}