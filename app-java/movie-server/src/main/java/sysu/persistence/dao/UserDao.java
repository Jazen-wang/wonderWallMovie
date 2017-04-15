package sysu.persistence.dao;

import sysu.persistence.models.User;

import java.util.List;

/**
 * Created by shower on 17-4-14.
 */
public interface UserDao {

    User findOne(long id);

    List<User> findAll();

    void create(User entity);

    User update(User entity);

    void delete(User entity);

    void deleteById(long entityId);
}
