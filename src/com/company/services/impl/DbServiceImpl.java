package com.company.services.impl;

import com.company.model.Course;
import com.company.services.DbService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbServiceImpl implements DbService {
    private Connection getConnection() throws SQLException {
        String url = "jdbc:sqlite:db/dbclassmng.db";
        //String url = "jdbc:sqlite:D:\\DB\\dbclassmng.db";
        Connection conn = DriverManager.getConnection(url);
        return conn;
    }

    @Override
    public boolean createCourse(Course course) {
        try {
            Connection conn = getConnection();
            String sql = "INSERT into courses(name, duration, price) VALUES(?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, course.getName());
            ps.setInt(2, course.getDuration());
            ps.setDouble(3, course.getPrice());

            ps.executeUpdate();
            conn.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
