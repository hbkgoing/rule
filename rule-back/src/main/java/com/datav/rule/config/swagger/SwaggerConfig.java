package com.datav.rule.config.swagger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author RC
 * @description swagger配置类
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    /**
     * 是否启用swagger文档
     */
    @Value("${swagger.enable}")
    private boolean enable;

    @Value("${swagger.title}")
    private String title;


    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(enable)
                .apiInfo(apiInfo())
                .select()
                // 这里配置要扫描的包,接口在哪个包就配置哪个包
                .apis(RequestHandlerSelectors.basePackage("com.datav.rule.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    public ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title(title)
                .description("规则平台后端api")
                .termsOfServiceUrl("datav.com")
                .contact(new Contact("rule", "", "1127206312@qq.com"))
                .version("1.0")
                .build();
    }
}
