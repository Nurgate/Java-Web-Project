package softuni.bg.mywebproject.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.bg.mywebproject.model.User;
import softuni.bg.mywebproject.repository.UserRepository;
import softuni.bg.mywebproject.service.UserService;
import softuni.bg.mywebproject.service.session.LoggedUser;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

//    @Autowired
    private final UserRepository userRepository;
    private final LoggedUser loggedUser;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, LoggedUser loggedUser, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.loggedUser = loggedUser;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public boolean isUniqueUsername(String value) {
        return false;
    }

    @Override
    public boolean isUniqueEmail(String value) {
        return false;
    }

}
