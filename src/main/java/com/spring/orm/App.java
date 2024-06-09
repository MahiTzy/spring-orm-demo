package com.spring.orm;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

public class App {
	private static ApplicationContext context;

	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("config.xml");
		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
		Scanner sc = new Scanner(System.in);
		int i;
		do {
			System.out.println("******* WELCOME TO SPRING-ORM PROJECT *******");
			System.out.println("Press 1 to ddd a new student");
			System.out.println("Press 2 to display all the students");
			System.out.println("Press 3 to get ditails of a single student");
			System.out.println("Press 4 to delete students");
			System.out.println("Press 5 to update a new student");
			System.out.println("Press 6 to exit!");
			
			i = sc.nextInt();
			switch (i) {
			case 1:
				System.out.println("Input Student Id :");
				int id = sc.nextInt();
				System.out.println("Input Student Name :");
				String name = sc.next();
				System.out.println("Input Student City :");
				String city = sc.next();
				Student student = new Student(id, name, city);
				studentDao.insert(student);
				System.out.println("Student Inserted Succesfully!");
				break;
			case 2:
				List<Student> res = studentDao.getAllStudent();
				for (Student s : res)
					System.out.println(s);
				break;
			case 3:
				System.out.println("Enter Student Id :");
				int id2 = sc.nextInt();
				Student student1 = studentDao.getStudent(id2);
				System.out.println(student1);
				break;
			case 4:
				System.out.println("Enter Student Id :");
				int id3 = sc.nextInt();
				studentDao.delStudent(id3);
				System.out.println("Student Succesfully Deleted!");
				break;
			case 5:
				System.out.println("Enter Student Id :");
				int id4 = sc.nextInt();
				System.out.println("Enter new name :");
				String name1 = sc.next();
				System.out.println("Enter new city :");
				String city1 = sc.next();
				Student student2 = new Student();
				student2.setSid(id4);
				student2.setName(name1);
				student2.setCity(city1);
				studentDao.updateStudent(student2);
				System.out.println("Student Updated Succesfully!");
				break;
			case 6:
				break;
			default:
				System.out.println("Invalid Input!");
				break;
			}
		} while (i != 6);
		System.out.println("Thank you for using our application!");
		sc.close();
	}
}
