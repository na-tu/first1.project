package first1.project;

import first1.project.data.Student;
import first1.project.data.StudentsCourses;
import first1.project.repository.StudentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController//JSONの機能が使われる（データをテキスト形式）
public class Application {

	public String name = "Nishihara Natsuki";
	public int age = 45;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}

