package src.test.java.pageObject.common.utilities;

import org.testng.Reporter;

public abstract class Log {

    private static Reporter reporter = new Reporter();

    public Log(){}

    public static void info(String message){
        reporter.log(message, true);
    }
}
