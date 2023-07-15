package sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {
    private Connection connect(){
        String url ="jdbc:sqlite:SQLite.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            conn.createStatement().execute("create table if not exists Users (\n"+
                    " id integer primary key autoincrement,\n"+
                    "name varchar(20) not null,\n"+
                    "phone varchar(20) default null\n"+
                    ");");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    public void update(){
        String sql="update Users set name=? where id =?";
        try (Connection conn = this.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1,"Henry");
            stmt.setInt(2,2);
            stmt.executeUpdate();
            System.out.println("Database updated successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }





}
