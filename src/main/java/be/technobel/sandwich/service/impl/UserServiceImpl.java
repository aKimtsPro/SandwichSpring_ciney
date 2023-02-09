package be.technobel.sandwich.service.impl;

import be.technobel.sandwich.repository.UserRepository;
import be.technobel.sandwich.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean checkEmailNotTaken(String email){
        return !userRepository.existsByEmail(email);
    }
}
