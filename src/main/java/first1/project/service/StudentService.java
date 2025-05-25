package first1.project.service;

import first1.project.data.Student;
import first1.project.data.StudentsCourses;
import first1.project.domain.StudentDetail;
import first1.project.repository.StudentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {

  private StudentRepository repository;

  @Autowired
  public StudentService(StudentRepository repository) {
    this.repository = repository;
  }

  //受講生一覧の検索
  public List<Student>seatchStudentList(){
    return  repository.search();
  }

  //受講生とコース一覧の検索
  public List<StudentsCourses> seatchStudentsCoursesList() {
    return repository.searchStudentsCourses();
  }

  //新規受講生登録
  @Transactional //←システムに登録・更新・削除したときに、途中でエラーがでたらロールバックできるやつ。サービスの段階でつける。
  public void registerStudent(StudentDetail studentDetail){
    repository.registerStudent(studentDetail.getStudent());
  }
}
