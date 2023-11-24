package softuni.bg.mywebproject.service.session;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import softuni.bg.mywebproject.model.Role;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Component
@Getter
@Setter
public class LoggedUser {

    private String username;
    private Set<Role> roles;
    private boolean isLogged;

    public LoggedUser () {
        this.roles = new HashSet<>();
    }

    public void reset() {
        this
                .setUsername(null)
                .setRoles(Collections.emptySet())
                .setLogged(false);
    }

    public LoggedUser setUsername (String username) {

        this.username = username;
        return this;
    }

    public LoggedUser setRoles (Set<Role> roles) {
        this.roles = roles;
        return this;
    }

    private boolean isLogged () {
        return isLogged;
    }

    public LoggedUser setLogged (boolean logged) {
        isLogged = logged;
        return this;
    }

    public boolean isAdmin() {
        return this.roles.stream()
                .anyMatch(role -> role.getName().equals("UserRoles.ADMIN"));
    }
}
