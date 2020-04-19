package br.com.sfc.restspu.config;

import br.com.sfc.restspu.serialization.converter.YamlJackson2HttpMessageConvrter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final MediaType MEDIA_TYPE_YML = MediaType.valueOf("application/x-yaml");

    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add((new YamlJackson2HttpMessageConvrter()));
    }

    public void addCorsMapping(CorsRegistry registry) {
        registry.addMapping("/**")
        .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT");
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
/*        configurer.favorParameter(false)
                .ignoreAcceptHeader(false)
                .defaultContentType(MediaType.APPLICATION_JSON)
                .mediaType("json",MediaType.APPLICATION_JSON)
                .mediaType("xml",MediaType.APPLICATION_XML);*/

/*        configurer.favorPathExtension(false)
                .favorParameter(true)
                .parameterName("mediaType")
                .ignoreAcceptHeader(true)
                .useRegisteredExtensionsOnly(false)
                .defaultContentType(MediaType.APPLICATION_JSON)
                .mediaType("json",MediaType.APPLICATION_JSON)
                .mediaType("xml",MediaType.APPLICATION_XML);*/

        configurer.favorPathExtension(false)
                .favorParameter(true)
                .ignoreAcceptHeader(false)
                .useRegisteredExtensionsOnly(false)
                .defaultContentType(MediaType.APPLICATION_JSON)
                .mediaType("json",MediaType.APPLICATION_JSON)
                .mediaType("x-yaml",MEDIA_TYPE_YML)
                .mediaType("xml",MediaType.APPLICATION_XML);
    }

}
