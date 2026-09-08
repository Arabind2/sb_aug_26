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
    @GetMapping("/expenses1")
    public List<Expense> getExpenses(){
        String sql="Select * from %s".formatted(EXPENSES_TABLE);    
 List<Expense> expense=jdbcTemplate.query(sql, new BeanPropertyRowMapper<Expense>(Expense.class));

        return expense;
    }

@GetMapping("/expenses/{id}")

public Expense getExpenseById(@PathVariable int id){
        System.out.println("Id is "+id);
        var sql="Select * from %s where id=?".formatted(EXPENSES_TABLE);
        Expense expense=jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Expense> (Expense.class),id);
     
        return expense;
        
    }
 @PostMapping("/expenses")
    public Expense createExpense(@RequestBody Expense expense){
   var sql="insert into %s(title, category, price, date) values(?,?,?,?)"
                                                .formatted(EXPENSES_TABLE);
        
        jdbcTemplate.update(sql, expense.getTitle(),expense.getCategory(), 
                        expense.getPrice(), expense.getDate());
             return expense;

    }
 
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



