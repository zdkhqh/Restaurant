package intercept;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import util.AdminThreadContext;

public class SessionIntercept implements Interceptor {
    @Override
    public void intercept(Invocation inv) {
        AdminThreadContext.set(inv.getController().getSession());
        inv.invoke();
        AdminThreadContext.remove();
    }
}
