package softuni.bg.mywebproject.config;

import lombok.RequiredArgsConstructor;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.Provider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import softuni.bg.mywebproject.exeptions.LoginCredentialsException;
import softuni.bg.mywebproject.model.Role;
import softuni.bg.mywebproject.model.User;
import softuni.bg.mywebproject.model.dto.binding.UserRegisterBindingModel;
import softuni.bg.mywebproject.repository.UserRepository;
import softuni.bg.mywebproject.service.RoleService;
import softuni.bg.mywebproject.service.session.LoggedUser;

import java.util.Set;

@Configuration
@RequiredArgsConstructor
public class AppConfig {

    private final LoggedUser loggedUser;
    private final UserRepository userRepository;
    private final RoleService roleService;

    @Bean
    public ModelMapper modelMapper() {
        final ModelMapper modelMapper = new ModelMapper();

        Provider<User> newUserProvider = req -> new User()
                .setRoles(Set.of(roleService.getRoleByName("USER")));


        Converter<String, String> passwordConverter
                = ctx -> (ctx.getSource() == null)
                ? null
                : passwordEncoder().encode(ctx.getSource());

        modelMapper
                .createTypeMap(UserRegisterBindingModel.class, User.class)
                .setProvider(newUserProvider)
                .addMappings(mapper -> mapper
                        .using(passwordConverter)
                        .map(UserRegisterBindingModel::getPassword, User::setPassword));

        return modelMapper;
    }




    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    private User getLoggedUser() {
        final String username = loggedUser.getUsername();
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new LoginCredentialsException("User with username: " + username + " is not present"));
    }
}
