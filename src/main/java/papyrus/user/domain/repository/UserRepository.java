package papyrus.user.domain.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import papyrus.user.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}