package jeeno.example.demo;

import ch.qos.logback.classic.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: Jeeno
 * @version: 0.0.1
 * @since: 2019/7/12 14:34
 *
 * logger 有日志打印级别，可以为一个 logger 指定它的日志打印级别。
 * 如果不为一个 logger 指定打印级别，那么它将继承离他最近的一个有指定打印级别的祖先的打印级别。
 * 如果 logger 先找它的父亲，而它的父亲没有指定打印级别，那么它会往上继续寻找它爷爷，直到它找到 root logger。
 * 因此，也能看出来，要使用 logback， 必须为 root logger 指定日志打印级别。
 *
 * 日志打印级别从低级到高级排序的顺序是：
 * TRACE < DEBUG < INFO < WARN < ERROR
 * 如果一个 logger 允许打印一条具有某个日志级别的信息，那么它也必须允许打印具有比这个日志级别更高级别的信息，
 * 而不允许打印具有比这个日志级别更低级别的信息。
 *
 *  相关内容可参考https://www.cnblogs.com/GodHeng/p/9268379.html。
 */
public class LogTest {
    public static void main(String[] args) {

        //这里强制类型转换时为了能设置 logger 的 Level
        ch.qos.logback.classic.Logger logger =
                (ch.qos.logback.classic.Logger) LoggerFactory.getLogger("com.foo");
        logger.setLevel(Level.INFO);

        Logger barlogger = LoggerFactory.getLogger("com.foo.Bar");

        // 这个语句能打印，因为 WARN > INFO
        logger.warn("can be printed because WARN > INFO");

        // 这个语句不能打印，因为 DEBUG < INFO.
        logger.debug("can not be printed because DEBUG < INFO");

        // barlogger 是 logger 的一个子 logger
        // 它继承了 logger 的级别 INFO
        // 以下语句能打印，因为 INFO >= INFO
        barlogger.info("can be printed because INFO >= INFO");

        // 以下语句不能打印，因为 DEBUG < INFO
        barlogger.debug("can not be printed because DEBUG < INFO");
    }
}
