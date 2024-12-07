package me.maaky1.basic.project.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Basic Project Application")
                        .version("1.0")
                        .description("Proyek ini adalah langkah awal dalam perjalanan belajar Spring Boot.")
                );
    }
}
