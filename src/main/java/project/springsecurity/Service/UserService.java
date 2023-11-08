package project.springsecurity.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.springsecurity.Repository.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
}
