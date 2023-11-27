package softuni.bg.mywebproject.validation.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import softuni.bg.mywebproject.validation.validators.UniqueUsernameValidator;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ FIELD, PARAMETER })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = { UniqueUsernameValidator.class })
public @interface UniqueUsername {

    String message() default "{user.username.unique}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
