package tranminhduc.pro.democrudspringboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tranminhduc.pro.democrudspringboot.model.User;
@Repository
public interface UserRepository extends CrudRepository<User, Long> {


}
