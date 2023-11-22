package softuni.bg.mywebproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.bg.mywebproject.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
