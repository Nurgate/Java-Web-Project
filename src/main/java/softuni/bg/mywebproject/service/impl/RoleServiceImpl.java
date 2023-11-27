package softuni.bg.mywebproject.service.impl;

import org.springframework.stereotype.Service;
import softuni.bg.mywebproject.model.Role;
import softuni.bg.mywebproject.model.enums.UserRoles;
import softuni.bg.mywebproject.repository.RoleRepository;
import softuni.bg.mywebproject.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role getRoleByName(String name) {
        return this.roleRepository.findByName(UserRoles.valueOf(name));
    }
}
