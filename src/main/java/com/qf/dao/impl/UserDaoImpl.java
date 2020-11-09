package com.qf.dao.impl;

import com.qf.dao.UserDao;
import com.qf.pojo.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {


    @Override
    public List<User> findAll() {
        //1.加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //2.创建链接
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mishop", "root", "hcxdmysql");
            //3.创建链接对象
            Statement statement = connection.createStatement();
            //4.编写sql
            String sql = "select * from users";
            //5.执行sql
            ResultSet resultSet = statement.executeQuery(sql);
            //创建list
            ArrayList arrayList = new ArrayList();

            while (resultSet.next()) {
                User user = new User();
                user.setU_id(resultSet.getInt("u_id"));
                user.setU_name(resultSet.getString("u_name"));
                user.setU_pass(resultSet.getString("u_pass"));
                user.setU_email(resultSet.getString("u_email"));

                arrayList.add(user);
            }
            return arrayList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
