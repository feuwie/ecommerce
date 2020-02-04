package com.example.demo.testing;

import java.util.List;
import javax.sql.DataSource;

public interface StudentDAO {
   public void setDataSource(DataSource ds);
   public List<Student> listStudents();
   public void update(Integer id, String name, Integer age);
   public void create(String name, Integer age);
   public void delete(Integer id); 
}