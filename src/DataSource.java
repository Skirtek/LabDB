import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

class DataSource {

    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource dataSource;

    static {
        config.setJdbcUrl(DatabaseSettings.DBURL);
        config.setUsername(DatabaseSettings.DBUSER);
        config.setPassword(DatabaseSettings.DBPASS);
        config.setMaximumPoolSize(1);
        dataSource = new HikariDataSource(config);
    }

    private DataSource(){
    }

    static Connection GetConnection() throws SQLException{
        return dataSource.getConnection();
    }
}
