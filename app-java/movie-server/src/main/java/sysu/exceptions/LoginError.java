package sysu.exceptions;

/**
 * Created by Shower on 2017/6/3 0003.
 */
public class LoginError extends Exception {
    public LoginError() {
        super("用户名或密码错误");
    }
}
