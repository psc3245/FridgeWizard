package FridgeWizard.backend.Users;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Boolean existsByEmail(String email);
    Optional<User> getUserByEmail(String email);
    Boolean existsByUsername(String username);
    Optional<User> getUserByUsername(String username);
    Boolean existsByUserId(Long userId);
    Optional<User> getUserByUserId(Long userId);

}
