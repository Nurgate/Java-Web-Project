package softuni.bg.mywebproject.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import softuni.bg.mywebproject.exeptions.LoginCredentialsException;
import softuni.bg.mywebproject.model.User;
import softuni.bg.mywebproject.model.dto.binding.UserLoginBindingModel;
import softuni.bg.mywebproject.model.dto.binding.UserRegisterBindingModel;
import softuni.bg.mywebproject.repository.UserRepository;
import softuni.bg.mywebproject.service.AuthenticationService;
import softuni.bg.mywebproject.service.session.LoggedUser;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final LoggedUser loggedUser;

    @Override
    public void register(UserRegisterBindingModel userRegisterBindingModel) {
        User user = modelMapper.map(userRegisterBindingModel, User.class);
        userRepository.save(user);
    }

    @Override
    public void login(UserLoginBindingModel userLoginBindingModel) {
        String username = userLoginBindingModel.getUsername();

        User user = this.userRepository
                .findByUsername(username)
                .orElseThrow(() -> new LoginCredentialsException("User with username: [" + username + "] is not present"));

        boolean passwordMatch = passwordEncoder.matches(userLoginBindingModel.getPassword(),
                                                        user.getPassword());

        if (!passwordMatch){
            throw new LoginCredentialsException("User entered incorrect password");
        }

        loggedUser.setUsername(user.getUsername())
                .setLogged(true)
                .setRoles(user.getRoles());
    }

    @Override
    public void logout() {
        loggedUser.reset();
    }
}
