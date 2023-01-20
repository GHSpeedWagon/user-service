package speed.wagon.userservice.service;

import speed.wagon.userservice.model.User;

public interface UserService {
    User save(User user);

    User getById(Long id);

    User update(User user);

    void delete(Long id);
}
