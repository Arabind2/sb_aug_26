package com.jt.expense_tracker;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
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


    @RequestMapping(value = "/expenses", method = RequestMethod.GET)
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
    @RequestMapping(value = "/exepenses/{id}", method = RequestMethod.GET)
    public Expense getExpenseById(@PathVariable int id){
        System.out.println("Id is "+id);

        var sql="Select * from %s where id=?".formatted(EXPENSES_TABLE);
        Expense expense=jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Expense> (Expense.class),id);
        return expense;
    }


    @RequestMapping(value = "/expenses", method = RequestMethod.POST)
    public Expense createExpense(@RequestBody Expense expense){
        var sql="insert into %s(title, category, price, date) values(?,?,?,?)"
                                                .formatted(EXPENSES_TABLE);

        jdbcTemplate.update(sql, expense.getTitle(),expense.getCategory(), 
                        expense.getPrice(), expense.getDate());
        return expense;

    }
}

//Path variable
//dynamic routing