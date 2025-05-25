package first1.project.domain;

import first1.project.data.Student;
import first1.project.data.StudentsCourses;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDetail {

  private Student student;
  private List<StudentsCourses>studentsCourses;
}
