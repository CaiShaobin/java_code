import com.abin.config.AbinConfig;
import com.abin.pojo.Order;
import com.abin.pojo.SaveOrder;
import com.abin.pojo.UpdateOrder;
import com.abin.service.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class abinTest {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AbinConfig.class);

        OrderService orderService = (OrderService) applicationContext.getBean("orderService");

        Order saveOrder = new SaveOrder(1,"abin");
        orderService.saveOrder(saveOrder);

        Order updateOrder = new UpdateOrder(2, "qing");
        orderService.updateOrder(updateOrder);

    }
}
