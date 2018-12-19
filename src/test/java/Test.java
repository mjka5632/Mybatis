import entity.*;
import entity.Class;
import mapper.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: mrt
 * @Description:
 * @Date: Created in 15:21 2018/12/13
 */
public class Test {

    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;

    static {
        try {
            //通过配置文件初始化sqlSessionFactory
            reader = Resources.getResourceAsReader("Configuration.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSession() {
        return sqlSessionFactory;
    }

    public void getUserByID(int userID) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            UserMapper userOperation = session
                    .getMapper(UserMapper.class);
            User user = userOperation.selectUserByID(userID);
            if (user != null) {
                System.out.println(user.getId() + ":" + user.getUserName()
                        + ":" + user.getUserAddress());
            }

        } finally {
            session.close();
        }
    }

    public void getUserList(String userName) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            UserMapper userOperation = session
                    .getMapper(UserMapper.class);
            List<User> users = userOperation.selectUsersByName(userName);
            for (User user : users) {
                System.out.println(user.getId() + ":" + user.getUserName()
                        + ":" + user.getUserAddress());
            }

        } finally {
            session.close();
        }
    }

    /**
     * 增加后要commit
     */
    /*public void addUser() {
        User user = new User();
        user.setId();
        user.setUserName();
        user.setUserAge();
        user.setUserAddress();
        user.setUserAddress("place");
        user.setUserName("test_add");
        user.setUserAge(30);
        SqlSession session = sqlSessionFactory.openSession();
        try {
            UserMapper userOperation = session
                    .getMapper(UserMapper.class);
            userOperation.addUser(user);
            session.commit();
            System.out.println("新增用户ID：" + user.getId());
        } finally {
            session.close();
        }
    }*/

    /**
     * 修改后要commit
     */
    public void updateUser() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            UserMapper userOperation = session
                    .getMapper(UserMapper.class);
            User user = userOperation.selectUserByID(1);
            if (user != null) {
                user.setUserAddress("A new place");
                userOperation.updateUser(user);
                session.commit();
            }
        } finally {
            session.close();
        }
    }

    /**
     * 删除后要commit.
     *
     * @param id
     */
    public void deleteUser(int id) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            UserMapper userOperation = session
                    .getMapper(UserMapper.class);
            userOperation.deleteUser(id);
            session.commit();
        } finally {
            session.close();
        }
    }

    public void getUserArticles(int userid) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            ArticleMapper articleOperation = session
                    .getMapper(ArticleMapper.class);
            List<Article> articles = articleOperation.getUserArticles(userid);
            for (Article article : articles) {
                System.out.println(article.getTitle() + ":"
                        + article.getContent() + "用户名："
                        + article.getUser().getUserName() + "用户地址："
                        + article.getUser().getUserAddress());
            }
        } finally {
            session.close();
        }
    }
    /*---------------Class-----------------*/

    /**
     * 添加班级
     *
     * @param cl
     */
    public void addClass(Class cl) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            ClassMapper mapper = session.getMapper(ClassMapper.class);
            mapper.addClass(cl);
            //需要进行提交
            session.commit();

        } finally {
            session.close();
        }
    }

    /**
     * 通过Id删除class
     *
     * @param id
     */
    public void delClaById(String id) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            ClassMapper mapper = session.getMapper(ClassMapper.class);
            mapper.delClaById(id);
            session.commit();

        } finally {
            session.close();
        }
    }

    /**
     * 通过Id修改class
     *
     * @param id
     */
    public void updateClaById(String id) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            ClassMapper mapper = session.getMapper(ClassMapper.class);
            Class cla = mapper.getClaById(id);
            if (cla != null) {
                cla.setName("一年三班");
                mapper.updateClaById(cla);
            }
            session.commit();

        } finally {
            session.close();
        }
    }

    /**
     * 通过Id查找Class
     */
    public void getClaById(String id) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            ClassMapper mapper = session.getMapper(ClassMapper.class);
            Class cla = mapper.getClaById(id);
            System.out.println(cla);
