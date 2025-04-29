package org.hrd.finalprojectmuseum;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@SecurityScheme(
        name = "bearerAuth",
        type = SecuritySchemeType.HTTP,
        scheme = "bearer"
)
public class FinalProjectMuseumApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinalProjectMuseumApplication.class, args);
    }

}
