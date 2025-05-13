package first1.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

	@Autowired//springが管理してる機能
	public  StudentRepository repository;

	public String name = "Nishihara Natsuki";
	public int age = 45;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@GetMapping("/student")
	public String getStudent(@RequestParam("name")String name){
		Student student = repository.searchByName(name);
		return student.getName() + "です。" + student.getAge() + "歳です。";
	}

	@PostMapping("/student")
	public void registerStudent(String name, int age) {
		repository.registerStudent(name,age);
	}

	@PatchMapping("/student")
	public void updateStudent(String name,int age) {
		repository.updateStudent(name, age);
	}

	@DeleteMapping("/student")
	public  void deleteStudent(String name){
  repository.deleteStudent(name);
	}
}

