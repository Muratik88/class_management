package com.company.services.impl;

import com.company.model.*;
import com.company.services.DbService;

import java.sql.*;

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

    public boolean createGroup(Group group){
        try {
            Connection conn = getConnection();
            String sql = "INSERT INTO groups(course_id, teacher_id, start_date) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, group.getCourseId());
            ps.setInt(2, group.getTeacherId());
            ps.setString(3,group.getStartDate().toString());
            ps.executeUpdate();
            conn.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean appendTeacher(Teacher teacher) {
        try {
            Connection conn = getConnection();
            String sql = "INSERT INTO teachers(name, phone, address) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, teacher.getName());
            ps.setString(2, teacher.getPhone());
            ps.setString(3, teacher.getAddress());
            ps.executeUpdate();
            conn.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public boolean appendStudent(Student student) {
        try {
            Connection conn = getConnection();
            String sql = "INSERT INTO students(name, phone, address) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, student.getName());
            ps.setString(2, student.getPhone());
            ps.setString(3, student.getAddress());
            ps.executeUpdate();
            conn.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean appendUser(User user) {
        try {
            Connection conn = getConnection();
            String sql = "INSERT INTO users(user_name, user_pass) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.setString(2, user.getPassword());
            ps.executeUpdate();
            conn.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean checkUser(String login, String password) {
        try {
            Connection conn = getConnection();
            String sql = "SELECT user_name, user_pass FROM users WHERE user_name = ? AND user_pass = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, login);
            ps.setString(2, password);
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()){
//                System.out.println(login);
//                System.out.println(password);
                conn.close();
                return true;
            }else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


}
