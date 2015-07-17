package io.github.shaobin0604.awesomelog;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by bshao on 7/17/15.
 */
public class Log {
    private Log() {
    }

    private static String buildMsg(String msg) {
        StringBuilder buffer = new StringBuilder();

        final StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[4];

        buffer.append("[ ");
        buffer.append(Thread.currentThread().getName());
        buffer.append(": ");
        buffer.append(stackTraceElement.getFileName());
        buffer.append(": ");
        buffer.append(stackTraceElement.getLineNumber());
        buffer.append(": ");
        buffer.append(stackTraceElement.getMethodName());
        buffer.append("() ] -> ");

        buffer.append(msg);

        return buffer.toString();
    }

    private static int sLevel = android.util.Log.VERBOSE;
    private static String sTag = "AwesomeLog";

    public static void setLevel(int level) {
        if (level > android.util.Log.ERROR || level < android.util.Log.VERBOSE) {
            throw new IllegalArgumentException("log level should between VERBOSE and ERROR");
        }
        sLevel = level;
    }

    public static void setTag(String tag) {
        sTag = tag;
    }

    public static boolean isLoggable(int level) {
        return level >= sLevel || android.util.Log.isLoggable(sTag, level);
    }

    public static void v(@NonNull String msg) {
        if (isLoggable(android.util.Log.VERBOSE)) {
            android.util.Log.v(sTag, buildMsg(msg));
        }
    }

    public static void d(@NonNull String msg) {
        if (isLoggable(android.util.Log.DEBUG)) {
            android.util.Log.d(sTag, buildMsg(msg));
        }
    }

    public static void i(@NonNull String msg) {
        if (isLoggable(android.util.Log.INFO)) {
            android.util.Log.i(sTag, buildMsg(msg));
        }
    }

    public static void w(@NonNull String msg) {
        w(msg, null);
    }

    public static void w(@NonNull String msg, @Nullable Exception e) {
        if (isLoggable(android.util.Log.WARN)) {
            if (e != null) {
                android.util.Log.w(sTag, buildMsg(msg), e);
            } else {
                android.util.Log.w(sTag, buildMsg(msg));
            }
        }
    }

    public static void e(@NonNull String msg) {
        e(msg, null);
    }

    public static void e(@NonNull String msg, @Nullable Exception e) {
        if (isLoggable(android.util.Log.ERROR)) {
            if (e != null) {
                android.util.Log.e(sTag, buildMsg(msg), e);
            } else {
                android.util.Log.e(sTag, buildMsg(msg));
            }
        }
    }
}
