package FridgeWizard.backend.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Boolean existsByEmail(String email);
    Optional<User> getUserByEmail(String email);
    Boolean existsByUsername(String username);
    Optional<User> getUserByUsername(String username);
    Boolean existsByUserId(Long userId);
    Optional<User> getUserByUserId(Long userId);

}
