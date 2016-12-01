import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;

/**
 * Created by Sun on 16/11/4.
 */
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = { ".", "com.sun" })
public class ApplicationProvider {
	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = SpringApplication.run(ApplicationProvider.class, args);

		System.out.println("client start ...");
	}
}
