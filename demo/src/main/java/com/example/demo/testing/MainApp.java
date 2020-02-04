package com.example.demo.testing;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.testing.StudentJDBCTemplate;

@SpringBootApplication
@RestController
@RequestMapping("hello")
@CrossOrigin(origins = "http://localhost:4200")
public class MainApp {
   @GetMapping
   public String list() {
      return "Hello, teacher";
   }
   public static void main(String[] args) {
      SpringApplication.run(MainApp.class, args); //Нужно закоментить, чтобы норм протестить бд
      ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
      StudentJDBCTemplate studentJDBCTemplate = (StudentJDBCTemplate) context.getBean("studentJDBCTemplate");

      Scanner in = new Scanner(System.in);
      System.out.println("1. Добавить запись");
      System.out.println("2. Удалить запись");
      System.out.println("3. Обновить запись");
      System.out.println("4. Вывести пользователей");
      System.out.println("5. Выйти");
      System.out.print("Выбор пользователя: ");
      String name = "";
      int age = 0;
      int id = 0;
      int num = in.nextInt();
      switch (num) {
      case 1:
         System.out.print("Введите имя: ");
         name = in.next();
         System.out.print("Введите возраст: ");
         age = in.nextInt();
         studentJDBCTemplate.create(name, age);
         break;
      case 2:
         System.out.print("Введите id: ");
         id = in.nextInt();
         studentJDBCTemplate.delete(id);
         break;
      case 3:
         System.out.print("Введите id: ");
         id = in.nextInt();
         System.out.print("Введите имя: ");
         name = in.next();
         System.out.print("Введите возраст: ");
         age = in.nextInt();
         studentJDBCTemplate.update(id, name, age);
         break;
      case 4:
         List<Student> students = studentJDBCTemplate.listStudents();
         for (Student record : students) {
            System.out.print("ID : " + record.getId());
            System.out.print(", Name : " + record.getName());
            System.out.println(", Age : " + record.getAge());
         }
         break;
      default:
         System.out.println("Неправильное число!");
         break;
      }
      in.close();
      ((ClassPathXmlApplicationContext) context).close();
   }
}