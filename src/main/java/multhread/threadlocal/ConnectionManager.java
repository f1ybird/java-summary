package multhread.threadlocal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @Description: ThreadLocal维护数据库连接
 * @Author: zhangkai
 * @Date: 2020/3/22 18:18
 */
public class ConnectionManager {

    private static final ThreadLocal<Connection> dbConnectionLocal = ThreadLocal.withInitial(() -> {
        try {
            return DriverManager.getConnection("", "", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    });

    public Connection getConnection() {
        return dbConnectionLocal.get();
    }
}