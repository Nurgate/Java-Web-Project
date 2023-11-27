package softuni.bg.mywebproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.bg.mywebproject.model.Role;
import softuni.bg.mywebproject.model.enums.UserRoles;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName (UserRoles role);
}
