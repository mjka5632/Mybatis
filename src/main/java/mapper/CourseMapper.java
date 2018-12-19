package mapper;

import entity.Course;

public interface CourseMapper {
    void addCourse(Course s);

    Course getCourseById(String id);

    void updateCourse(Course student);
    void deleteCourseById(String id);
}
