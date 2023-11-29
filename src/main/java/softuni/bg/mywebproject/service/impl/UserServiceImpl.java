package softuni.bg.mywebproject.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import softuni.bg.mywebproject.model.User;
import softuni.bg.mywebproject.model.dto.binding.UserRegisterBindingModel;
import softuni.bg.mywebproject.repository.UserRepository;
import softuni.bg.mywebproject.service.UserService;
import softuni.bg.mywebproject.service.session.LoggedUser;

@Service
public class UserServiceImpl implements UserService {

//    @Autowired
    private final UserRepository userRepository;
    private final LoggedUser loggedUser;
    private final ModelMapper modelMapper;

    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, LoggedUser loggedUser, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.loggedUser = loggedUser;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

//    @Override
//    public List<User> getUsers() {
//        return userRepository.findAll();
//    }
//
//    @Override
//    public boolean isUniqueUsername(String value) {
//        return false;
//    }
//
//    @Override
//    public boolean isUniqueEmail(String value) {
//        return false;
//    }

        @Override
        public void register(UserRegisterBindingModel userRegisterBindingModel) {
            User user = modelMapper.map(userRegisterBindingModel, User.class);
            user.setPassword(passwordEncoder.encode(userRegisterBindingModel.getPassword()));
            userRepository.save(user);
        }

        private User getLoggedUser() {
            return userRepository.findByUsername(loggedUser.getUsername())
                    .orElseThrow(() -> new IllegalArgumentException("User not found!"));
        }
}
