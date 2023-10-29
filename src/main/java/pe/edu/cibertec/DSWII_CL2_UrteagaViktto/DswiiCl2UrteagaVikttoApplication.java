package pe.edu.cibertec.DSWII_CL2_UrteagaViktto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class DswiiCl2UrteagaVikttoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DswiiCl2UrteagaVikttoApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer configCorsGlobal(){
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("api/v1/**")
						.allowedMethods("GET", "POST", "PUT")
						.allowedOrigins("*");
			}
		};
	}
}
