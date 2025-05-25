package first1.project.repository;

import first1.project.data.Student;
import first1.project.data.StudentsCourses;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface StudentRepository {

  @Select("SELECT * FROM students")
  List<Student> search();

  @Select("SELECT * FROM students_courses")
  List<StudentsCourses> searchStudentsCourses();

    @Insert(
        "INSERT INTO students(name, furigana,nickname,age,mail,address,gender,remark,is_deleted)"
    + "VALUES (#{name}, #{furigana}, #{nickname}, #{age}, #{mail}, #{address}, #{gender}, #{remark}, false)")
    @Options(useGeneratedKeys = true, keyProperty = "id")
  void registerStudent(Student student);
}