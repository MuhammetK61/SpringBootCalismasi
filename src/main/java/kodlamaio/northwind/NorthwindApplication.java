package kodlamaio.northwind;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
//Swagger , uygulamanızın RESTful API belgesini otomatik olarak oluşturan özel bir araçtır.
//Avantajı, yalnızca uygulamanın tüm uç noktalarına bakmanıza değil, aynı zamanda bir
//istek göndererek ve yanıt alarak bunları hemen eylemde test etmenize izin vermesi gerçeğinde yatmaktadır.

public class NorthwindApplication {

    public static void main(String[] args) {

        SpringApplication.run(NorthwindApplication.class, args);
    }

    // Context içinde yer alan her bir nesne bean olarak adlandırılır.
    // @Bean anotasyonu ise application contexte return tipinde belirtilen tipte bir objenin bean olarak
    // ekleneceğini belirtir.
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("kodlamaio.northwind"))
                //.paths(PathSelectors.any())
                .build();
    }

}
