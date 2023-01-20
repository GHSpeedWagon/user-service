package speed.wagon.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import speed.wagon.userservice.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
