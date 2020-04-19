package br.com.sfc.restspu.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("REST SPU API")
                        .description("REST API developed for Spring Boot REST API Udemy Course")
                .contact(getContact()));
    }

    private Contact getContact() {
        Contact contact = new Contact();

        contact.setName("Sandney Farias da Cunha");
        contact.setEmail("sandneyfarias@");

        return contact;
    }


/*    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.sfc.restpu"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    public ApiInfo apiInfo() {
        return new ApiInfo("RESTful API with Spring Boot",
                "Some description",
                "V1",
                "Terms of Service Url",
                new Contact("Sandney Farias da Cunha","https://sfc.com.br", "sandneyfarias@hotmail.com"),
                "API",
                "",
                Collections.emptyList()
        );
    }*/

}
