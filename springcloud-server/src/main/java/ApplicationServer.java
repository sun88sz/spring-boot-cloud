import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.ApplicationContext;

/**
 * Created by Sun on 16/11/4.
 */
@EnableEurekaServer
@SpringBootApplication(scanBasePackages = { "." })
public class ApplicationServer {
	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = SpringApplication.run(ApplicationServer.class, args);

		System.out.println("start ...");
	}
}
