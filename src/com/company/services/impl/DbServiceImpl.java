package com.company.services.impl;

import com.company.model.*;
import com.company.services.DbService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public boolean updateCourse(Course course) {
        try {
            Connection conn = getConnection();
            String sql = "UPDATE courses set name = ?, duration = ?, price = ? where courses_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, course.getName());
            ps.setInt(2, course.getDuration());
            ps.setDouble(3, course.getPrice());
            ps.setInt(4, course.getId_course());
            ps.executeUpdate();
            conn.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
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

    @Override
    public List<Teacher> getTeachersList() {
        List<Teacher> list = new ArrayList<>();
        try {
            Connection conn = getConnection();
            String sql = "SELECT teacher_id, name, phone, address FROM teachers";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                Teacher teacher = new Teacher(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4));
                list.add(teacher);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Course> getCourseList() {
        List<Course> list = new ArrayList<>();
        try {
            Connection conn = getConnection();
            String sql = "Select courses_id, name, duration, price FROM courses";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                Course course = new Course(resultSet.getInt(1), resultSet.getString(2),resultSet.getDouble(3),resultSet.getInt(4));
                list.add(course);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean deleteCourse(int course_id) {
        try {
            Connection conn = getConnection();
            String sql = "delete from courses where courses_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, course_id);
            ps.executeUpdate();
            conn.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Student> getStudentsList() {
        List<Student> list = new ArrayList<>();
        try {
            Connection conn = getConnection();
            String sql = "select student_id, name, phone, address FROM students";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                Student student = new Student(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4));
                list.add(student);
            }
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean deleteStudents(int student_id) {
        try {
            Connection conn = getConnection();
            String sql = "delete from students where student_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, student_id);
            ps.executeUpdate();
            conn.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateStudent(Student student) {
        try {
            Connection conn = getConnection();
            String sql = "UPDATE students set name = ?, phone = ?, address = ? where student_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, student.getName());
            ps.setString(2, student.getPhone());
            ps.setString(3, student.getAddress());
            ps.setInt(4, student.getId());
            ps.executeUpdate();
            conn.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
