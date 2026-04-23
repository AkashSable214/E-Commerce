package com.register.serviceImpl;

import com.register.model.User;
import com.register.repository.UserRepository;
import com.register.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public User saveUser(User user) {

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(user.getEmail());
        mailMessage.setSubject("Register Successfully");
        mailMessage.setSubject("Registration Successful - E-Commerce");

        mailMessage.setText(
                "Dear "+user.getUserName()+",\n\n" +
                        "🎉 Congratulations! Your registration on our E-Commerce platform was successful.\n\n" +
                        "You can now log in to your account and start exploring products, adding items to your cart, and enjoying a seamless shopping experience.\n\n" +
                        "If you have any questions or need assistance, feel free to contact our support team.\n\n" +
                        "Happy Shopping!\n\n" +
                        "Best Regards,\n" +
                        "E-Commerce Team"
        );
        javaMailSender.send(mailMessage);
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
            user2.setUserName(user.getUserName());
            user2.setDob(user.getDob());
            user2.setEmail(user.getEmail());
            user2.setGender(user.getGender());
            user2.setPassword(user.getPassword());
            user2.setPhoneNo(user.getPhoneNo());


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
