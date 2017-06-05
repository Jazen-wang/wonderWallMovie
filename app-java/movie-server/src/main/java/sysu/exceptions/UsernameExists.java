package sysu.exceptions;

/**
 * Created by Shower on 2017/6/3 0003.
 */
public class UsernameExists extends Exception {
    public UsernameExists() {
        super("用户名已存在");
    }
}
