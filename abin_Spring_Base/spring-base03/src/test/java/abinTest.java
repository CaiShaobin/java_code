import com.abin.pojo.Abin;
import com.abin.pojo.Student;
import com.abin.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class abinTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//        Student student = (Student) context.getBean("student");
//
//        System.out.println(student.toString());
//        User user1 = (User) context.getBean("user1");
//        User user2 = (User) context.getBean("user2");
//
//        System.out.println(user1);
//        System.out.println(user2);

        Abin abin1 = (Abin) context.getBean("abin1");
        Abin abin2 = (Abin) context.getBean("abin2");
        abin1.getDog().shout();
        abin2.getDog().shout();


    }
}
