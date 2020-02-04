package com.example.demo.testing;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class StudentJDBCTemplate implements StudentDAO {
   public DataSource dataSource;
   public JdbcTemplate jdbcTemplateObject;

   public void setDataSource(DataSource dataSource) {
      this.dataSource = dataSource;
      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
   }

   public List<Student> listStudents() {
      String SQL = "select * from student";
      List<Student> students = jdbcTemplateObject.query(SQL, new StudentMapper());
      return students;
   }
   
   public void update(Integer id, String name, Integer age){
      String SQL = "update Student set name = ?, age = ? where id = ?";
      jdbcTemplateObject.update(SQL, name, age, id);
      System.out.println("Updated Record with ID = " + id );
      return;
   }

   public void create(String name, Integer age) {
      String insertQuery = "insert into Student (name, age) values (?, ?)";
      jdbcTemplateObject.update(insertQuery, name, age);
      System.out.println("Created Record Name = " + name + " Age = " + age);
      return;
   }

   public void delete(Integer id) {
      String SQL = "delete from student where id = ?";
      jdbcTemplateObject.update(SQL, id);
      System.out.println("Deleted Record with ID = " + id);
      return;
   }
}