package sysu.exceptions;

/**
 * Created by Shower on 2017/6/3 0003.
 */
public class NotLogin extends Exception {
    public NotLogin() {
        super("用户未登录");
    }
}
