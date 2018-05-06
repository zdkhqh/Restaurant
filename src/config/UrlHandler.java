package config;

import com.jfinal.handler.Handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UrlHandler extends Handler {
    @Override
    public void handle(String target, HttpServletRequest request, HttpServletResponse response, boolean[] isHandled) {
        if (target.endsWith(".shtml")) target = target.substring(0, target.length() - 6);
        else if (target.endsWith(".html") || target.endsWith(".shtm"))
            target = target.substring(0, target.length() - 5);
        else if (target.endsWith(".jsp") ||
                target.endsWith(".asp") ||
                target.endsWith(".stm ") ||
                target.endsWith(".htm")) target = target.substring(0, target.length() - 4);
        request.setAttribute("cxt", request.getContextPath());
        next.handle(target, request, response, isHandled);
    }
}
