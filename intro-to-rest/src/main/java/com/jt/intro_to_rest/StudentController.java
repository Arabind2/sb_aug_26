package com.jt.intro_to_rest;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tools.jackson.core.JacksonException;
import tools.jackson.databind.ObjectMapper;

//@Controller
//@ResponseBody  //It tells Springboot to return a JSON Object instead of a view file.
 @RestController
public class StudentController {
    private ObjectMapper mapper;

public StudentController(ObjectMapper mapper){
    this.mapper=mapper;
}

    // @RequestMapping(value ="/student" ,method = RequestMethod.GET)
    // public Student getStudent()
    // {

    //     Student student= new Student(101,"Ankit",new String[]{"java", "Python"});
    //     System.out.println("////"+student);
    //     return student;
    // }

    @RequestMapping("/student1")
    public void convertjavaObjToJSON(){
         Student student= new Student(101,"Ankit",new String[]{"java", "Python"});
      String json=mapper.writeValueAsString(student);
      System.out.println("json value is"+ json);
      
    }

     @RequestMapping("/student2")
    public void convertJSONObjToJavaObj()throws JacksonException{
        String json="""
        {
        "id":102,
        "name":"Anirudh",
        "courses":["C", "C++"]

        }
                """;
      
                Student student=mapper.readValue(json, Student.class);
        System.out.println("After converting from json to java Object "+ student);
    }

    @RequestMapping("/fruits")
    
    public List<String> getStrings(){
        return List.of("Apple", "Mango", "Grapes");
    }
}

/*
@ResponseBody:- //It tells Springboot to return a JSON Object instead of a view file

jackson object uses ObjectMapper to convert java object to json Object.

--------------------------------------------------------------------
java object to json------> public String writeValueAsString(Object value) throws JsonProcessingException
json to java object-------> readValue(json_object, ClassName.class); throws  JacksonException
*/