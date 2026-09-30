package com.example.one_to_one;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@RequiredArgsConstructor
public class OneToOneApplication {

	private final StudentRepository studentRepository;
	private final AddressRepository addressRepository;

	public static void main(String[] args) {
		SpringApplication.run(OneToOneApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(){
return args -> {

//	Student student = Student.builder()
//			.studentName("Hada")
//			.studentEmail("h@gmail.com")
//			.build();
//	Address address=Address.builder()
//			.city("CT")
//			.state("OD")
//			.country("In")
//			.student(student)
//			.build();
//	student.setAddress(address);
//addressRepository.save(address);

//Update----
//	Address address=addressRepository.findById(2).orElseThrow();
//	address.setCity("Bhubaneswar");
//	address.setState("ODISHA");
//	Student student=address.getStudent();
//	student.setStudentName("Satya");
//	student.setAddress(address);
//	addressRepository.save(address);


	//Retrieve------
//	Address address=addressRepository.findById(1).orElseThrow();
//	System.out.println("City of student1:- "+address.getCity());
//	System.out.println("Country of student1:- "+address.getCountry());
//	System.out.println("State of student1:- "+address.getState());
//
//	Student student=address.getStudent();
//	System.out.println("Name of Student1:- "+student.getStudentName());
//	System.out.println("Email of Student1:- "+student.getStudentEmail());

	//Remove--------
	addressRepository.deleteById(2);

};
	}

	private void owningSideOperation(){
		//	Address address = Address.builder().city("BBSR").state("Odisha").country("India").build();
//	Student student = Student.builder().studentName("Binay").studentEmail("b@gmail.com").address(address).build();
//	studentRepository.save(student); // because owning side was tried to be saved but inverse side was not saved

//	for this error we have two ideas to solution
//	1.manually save address and then add it and save
//	addressRepository.save(address);
//	studentRepository.save(student);
//	2. use cascading
		// studentRepository.save(student);

//	update

//	Student existingStudent = studentRepository.findById(1).orElseThrow();
//	existingStudent.setStudentName("padia");
//	Address existingAddress = existingStudent.getAddress();
//	existingAddress.setCity("ctc"); // it wont update in adddresss table  qso we can manual update or use cascade.mrge
//	studentRepository.save(existingStudent);

//	remove v
//	studentRepository.deleteById(1); // it also same owning side delete but inverse not delete

		//retrieve
//		Student withRoll=studentRepository.findById(2).orElseThrow();
//		System.out.println("Student name:-  "+withRoll.getStudentName());
//		System.out.println("Student Email:-  "+withRoll.getStudentEmail());
//
//		Address studentwithRollAddress=withRoll.getAddress();
//		System.out.println("Address city:- "+studentwithRollAddress.getCity());
//		System.out.println("Address state:- "+studentwithRollAddress.getState());
//		System.out.println("Address country:- "+studentwithRollAddress.getCountry());
	}
}


//owning side and inverse side

//For fetching---
//-----------------
//OneToOne-> EAGER
//ManyToOne-> EAGER
//OneToMany-> LAZY
//ManyToMany-> LAZY
