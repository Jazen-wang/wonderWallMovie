package sysu.exceptions;

/**
 * Created by Shower on 2017/6/3 0003.
 */
public class UserNotFound extends Exception {
    public UserNotFound() {
        super("用户不存在");
    }
}
