import com.sun.bean.User;
import com.sun.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by Sun on 16/11/11.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTest {

	@Autowired
	private UserService userService;

	@Test
	public void exampleTest() {
		List<User> list = userService.findByUsername("15895403115");
		for (User u : list) {
			System.out.println(u.getUsername());
		}
	}

}
