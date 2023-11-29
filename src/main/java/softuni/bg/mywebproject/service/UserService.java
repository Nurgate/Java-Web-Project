package softuni.bg.mywebproject.service;

import softuni.bg.mywebproject.model.dto.binding.UserRegisterBindingModel;

public interface UserService {
//    List<User> getUsers();
//
//    boolean isUniqueUsername(String value);
//
//    boolean isUniqueEmail(String value);

    void register(UserRegisterBindingModel userRegisterBindingModel);
}
