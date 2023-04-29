package com.In5bmGrupo6.db;

import java.sql.*;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author Roberto Saldaña
 * @date 30-08-2022
 * @time 08:55:00 AM Código Técnico; IN5BM
 */
public class Conexion {

    private static final String HOST = "127.0.0.1";
    private static final String PORT = "3306";
    private static final String DB = "tienda_de_juegos";
    private static final String USER = "kinal";
    private static final String PASS = "admin";
    private static final String URL = "jdbc:mysql://"
            + HOST + ":"
            + PORT + "/"
            + DB
            + "?useSSL=false&"
            + "useTimezone=true&"
            + "serverTimezone=UTC&"
            + "allowPublicKeyRetrieval=true";

    private static BasicDataSource instance;

    public static DataSource getInstance() {
        if (instance == null) {
            instance = new BasicDataSource();
            instance.setUrl(URL);
            instance.setUsername(USER);
            instance.setPassword(PASS);
            instance.setInitialSize(25);
        }
        return instance;
    }

    public static Connection getConnection() throws SQLException {
        return getInstance().getConnection();
    }

    public static void close(ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }

    public static void close(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }
    public static void close(PreparedStatement pstmt) {
        try {
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }
}