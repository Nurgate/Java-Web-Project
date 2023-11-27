package softuni.bg.mywebproject.validation.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;
import softuni.bg.mywebproject.service.UserService;
import softuni.bg.mywebproject.validation.annotations.UniqueUsername;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {
    private final UserService userService;
    private String message;

    public UniqueUsernameValidator (UserService userService) {

        this.userService = userService;
    }

    @Override
    public void initialize (UniqueUsername constraintAnnotation) {

        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid (String value, ConstraintValidatorContext context) {

        if (value == null) {

            return true;

        } else {

            final boolean isUnique = userService.isUniqueUsername(value);

            if (!isUnique) replaceDefaultConstraintViolation(context, this.message);

            return isUnique;
        }
    }

    private void replaceDefaultConstraintViolation (ConstraintValidatorContext context, String message) {

        context
                .unwrap(HibernateConstraintValidatorContext.class)
                .buildConstraintViolationWithTemplate(message)
                .addConstraintViolation()
                .disableDefaultConstraintViolation();
    }
}
