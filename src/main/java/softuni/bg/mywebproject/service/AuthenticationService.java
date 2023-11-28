package softuni.bg.mywebproject.service;

import softuni.bg.mywebproject.model.dto.binding.UserLoginBindingModel;
import softuni.bg.mywebproject.model.dto.binding.UserRegisterBindingModel;


public interface AuthenticationService {

    void register (UserRegisterBindingModel userRegisterBindingModel);

    void login (UserLoginBindingModel userLoginBindingModel);

    void logout();
}
