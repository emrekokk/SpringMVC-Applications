package controller;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
    @Configuration
    @EnableWebMvc
    @ComponentScan("controller")
public class MvcHandler implements WebMvcConfigurer {
        @Override
        public void configureViewResolvers(ViewResolverRegistry registry) {
            registry.jsp("/WEB-INF/views/",".jsp");
        }

        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/resources/**").addResourceLocations("classpath:/css");
            registry.addResourceHandler("/images/*");
            registry.addResourceHandler("/js/*");
        }
    }
