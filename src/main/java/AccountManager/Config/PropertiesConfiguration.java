package AccountManager.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:AccountManager.properties")
public class PropertiesConfiguration {
}
