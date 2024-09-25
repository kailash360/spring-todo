package orgTree.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import orgTree.demo.controller.ToDoController;
import orgTree.demo.service.ToDoService;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		System.out.println("Hello Spring...");

		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
//		ToDoService service = context.getBean(ToDoService.class);
//		System.out.println(service.getTasks());


		System.out.println("Server started...");
	}

}
