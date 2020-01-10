package tranminhduc.pro.democrudspringboot.service;

import org.springframework.stereotype.Service;
import tranminhduc.pro.democrudspringboot.model.User;

import java.util.Optional;

public interface UserService {
    Iterable<User> findAll();
    Optional<User> findById(Long id);
    void save(User user);
    void remove(Long id);
}
