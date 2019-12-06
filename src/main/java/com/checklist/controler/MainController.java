package com.checklist.controler;


import com.checklist.domain.Checklist;
import com.checklist.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.checklist.repository.ChecklistRepos;

import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private ChecklistRepos checklistRepository;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        Iterable<Checklist> allChecks = checklistRepository.findAll();
        model.put("checklists", allChecks);
        return "main";
    }

    @PostMapping("/main")
    public String add(@AuthenticationPrincipal User user, @RequestParam String name, Map<String, Object> model) {
        Checklist checklist = new Checklist(name, user);

        checklistRepository.save(checklist);

        Iterable<Checklist> allChecks = checklistRepository.findAll();
        model.put("checklists", allChecks);
        return "main";
    }
}
