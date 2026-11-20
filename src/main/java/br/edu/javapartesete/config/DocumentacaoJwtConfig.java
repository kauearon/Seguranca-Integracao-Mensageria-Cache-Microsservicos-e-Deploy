package br.edu.javapartesete.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 15: Bearer JWT na documentação OpenAPI/Swagger.
@Configuration
public class DocumentacaoJwtConfig {
    @Bean
    public OpenAPI openApi() {
        String esquema = "bearerAuth";
        return new OpenAPI()
            .components(new Components().addSecuritySchemes(esquema,
                new SecurityScheme().type(SecurityScheme.Type.HTTP)
                    .scheme("bearer").bearerFormat("JWT")))
            .addSecurityItem(new SecurityRequirement().addList(esquema));
    }
}
