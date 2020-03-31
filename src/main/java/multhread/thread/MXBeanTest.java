package multhread.thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @Description: 打印java程序有哪些线程
 * @Author: zhangkai
 * @Date: 2020/3/16 23:38
 */
public class MXBeanTest {

    public static void main(String[] args) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println(threadInfo.getThreadId() + "-" + threadInfo.getThreadName());
        }

        //执行结果
        /*
         8-JDWP Command Reader
         7-JDWP Event Helper Thread
         6-JDWP Transport Listener: dt_socket
         5-Attach Listener
         4-Signal Dispatcher
         3-Finalizer
         2-Reference Handler
         1-main
         **/
    }
}