//            System.out.println();

        } finally {
            session.close();
        }
    }
    /*---------------Student-----------------*/

    /**
     * 添加学生
     *
     * @param cl
     */
    public void addStudent(Student cl) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            mapper.addStudent(cl);
            //需要进行提交
            session.commit();

        } finally {
            session.close();
        }
    }

    /**
     * Student
     *
     * @param id
     */
    public void updateStudentById(String id) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            Student cla = mapper.getStudentById(id);
            if (cla != null) {
                cla.setName("王五");
                mapper.updateStudent(cla);
            }
            session.commit();

        } finally {
            session.close();
        }
    }

    /**
     * 通过Id查找Student
     *
     * @param id
     */
    public void getStu(String id) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            Student cla = mapper.getStudentById(id);
            System.out.println(cla);

        } finally {
            session.close();
        }
    }

    /**
     * 通过Id删除Student
     *
     * @param id
     */
    public void delStudentById(String id) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            mapper.deleteStudentById(id);
            session.commit();

        } finally {
            session.close();
        }
    }
    /*---------------Score-----------------*/

    /**
     * 添加成绩
     *
     * @param cl
     */
    public void addScore(Score cl) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            ScoreMapper mapper = session.getMapper(ScoreMapper.class);
            mapper.addScore(cl);
            //需要进行提交
            session.commit();

        } finally {
            session.close();
        }
    }

    /**
     * Score
     *
     * @param id
     */
    public void updateScoreById(String id) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            ScoreMapper mapper = session.getMapper(ScoreMapper.class);
            Score cla = mapper.getScoreById(id);
            if (cla != null) {
                cla.setScore("50");
                mapper.updateScore(cla);
            }
            session.commit();

        } finally {
            session.close();
        }
    }

    /**
     * 通过Id查找Score
     *
     * @param id
     */
    public void getScore(String id) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            ScoreMapper mapper = session.getMapper(ScoreMapper.class);
            Score cla = mapper.getScoreById(id);
            System.out.println(cla);

        } finally {
            session.close();
        }
    }

    /**
     * 通过Id删除Score
     *
     * @param id
     */
    public void delScoreById(String id) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            ScoreMapper mapper = session.getMapper(ScoreMapper.class);
            mapper.deleteScoreById(id);
            session.commit();

        } finally {
            session.close();
        }
    }

    /*---------------Course-----------------*/

    /**
     * 添加Course
     *
     * @param cl
     */
    public void addCourse(Course cl) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            CourseMapper mapper = session.getMapper(CourseMapper.class);
            mapper.addCourse(cl);
            //需要进行提交
            session.commit();

        } finally {
            session.close();
        }
    }

    /**
     * 修改Course
     *
     * @param id
     */
    public void updateCourseById(String id) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            CourseMapper mapper = session.getMapper(CourseMapper.class);
            Course cla = mapper.getCourseById(id);
            if (cla != null) {
                cla.setName("Chinese");
                mapper.updateCourse(cla);
            }
            session.commit();

        } finally {
            session.close();
        }
    }

    /**
     * 通过Id查找Student
     *
     * @param id
     */
    public void getCourse(String id) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            CourseMapper mapper = session.getMapper(CourseMapper.class);
            Course cla = mapper.getCourseById(id);
            System.out.println(cla);

        } finally {
            session.close();
        }
    }

    /**
     * 通过Id删除Student
     *
     * @param id
     */
    public void delCourseById(String id) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            CourseMapper mapper = session.getMapper(CourseMapper.class);
            mapper.deleteCourseById(id);
            session.commit();

        } finally {
            session.close();
        }
    }

    public void getBlogArticles(int blogid) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            BlogMapper blogOperation = session
                    .getMapper(BlogMapper.class);
            Blog blog = blogOperation.getBlogByID(blogid);
            System.out.println(blog.getTitle() + ":");
            List<Article> articles = blog.getArticles();
            for (Article article : articles) {
                System.out.println(article.getTitle() + ":"
                        + article.getContent() + "用户名："
                        + article.getUser().getUserName() + "用户地址："
                        + article.getUser().getUserAddress());
                /*System.out.println(article.getTitle() + ":"
                        + article.getContent());*/
            }
        } finally {
            session.close();
        }
    }
        /*---------------四道题-----------------*/
        /**
         * 【一】某人的数学成绩
         *
         * @param name
         */

        public void getSomeBodyScore(String name) {
            SqlSession session = sqlSessionFactory.openSession();
            try {
                ScoreMapper mapper = session.getMapper(ScoreMapper.class);
                String s = mapper.question1(name);
                System.out.println(name+"数学成绩"+s);

            } finally {
                session.close();
            }


    }
    /**
     * 【二】某人学了几门课
     *
     * @param name
     */

    public void getCountCourse(String name) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            ScoreMapper mapper = session.getMapper(ScoreMapper.class);
            Integer integer = mapper.question2(name);
            System.out.println(name+"共参加了"+integer+"门课");

        } finally {
            session.close();
        }


    }
    /**
     * 【三】某人每门课的成绩
     *
     * @param name
     */

    public void getEveryCourseScore(String name) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            ScoreMapper mapper = session.getMapper(ScoreMapper.class);
            List<Map<String,String>> arrayList = mapper.question3(name);
            System.out.println(arrayList.toString());

        } finally {
            session.close();
        }


    }

    /**
     * 【四】某班某课的平均成绩
     *
     * @param cla
     */

    public void avgScoreByClass(String cla) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            ScoreMapper mapper = session.getMapper(ScoreMapper.class);
