package ro.pickupservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
public class AppConfig extends WebMvcConfigurerAdapter {
	
	private static final String[] CLASSPATH_APP_LOCATIONS = {"classpath:/static/app/","classpath:/static/","/ui"};

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("redirect:/ui/app/index.html");
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/ui/**").addResourceLocations(CLASSPATH_APP_LOCATIONS);
//		registry.addResourceHandler("swagger-ui.html")
//				.addResourceLocations("classpath:/META-INF/resources/");
//		registry.addResourceHandler("/webjars/**")
//				.addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
	
	@Bean
	public ViewResolver htmlViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/ui/app/");
		resolver.setSuffix(".html");
		return resolver;
	}

}
