import com.xmlMyBatis.service.DepartmentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyBatisTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
        DepartmentService departmentService = applicationContext.getBean("departmentService", DepartmentService.class);
        departmentService.getAll();
    }
}
