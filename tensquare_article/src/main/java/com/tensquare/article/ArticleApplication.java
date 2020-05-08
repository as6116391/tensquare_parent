package com.tensquare.article;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.tensquare.util.IdWorker;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author : 闵波路三舅
 * @Date : 2020-05-06 21:30
 * @ClassName : ArticleApplication
 * @Description : 文章服务启动类
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.tensquare.article.dao"})
@EnableSwagger2 //接口文档注解支持
public class ArticleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArticleApplication.class,args);
    }

    @Bean
    public IdWorker getIdWorker(){
        return new IdWorker(1,1);
    }

    /**
    * @Author  闵波路三舅
    * @Date  2020/5/7 16:16
    * @param
    * @Description    swagger2日志
    * @Return  springfox.documentation.spring.web.plugins.Docket
    */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("闵波路三舅")
                .description("Article文章服务 在线接口文档")
                .termsOfServiceUrl("https://www.itcast.cn")
                .contact("itcast.cn")
                .version("1.0")
                .build();
    }

    /**
    * @Author  闵波路三舅
    * @Date  2020/5/7 16:17
    * @param
    * @Description    mybatis plus 分页插件
    * @Return  com.baomidou.mybatisplus.plugins.PaginationInterceptor
    */
    @Bean
    public PaginationInterceptor getPaginationInterceptor(){
        return new PaginationInterceptor();
    }

}
