package mx.edu.utez.integradora.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.edu.utez.integradora.model.Loan;
import mx.edu.utez.integradora.service.LoanService;

@RestController
@RequestMapping("/api/loans")
public class LoanController {
    private final LoanService service;

    public LoanController(LoanService service) { this.service = service; }

    @PostMapping
    public Loan create(@RequestParam int userId, @RequestParam int bookId) {
        //Loan loan = service.createLoan(userId, bookId); ResponseEntity
        return service.createLoan(userId, bookId);
    }

    @PostMapping("/{id}/return")
    public boolean returnLoan(@PathVariable int id) {
        return service.returnLoan(id);
    }

    @GetMapping("/active")
    public Loan[] getActive() {
        return service.getActiveLoans();
    }

    @GetMapping("/user/{userId}")
    public Loan[] getByUser(@PathVariable int userId) {
        return service.getLoansByUser(userId);
    }
}
