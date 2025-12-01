package mx.edu.utez.integradora.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.edu.utez.integradora.model.HistoryAction;
import mx.edu.utez.integradora.service.HistoryService;
import mx.edu.utez.integradora.service.LoanService;

@RestController
@RequestMapping("/api/history")
public class HistoryController {
    private final HistoryService historyService;
    private final LoanService loanService;

    public HistoryController(HistoryService historyService, LoanService loanService) {
        this.historyService = historyService;
        this.loanService = loanService;
    }

    @GetMapping
    public HistoryAction[] getHistory() {
        return (HistoryAction[]) loanService.getHistoryStack().toArray();
    }

    @PostMapping("/undo")
    public boolean undo() {
        return historyService.undo();
    }
}
