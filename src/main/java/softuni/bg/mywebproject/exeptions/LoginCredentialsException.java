package softuni.bg.mywebproject.exeptions;

public class LoginCredentialsException extends IllegalArgumentException {
    public LoginCredentialsException (String message) {
        super(message);
    }
}
