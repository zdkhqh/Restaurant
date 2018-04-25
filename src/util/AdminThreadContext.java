package util;

import javax.servlet.http.HttpSession;

public class AdminThreadContext {
    private static ThreadLocal<HttpSession> threadLocal = new ThreadLocal<HttpSession>();

    public static HttpSession get() {
        return threadLocal.get();
    }

    public static void set(HttpSession session) {
        threadLocal.set(session);
    }

    public static void remove() {
        threadLocal.remove();
    }

    public static Integer getId() {
        return (Integer) threadLocal.get().getAttribute("id");
    }

    public static void setId(Integer id) {
        threadLocal.get().setAttribute("id", id);
    }

    public static String getUsername() {
        return (String) threadLocal.get().getAttribute("username");
    }

    public static void setUsername(String username) {
        threadLocal.get().setAttribute("username", username);
    }

    public static String getNickname() {
        return (String) threadLocal.get().getAttribute("nickname");
    }

    public static void setNickname(String nickname) {
        threadLocal.get().setAttribute("nickname", nickname);
    }

}
