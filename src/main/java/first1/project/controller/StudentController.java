package first1.project.controller;

import first1.project.controller.converter.StudentConverter;
import first1.project.data.Student;
import first1.project.data.StudentsCourses;
import first1.project.domain.StudentDetail;
import first1.project.service.StudentService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class StudentController {

public StudentService service;
public StudentConverter converter;

@Autowired
  public StudentController(StudentService service, StudentConverter converter) {
    this.service = service;
    this.converter = converter;
  }

  @GetMapping("/studentList")
  public String  getStudentList(Model model){
    List<Student> students = service.seatchStudentList();
    List<StudentsCourses> studentsCourses = service.seatchStudentsCoursesList();


    model.addAttribute("studentList",converter.convertStudentDetails(students, studentsCourses));
    return "studentList";
  }

  @GetMapping("/studentsCoursesList")
  public List<StudentsCourses> getStudentsCoursesList() {
    return service.seatchStudentsCoursesList();
  }

  @GetMapping("/newStudent")
  public String newStudent(Model model){
    model.addAttribute("studentDetail" , new StudentDetail());
    return "registerStudent";
  }

  @PostMapping("/registerStudent")
  public String  registerStudent(@ModelAttribute StudentDetail studentDetail, BindingResult result){
    if(result.hasErrors()) {
      return "registerStudent";
    }

    Student student = studentDetail.getStudent();
    service.registerStudent(studentDetail);
    return "redirect:/studentList";
  }
}
