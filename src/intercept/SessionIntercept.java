package intercept;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import util.UserThreadContext;

public class SessionIntercept implements Interceptor {
    @Override
    public void intercept(Invocation inv) {
        UserThreadContext.set(inv.getController().getSession());
        inv.invoke();
        UserThreadContext.remove();
    }
}
