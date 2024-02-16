package backend.Repository;

import backend.Entity.MdUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface MdUserRepository extends JpaRepository<MdUser, UUID> {
    Optional<MdUser> findByEmail(String email);
    
    Boolean existsByEmail(String email);
}
