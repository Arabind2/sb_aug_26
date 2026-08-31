package com.jt.intro_to_web;

import java.io.PrintWriter;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller  //It marks the class as a controller class. Which means that class responsible to handle http request.

// @Component
public class HelloController {
    @RequestMapping("/home")  //This annotation handle a custom path inside a controller class .
  //  PrintWriter:-It allows us to directly write the HTTP response.
    public void sayHello(PrintWriter writer){
        System.out.println("Hello Web");
        writer.println("<h1>Hello Spring Web</h1> <p>Welcome Home</p>");

        
    }
    @RequestMapping("/")
        public void landingPage(PrintWriter printWriter){
            System.out.println("landing Page1");
            printWriter.println("Our first landing page1");
        }
        @RequestMapping("/contact")
          public String contact(){
          return "contact-page";
        }

    //     @RequestMapping("/submit-details")  //Whenever a request comes to (/submit-details), execute this method.
    //    // HttpServletRequest:-  represents the HTTP request sent by the browser.
    //    //Model:-  is used to send data from the Controller to the View.
    //     public String submitDetails(HttpServletRequest request, Model model){
    //      System.out.println("Submit details handled");

    //         String name=request.getParameter("name");  
    //         //getParameter() gets the value of an HTML form field.The parameter name must match the HTML name attribute.
            
    //         String phone=request.getParameter("phone");
    //         //getParameter() gets the value of an HTML form field.The parameter name must match the HTML name attribute.
            
    //         System.out.println("name is:- "+name);
    //         System.out.println("phone is:- "+phone);

    //         model.addAttribute("name", name);
    //         model.addAttribute("phone", phone);
    //         return "details-page";  //Returns the view name.
    //     }
  //--------------------------------------------------------------      
        // @RequestMapping(value = "/submit-details", method = RequestMethod.POST)
        // public String submitDetails(@RequestParam(value = "name1", required = false, defaultValue = "SpringBoot") String name,@RequestParam  String phone, Model model)
        // {
        //     model.addAttribute("name1", name);
        //     model.addAttribute("phone", phone);

        //     return "details-page";
        // }

//-------------------------------------------------------------------
           @RequestMapping(value = "/submit-details", method = RequestMethod.POST)
        public String submitDetails(@ModelAttribute Person person, Model model)
        {
            model.addAttribute("name1", person.getname());
            model.addAttribute("phone", person.getPhone());

            return "details-page";
        }

}

//=============================================
//note---->
// @Controller
// → Marks a class as a Spring MVC Controller.

// @RequestMapping
// → Maps a URL/request to a controller method.

// PrintWriter
// → Directly writes response to the browser.

// HttpServletRequest
// → Represents the HTTP request.
// → request.getParameter() gets form data.

// @RequestParam
// → Directly receives individual request parameters.

// @ModelAttribute
// → Binds request/form data to a Java object.

// Model
// → Sends data from Controller to View.

// model.addAttribute()
// → Adds data to the Model.

// RequestMethod.POST
// → Handles POST requests.

// return "details-page"
// → Returns the view name.

// Person
// → POJO/Java object used to hold form data.

//===================================================