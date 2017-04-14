package sysu;

/**
 * Created by shower on 17-4-14.
 */
public class UserDaoImpl extends AbstractJpaDAO<User> implements UserDao {
    public UserDaoImpl() {
        super();

        setClazz(User.class);
    }
}
