package spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ApplicationConfiguration1.class, ApplicationConfiguration2.class})
public class ApplicationConfigurationImport {
	//
}
