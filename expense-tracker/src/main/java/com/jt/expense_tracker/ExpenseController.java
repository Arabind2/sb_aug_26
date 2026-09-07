package com.jt.expense_tracker;

import java.util.ArrayList;
import java.util.List;

import javax.xml.crypto.KeySelector.Purpose;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
 
@RestController

@RequiredArgsConstructor
public class ExpenseController {
    private final JdbcTemplate jdbcTemplate;
    private static final String EXPENSES_TABLE="expenses";
    
    // public ExpenseController(JdbcTemplate jdbcTemplate) {
    //     this.jdbcTemplate = jdbcTemplate;
    // }


    // @RequestMapping(value = "/expenses", method = RequestMethod.GET)     or
    @GetMapping("/expenses1")
    public List<Expense> getExpenses(){
        String sql="Select * from %s".formatted(EXPENSES_TABLE);

        //--------------------------------------------
//         List<Expense> expenses=new ArrayList<>();
//         jdbcTemplate.query(sql, (resultSet)->{
//             System.out.println("id is : "+ resultSet.getInt("id"));
//               System.out.println("Title is : "+ resultSet.getString("title"));
//                 System.out.println("Category is : "+ resultSet.getString("category"));
 
//             var id=resultSet.getInt("id");
//               var title=resultSet.getString("title");
//                 var category=resultSet.getString("category");
//                   var price=resultSet.getDouble("price");
//                     var date=resultSet.getDate("date").toLocalDate();
//         var expense = new Expense(id, title, category, price, date);
//  expenses.add(expense);

//         });
 // return expenses;
        //------------------------------------------
 List<Expense> expense=jdbcTemplate.query(sql, new BeanPropertyRowMapper<Expense>(Expense.class));

        return expense;
    }
//------------------------------------------------------------------------------------------------------------------------------------------
    //dynamic routing
// @RequestMapping(value = "/exepenses/{id}", method = RequestMethod.GET)    or
@GetMapping("/expenses/{id}")
// {id} is a path variable placeholder.
public Expense getExpenseById(@PathVariable int id){
        // @PathVariable connects the {id} from the URL to the Java variable id
        // @PathVariable  is used because the ID is coming from the URL:

        System.out.println("Id is "+id);
        var sql="Select * from %s where id=?".formatted(EXPENSES_TABLE);
        Expense expense=jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Expense> (Expense.class),id);
       // queryForObject() is used when you expect one object/one row from the database.
        return expense;
        
    }


    // @RequestMapping(value = "/expenses", method = RequestMethod.POST)   or
    @PostMapping("/expenses")
    public Expense createExpense(@RequestBody Expense expense){
   //     @RequestBody:--"Take the JSON request body and convert it into an Expense Java object."
   
        var sql="insert into %s(title, category, price, date) values(?,?,?,?)"
                                                .formatted(EXPENSES_TABLE);
        
        jdbcTemplate.update(sql, expense.getTitle(),expense.getCategory(), 
                        expense.getPrice(), expense.getDate());
       //update() is used for SQL operations that change the database. 
      // (INSERT, UPDATE, DELETE) is used update method.               
        return expense;

    }
 
    // @RequestMapping(value="/expense/{id}", method = RequestMethod.DELETE)   or
    @DeleteMapping("/expense/{id}")
    public int delExpense(@PathVariable int id){
        var sql2="delete from %s where id=?".formatted(EXPENSES_TABLE);
       int del=jdbcTemplate.update(sql2, id);
        return del;
    }

    @PutMapping("/expenses")
    public Expense updateExpense( @RequestBody Expense expense ){
        var sql="UPDATE %s SET title=?,category=?, price=?, date=? WHERE id=?".
                                                    formatted(EXPENSES_TABLE);
        jdbcTemplate.update(sql,expense.getTitle(), expense.getCategory(), expense.getPrice(),
                                          expense.getDate(),expense.getId()   );
         return getExpenseById(expense.getId());                                    
                                   
    }

}

//-----------------------------------------
// GET---> @GetMapping
// URL → @PathVariable → SQL SELECT → Expense → JSON
//------------------------------------------
// POST-->@PostMapping
// JSON → @RequestBody → Expense → SQL INSERT → Database
//-----------------------------------------
// JdbcTemplate method                   Purpose
// -------------------         	        ----------
// query()	                        Get multiple rows
// queryForObject()	                Get one row/object
// update()	                         INSERT / UPDATE / DELETE
//---------------------------------------------


