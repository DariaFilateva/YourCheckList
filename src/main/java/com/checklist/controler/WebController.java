package com.checklist.controler;


import com.checklist.domain.Checklist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.checklist.repository.ChecklistRepos;

import java.util.Map;

@Controller
public class WebController {

    @Autowired
    private ChecklistRepos checklistRepository;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Map<String,
            Object> model) {
        model.put("name", name);
        return "greeting";
    }

    @GetMapping
    public String main(Map<String, Object> model) {
        Iterable<Checklist> allChecks = checklistRepository.findAll();
        model.put("checklists", allChecks);
        return "main";
    }

    @PostMapping
    public String add(@RequestParam String creator, @RequestParam String name, Map<String, Object> model) {
        Checklist checklist = new Checklist(creator, name);

        checklistRepository.save(checklist);

        Iterable<Checklist> allChecks = checklistRepository.findAll();
        model.put("checklists", allChecks);
        return "main";
    }
}
