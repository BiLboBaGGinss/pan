package com.pan.framework.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Pan Yanqing
 * @description : Swagger配置
 * @date : 2022-11-08 15:04
 */
@Configuration
public class SwaggerConfig {
    /**
     * 通过 createRestApi函数来构建一个DocketBean
     * 函数名,可以随意命名,喜欢什么命名就什么命名
     */
    @Bean
    public Docket createRestApi(Environment environment) {
        //设置要显示的swagger环境
        Profiles profiles = Profiles.of("dev");

        //通过environment.acceptsProfiles判断是否存在处在自己设定的环境中
        boolean flag = environment.acceptsProfiles(profiles);


        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("pan")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.pan"))
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts())
                .useDefaultResponseMessages(false)
                .apiInfo(apiInfo())
                .enable(flag);
    }

    private List<SecurityScheme> securitySchemes() {
        List<SecurityScheme> apiKeyList = new ArrayList<>();
        apiKeyList.add(new ApiKey("satoken", "satoken", "header"));
        return apiKeyList;
    }

    private List<SecurityContext> securityContexts() {
        List<SecurityContext> securityContextList = new ArrayList<>();
        List<SecurityReference> securityReferenceList = new ArrayList<>();
        securityReferenceList.add(new SecurityReference("satoken", scopes()));
        securityContextList.add(SecurityContext
                .builder()
                .securityReferences(securityReferenceList)
                .forPaths(PathSelectors.any())
                .build()
        );
        return securityContextList;
    }

    private AuthorizationScope[] scopes() {
        return new AuthorizationScope[]{new AuthorizationScope("global", "accessAnything")};
    }

    /**
     * 构建 api文档的详细信息函数
     *
     * @return ApiInfo
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("接口文档")
                .version("v1.0.0")
                .description("接口文档")
                .build();
    }
}