//            ArrayList arrayList = mapper.question3(name);
            Integer integer = mapper.question4(cla);
            System.out.println(cla+"数学课的平均成绩："+integer);

        } finally {
            session.close();
        }


    }


    public static void main(String[] args) {
        try {
            Test test = new Test();
            // test.getUserByID(1);
            // test.getUserList("test1");
            // test.addUser();
            // test.updateUser();
            // test.deleteUser(6);
//test.getCount();
//            test.getUserArticles(1);

//            test.getBlogArticles(1);
            //------------class CURD
            //--1 add
//            Class aClass = new Class();
//            aClass.setId("C4");
//            aClass.setName("一年四班");
//            test.addClass(aClass);
            //--2select
//            test.getClaById("c2");
            //--3delete
//            test.delClaById("C9");
            //--4update
//            test.updateClaById("C3");
            //------------student CURD
            //--1 add
//            Student student = new Student();
//            student.setId("s105");
//            student.setName("李五");
//            student.setCid("C1");
//            test.addStudent(student);
            //--2select
//            test.getStu("s101");
            //--3delete
//            test.delStudentById("s105");
            //--4update
//            test.updateStudentById("s101");
            //------------Course CURD
            //--1 add
//            Course course = new Course();
//            course.setId("k04");
//            course.setName("地理");
//            test.addCourse(course);
            //--2select
//            test.getCourse("K01");
            //--3delete
//            test.delCourseById("k04");
            //--4update
//            test.updateCourseById("K01");
            //------------Score CURD
            //--1 add
//            Score score = new Score();
//            score.setStid("st105");
//            score.setCoid("K03");
//            score.setScore("1");
//            test.addScore(score);
            //--2select
//            test.getScore("st105");
            //--3delete
//            test.delScoreById("st105");
            //--4update、
//            test.updateScoreById("st105");
            //----------------------------四道题
            //【一】某人的数学成绩
//            test.getSomeBodyScore("王五");
            //【二】某人学了几门课
//            test.getCountCourse("王五");
            //【三】某人每门课的成绩
//            test.getEveryCourseScore("王五");
            //【四】某班某课的平均成绩
            test.avgScoreByClass("一年一班");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}