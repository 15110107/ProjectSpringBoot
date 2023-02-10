package com.example.hometest.User;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.hometest.ResourceNotFoundException;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User User) {
        return userRepository.save(User);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserByUserId(long Userid) {
        return userRepository.findById(Userid).orElseThrow(
                () -> new ResourceNotFoundException("User", "Userid", Userid));
    }

    @Override
    public User updateUser(User User, long Userid) {

        User existingUser = userRepository.findById(Userid).orElseThrow(
                () -> new ResourceNotFoundException("User", "Userid", Userid));

        existingUser.setFullName(User.getFullName());
        existingUser.setPassword(User.getPassword());
        existingUser.setNotificationToken(User.getNotificationToken());
        userRepository.save(existingUser);
        return existingUser;
    }

    @Override
    public void deleteUser(long Userid) {
        userRepository.findById(Userid).orElseThrow(
                () -> new ResourceNotFoundException("User", "Userid", Userid));
        userRepository.deleteById(Userid);
    }
}
