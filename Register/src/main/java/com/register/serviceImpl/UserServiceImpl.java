package com.register.serviceImpl;

import com.register.model.User;
import com.register.repository.UserRepository;
import com.register.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {

        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId).get();
    }

    @Override
    public User updateUser(Long userId, User user) {
        Optional<User> oUser= userRepository.findById(userId);
        if(oUser.isPresent()){
            User user2=oUser.get();
            user2.setDob(user.getDob());
            user2.setEmail(user.getEmail());
            user2.setGender(user.getGender());
            user2.setPassword(user.getPassword());
            user2.setUpdatedate(user.getUpdatedate());
            user2.setPhoneNo(user.getPhoneNo());
            user2.setCreatedDate(user.getCreatedDate());

           return userRepository.save(user2);
        }
        return null;
    }

    @Override
    public String deleteUserById(Long userId) {
        userRepository.deleteById(userId);
        return  userId+" is deleted successfully";
    }
}
