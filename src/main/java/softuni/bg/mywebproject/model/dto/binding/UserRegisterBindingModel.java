package softuni.bg.mywebproject.model.dto.binding;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import softuni.bg.mywebproject.validation.annotations.PasswordMatch;
import softuni.bg.mywebproject.validation.annotations.UniqueEmail;
import softuni.bg.mywebproject.validation.annotations.UniqueUsername;

@PasswordMatch
@Getter
@Setter
public class UserRegisterBindingModel {

    @NotNull
    @Size(min = 2, message = "{user.first-name.length}")
    private String firstName;


    @NotNull
    @Size(min = 2, message = "{user.last-name.length}")
    private String lastName;

    @NotNull
    @UniqueUsername
    @Size(min = 2, message = "{user.username.length}")
    private String username;

    @NotNull
    @Enumerated(EnumType.STRING)
    private String gender;

    @NotNull
    @UniqueEmail
    @Email(regexp = ".+[@].+", message = "{user.email}")
    private String email;

    @Size(min = 2, message = "{user.password.length}")
    private String password;

    @Size(min = 2, message = "{user.confirm-password.length}")
    private String confirmPassword;

    public UserRegisterBindingModel () {

    }
}
