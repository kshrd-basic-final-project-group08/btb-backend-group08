package org.hrd.finalprojectmuseum.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Digital Museum API",
                version = "1.0.0",
                description = "API documentation for the Digital Museum application",
                contact = @Contact(
                        name = "GitHub",
                        url = "https://github.com/HoeunPichet/BTB_GROUP_02_SPRING_MINI_PROJECT"
                )
        ),
        servers = {
                @Server(url = "http://localhost:8080", description = "Local Server"),
        }
)
public class SwaggerConfig {
}
