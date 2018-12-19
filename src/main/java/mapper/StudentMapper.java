package mapper;

import entity.Student;

public interface StudentMapper {
    void addStudent(Student s);

    Student getStudentById(String id);

    void updateStudent(Student student);
    void deleteStudentById(String id);
}
