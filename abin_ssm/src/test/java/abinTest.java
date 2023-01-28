import com.abin.pojo.Books;
import com.abin.service.BooksService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

public class abinTest {

    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        BooksService booksService = (BooksService) context.getBean("booksService");
        for (Books queryAllBook : booksService.queryAllBooks()) {
            System.out.println(queryAllBook);
        }

    }
}
