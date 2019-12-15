package com.checklist.controler;


import com.checklist.domain.Checklist;
import com.checklist.domain.ListElement;
import com.checklist.domain.User;
import com.checklist.repository.ElementsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.checklist.repository.ChecklistRepos;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Controller
public class MainController {

    @Autowired
    private ChecklistRepos checklistRepository;

    @Autowired
    private ElementsRepository elementsRepository;

    @Value("${upload.path}")
    private String uploadPath;

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
                      @RequestParam String e, @RequestParam String comment,
                      Map<String, Object> model, @RequestParam("file") MultipartFile file) throws IOException {
        Checklist checklist = new Checklist(name, user);

        if (file != null) {

            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFileName = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + resultFileName));
            checklist.setFilename(resultFileName);
        }

        ListElement el = new ListElement(e, comment);
        checklist.addElement(el);

        checklistRepository.save(checklist);
        elementsRepository.save(el);


        Iterable<Checklist> allChecks = checklistRepository.findAll();

        model.put("user", user);
        model.put("checklists", allChecks);
        return "main";
    }
}
