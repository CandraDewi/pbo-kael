package com.kidaro.kael.controller;

import com.kidaro.kael.model.Saving;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.kidaro.kael.model.Customer;
import com.kidaro.kael.model.Loan;
// import com.kidaro.kael.model.Manager;
import com.kidaro.kael.service.AuthService;
import com.kidaro.kael.service.LoanService;

import java.util.List;

@RestController
@RequestMapping("/api/loans")
@RequiredArgsConstructor
public class LoanController {

    private final AuthService authService;
    private final LoanService loanService;

    // For customers
    @PostMapping("/create")
    public Loan createLoan(
            @RequestParam String username,
            @RequestParam String password,
            @RequestBody Loan loan) {
        Customer customer = authService.loginCustomer(username, password);
        return loanService.createLoan(customer, loan);
    }

    @GetMapping("/my")
    public List<Loan> getMyLoans(
            @RequestParam String username,
            @RequestParam String password) {
        Customer customer = authService.loginCustomer(username, password);
        return loanService.getLoansByCustomer(customer);
    }

    @PostMapping("/createSaving")
    public Saving createSaving(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam double amount) {
        Customer customer = authService.loginCustomer(username, password);
        return loanService.createSaving(customer, amount);
    }

    @GetMapping("/mySavings")
    public List<Saving> getMySavings(
            @RequestParam String username,
            @RequestParam String password) {
        Customer customer = authService.loginCustomer(username, password);
        return loanService.getSavingsByCustomer(customer);
    }

    @GetMapping("/weeklyRate")
    public double getWeeklyRate(@RequestParam double annualRate) {
        return loanService.calculateWeeklyRate(annualRate);
    }

    @PostMapping("/payback")
    public Loan paybackLoan(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String loanId,
            @RequestParam double paymentAmount) {
        authService.loginCustomer(username, password);
        return loanService.paybackLoan(loanId, paymentAmount);
    }

    // For managers
    @GetMapping("/all")
    public List<Loan> getAllLoans(
            @RequestParam String username,
            @RequestParam String password) {
        authService.loginManager(username, password);
        return loanService.getAllLoans();
    }

    @GetMapping("/allSavings")
    public List<Saving> getAllSavings(
            @RequestParam String username,
            @RequestParam String password) {
        authService.loginManager(username, password);
        return loanService.getAllSavings();
    }
    
    @PostMapping("/status")
    public Loan updateStatus(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String loanId,
            @RequestParam Loan.LoanStatus status) {
        authService.loginManager(username, password);
        return loanService.updateLoanStatus(loanId, status);
    }

    @PostMapping("/updateSavingStatus")
    public Saving updateSavingStatus(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String savingId,
            @RequestParam Saving.SavingStatus status) {
        authService.loginManager(username, password);
        return loanService.updateSavingStatus(savingId, status);
    }
}
