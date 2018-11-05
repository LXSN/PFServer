package mgazul.PFServer.remapper;

import java.lang.reflect.Method;

/**
 * Based on Apache's ReflectionUtil
 * @author Maxqia
 */
public class ReflectionUtils {

    public static Class<?> getCallerClass(int skip) {
        final Class<?>[] clazz = new Class<?>[1];
        new SecurityManager() {
            {
                clazz[0] = getClassContext()[skip + 1];
            }
        };
        return clazz[0];
    }

    public static ClassLoader getCallerClassloader() {
        return ReflectionUtils.getCallerClass(3).getClassLoader(); // added one due to it being the caller of the caller;
    }
}
