import com.abin.config.AbinConfig;
import com.abin.pojo.User;
import com.abin.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AbinTest {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AbinConfig.class);
        User user = (User) context.getBean("getUser");
        System.out.println(user);

        UserService userService = (UserService) context.getBean("userService");
        System.out.println(userService.queryUser());
    }
}
