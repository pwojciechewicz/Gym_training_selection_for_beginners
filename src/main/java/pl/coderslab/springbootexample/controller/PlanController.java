package pl.coderslab.springbootexample.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.springbootexample.dao.PlanDao;
import pl.coderslab.springbootexample.model.Plan;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/plans")
public class PlanController {
    private final PlanDao dao;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("plans", dao.findAll());
        return "/plan-list1";
    }

    @ModelAttribute("plans")
    public List<Plan> plans() {
        return dao.findAll();
    }

}
