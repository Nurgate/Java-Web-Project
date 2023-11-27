package softuni.bg.mywebproject.service;

import org.springframework.stereotype.Service;
import softuni.bg.mywebproject.model.Role;

@Service
public interface RoleService {

    Role getRoleByName (String name);
}
