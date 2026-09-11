package com.jt.expense_tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.xml.crypto.KeySelector.Purpose;

import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
 
@RestController
@RequiredArgsConstructor
@CrossOrigin ("http://localhost:5173")
public class ExpenseController {
   
     private final ExpenseService expenseService;

    private static final String EXPENSES_TABLE="expenses";
    @GetMapping("/expenses")
 public List<Expense> getExpenses() {
    return expenseService.getExpenses();
  }

@GetMapping("/expenses/{id}")
  public Expense getExpenseById(@PathVariable int id) {
    return expenseService.getExpenseById(id);
  }

    
 @PostMapping("/expenses")
 @ResponseStatus(code=HttpStatus.CREATED) //-201
 public Expense createExpense(@RequestBody Expense expense) {
    return expenseService.addExpense(expense);
  }

    @DeleteMapping("/expense/{id}")
       @ResponseStatus(value=HttpStatus.NO_CONTENT) //-204
  public void deleteExpense(@PathVariable int id) {
    expenseService.deleteExpenseById(id);
  }
    @PutMapping("/expenses")
     @ResponseStatus(HttpStatus.ACCEPTED) //--202

   public Expense updateExpense(@RequestBody Expense expense) {
    return expenseService.updatExpense(expense);
  }

}



//controller->serivce->repository(entity), ->database