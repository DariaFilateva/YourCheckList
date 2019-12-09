package com.checklist.controler;


import com.checklist.domain.Checklist;
import com.checklist.domain.ListElement;
import com.checklist.domain.User;
import com.checklist.repository.ElementsRepository;
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

    @Autowired
    private ElementsRepository elementsRepository;

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
    public String add(@AuthenticationPrincipal User user, @RequestParam String name,
                      @RequestParam String element, @RequestParam String comment,
                      Map<String, Object> model) {
        Checklist checklist = new Checklist(name, user);
        ListElement el = new ListElement(checklist, element, comment);

        checklistRepository.save(checklist);
        elementsRepository.save(el);


        Iterable<Checklist> allChecks = checklistRepository.findAll();
        Iterable<ListElement> allElements = elementsRepository.


        model.put("checklists", allChecks);
        model.put("elements", allElements);
        return "main";
    }
}
