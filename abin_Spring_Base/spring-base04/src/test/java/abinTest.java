import com.abin.pojo.Abin;
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

        Abin abin = (Abin) context.getBean("abin");
        abin.getDog().shout();
        abin.getCat().shout();


    }
}
