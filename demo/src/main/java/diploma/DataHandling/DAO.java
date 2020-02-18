package diploma.DataHandling;

import java.util.List;

import javax.sql.DataSource;

import diploma.Model.Student;

public interface DAO<T> {
   public void setDataSource(DataSource ds);
   public List<T> getAll();
   public List<T> getOne(Integer id);
   public Student update(Integer id, String name, Integer age);
   public Student create(String name, Integer age);
   public Student delete(Integer id);
}