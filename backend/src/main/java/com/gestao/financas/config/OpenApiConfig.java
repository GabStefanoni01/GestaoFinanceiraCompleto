package com.gestao.financas.config;
import io.swagger.v3.oas.models.*;import io.swagger.v3.oas.models.info.Info;import io.swagger.v3.oas.models.security.SecurityScheme;import org.springframework.context.annotation.*;
@Configuration public class OpenApiConfig {
 @Bean OpenAPI financeApi(){return new OpenAPI().info(new Info().title("Gestão Financeira API").version("1.0.0").description("API REST para gestão financeira pessoal."))
 .components(new Components().addSecuritySchemes("bearerAuth",new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")));}
}