package com.nice.hyunjoon.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
    info = @Info(title = "API 명세서",
        description = "API 명세서",
        version = "v1.0"
    )
)
@Configuration
public class OpenApiConfig {
  /**
   * customGameOpenApi.
   * @return GroupedOpenApi
   */
  @Bean
  public GroupedOpenApi customGameOpenApi() {
    String[] paths = {"//**"};
    return GroupedOpenApi.builder().setGroup("API").pathsToMatch(paths)
        .build();
  }

}
