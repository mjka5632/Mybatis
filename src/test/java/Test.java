import entity.Article;
import entity.Blog;
import entity.User;
import mapper.ArticleMapper;
import mapper.BlogMapper;
import mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.util.List;

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
    public void addUser() {
        User user = new User();
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
    }

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

    public static void main(String[] args) {
        try {
            Test test = new Test();
            // test.getUserByID(1);
            // test.getUserList("test1");
            // test.addUser();
            // test.updateUser();
            // test.deleteUser(6);

            //test.getUserArticles(1);

            test.getBlogArticles(1);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}