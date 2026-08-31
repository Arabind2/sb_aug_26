package com.jt.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

import com.Teacher;

// @ImportResource("beans.xml")
@SpringBootApplication
// @ComponentScan(basePackages = {"com"})
public class HelloApplication {

	public static void main(String[] args) {
	ApplicationContext context=SpringApplication.run(HelloApplication.class, args);  
	//1. using XML file
	// Greet greet=context.getBean(Greet.class);
	// greet.sayHello();
	// 	System.out.println("Hello SpringBoot");

		//2. using Stereotype annotation 
		// Person person=context.getBean(Person.class);
		// person.sayHello();

	//3. using Configuration file
	Student student=context.getBean(Student.class);
	student.sayHello();

	//using ComponentScan
	// Teacher teacher=context.getBean(Teacher.class);
	// teacher.sayHello();

	// System.out.println(teacher.hashCode());
	// Teacher teacher1=context.getBean(Teacher.class);
	// System.out.println(teacher1.hashCode());

	// System.out.println("student "+student.hashCode());
	// Student student1=context.getBean(Student.class);
	// System.out.println("student1 "+student1.hashCode());
	}

}
