package org.xproce.projet.service;
import java.util.List;
import org.xproce.projet.dao.entities.User;

public interface UserService {
    public User addUser(User user);
    public User updateUser(User user);
    public User deleteUser(Integer id);
    public User getUserById(Integer id);
    public User getByName(User user);
    public List<User> getAllUsers();
}
