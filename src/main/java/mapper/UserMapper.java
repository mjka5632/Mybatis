package mapper;

import entity.User;

import java.util.List;

/**
 * @Author: mrt
 * @Description:
 * @Date: Created in 15:16 2018/12/13
 */
public interface UserMapper {
    public User selectUserByID(int id);

    public List<User> selectUsersByName(String userName);

    public void addUser(User user);

    public void updateUser(User user);

    public void deleteUser(int id);
}
