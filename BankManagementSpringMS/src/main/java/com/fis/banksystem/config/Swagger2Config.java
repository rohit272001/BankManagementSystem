package com.fis.banksystem.config;
 
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
 
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
 
/*Implementing Swagger2 configuration class to implement the 
 * predefine ui to run the application
 */
@Configuration
@EnableSwagger2
public class  Swagger2Config{
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
            .apis(RequestHandlerSelectors
                .basePackage("com.fis.banksystem.controller"))
            .paths(PathSelectors.regex("/.*"))
            .build().apiInfo(apiEndPointsInfo())
            .securitySchemes(Arrays.asList(apiKey()))
            .securityContexts(Arrays.asList(securityContext()))
            .pathMapping("/")
            .useDefaultResponseMessages(false)
            .directModelSubstitute(LocalDate.class,String.class)
            .genericModelSubstitutes(ResponseEntity.class);
    }
 
    private ApiInfo apiEndPointsInfo() {
 
    	//implementing Rest Api here 
        return new ApiInfoBuilder().title("Spring Boot REST API")
            .description("Banking Management System REST API")
            .contact(new Contact("Rohit", "www.fis.net", "fis@gmail.com"))
            .license("Apache 2.0")
            .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
            .version("1.0.0")
            .build();
    }
    //returning new api key for the authorization
    private ApiKey apiKey()
    {
    	return new ApiKey("JWT","Authorization","header");
    	
    }
    private SecurityContext securityContext()
    {
    	return SecurityContext.builder().securityReferences(defaultAuth()).build();
    }
    private List<SecurityReference> defaultAuth()
    {
    	AuthorizationScope authorizationScope=new AuthorizationScope("global","accessEverything");
    	AuthorizationScope[] authorizationScopes=new AuthorizationScope[1];
    	authorizationScopes[0]=authorizationScope;
    	return Arrays.asList(new SecurityReference("JWT",(springfox.documentation.service.AuthorizationScope[]) authorizationScopes));
    }
}