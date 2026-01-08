package org.xproce.projet.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.xproce.projet.dao.entities.User;
import org.xproce.projet.dao.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserManager implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User deleteUser(Integer id) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            userRepository.delete(user);
        }
        return user;
    }

    @Override
    public User getByName(User user) {
        return userRepository.findByName(user.getName());
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


}
