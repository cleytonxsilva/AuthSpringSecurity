package project.springsecurity.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.springsecurity.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
