package com.kidaro.kael.service;
import com.kidaro.kael.model.Customer;
import com.kidaro.kael.model.Loan;
import com.kidaro.kael.model.Saving;
import com.kidaro.kael.repository.LoanRepository;
import com.kidaro.kael.repository.SavingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanService {

    private final LoanRepository loanRepo;
    private final SavingRepository savingRepo;

    public Loan createLoan(Customer customer, Loan loan) {
        loan.setCustomer(customer);
        loan.setStatus(Loan.LoanStatus.PENDING);
        return loanRepo.save(loan);
    }

    public List<Loan> getLoansByCustomer(Customer customer) {
        return loanRepo.findByCustomer(customer);
    }

    public List<Loan> getAllLoans() {
        return loanRepo.findAll();
    }

    public Loan updateLoanStatus(String loanId, Loan.LoanStatus status) {
        Loan loan = loanRepo.findById(loanId)
                .orElseThrow(() -> new RuntimeException("Loan not found"));
        loan.setStatus(status);
        return loanRepo.save(loan);
    }

    public Saving createSaving(Customer customer, double amount) {
        Saving saving = new Saving();
        saving.setCustomer(customer);
        saving.setAmount(amount);
        saving.setDate(LocalDate.now());
        saving.setStatus(Saving.SavingStatus.PENDING);
        return savingRepo.save(saving);
    }

    public List<Saving> getSavingsByCustomer(Customer customer) {
        return savingRepo.findByCustomer(customer);
    }

    @Transactional(readOnly = true)
    public List<Saving> getAllSavings() {
        return savingRepo.findAll();
    }

    @Transactional
    public Saving updateSavingStatus(String savingId, Saving.SavingStatus status) {
        Saving saving = savingRepo.findById(savingId)
                .orElseThrow(() -> new RuntimeException("Saving not found"));
        saving.setStatus(status);
        return savingRepo.save(saving);
    }

    public double calculateWeeklyRate(double annualRate) {
        return annualRate / 52;
    }

    @Transactional
    public Loan paybackLoan(String loanId, double paymentAmount) {
        Loan loan = loanRepo.findById(loanId)
                .orElseThrow(() -> new RuntimeException("Loan not found"));

        if (loan.getAmount() <= 0) {
            throw new RuntimeException("Loan is already fully paid.");
        }

        double remainingAmount = loan.getAmount() - paymentAmount;
        loan.setAmount(Math.max(remainingAmount, 0));

        if (remainingAmount <= 0) {
            loan.setStatus(Loan.LoanStatus.APPROVED); // Mark as fully paid
        }

        return loanRepo.save(loan);
    }
}