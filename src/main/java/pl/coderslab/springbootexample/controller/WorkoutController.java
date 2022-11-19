package pl.coderslab.springbootexample.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.springbootexample.dao.GoalDao;
import pl.coderslab.springbootexample.dao.PlanDao;
import pl.coderslab.springbootexample.dao.UnitDao;
import pl.coderslab.springbootexample.dao.WorkoutDao;
import pl.coderslab.springbootexample.model.Goal;
import pl.coderslab.springbootexample.model.Plan;
import pl.coderslab.springbootexample.model.Unit;
import pl.coderslab.springbootexample.model.Workout;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/workouts")
public class WorkoutController {

    private final WorkoutDao dao;
    private final GoalDao goalDao;
    private final PlanDao planDao;
    private final UnitDao unitDao;


    @RequestMapping(value = "", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("workouts", dao.findAll());
        return "/workouts-list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String form(Model model) {
        model.addAttribute("workout", new Workout());
        return "/workout-add";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String submit(@Valid @ModelAttribute Workout workout, BindingResult result) {
        if (result.hasErrors()) {
            return "/workout-add";
        }
        dao.create(workout);
        return "redirect:/workouts";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String formUpdate(@PathVariable Long id, Model model) {
        model.addAttribute("workout", dao.findById(id));
        return "/workout-add";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String submitUpdate(@PathVariable Long id, @Valid @ModelAttribute Workout workout, BindingResult result) {
        if (result.hasErrors()) {
            return "/workout-add";
        }
        if (id.equals(workout.getId())) {
            dao.update(workout);
        }
        return "redirect:/workouts";
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
    public String formRemove(@PathVariable Long id, Model model) {
        model.addAttribute("workout", dao.findById(id));
        return "/workout-remove";
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.POST)
    public String submitRemove(@PathVariable Long id, @ModelAttribute Workout workout) {
            dao.remove(dao.findById(id));
        return "redirect:/workouts";
    }

    @RequestMapping("/plans/{planId}")
    public String listNew(@PathVariable Long planId, Model model) {
        List<Workout> items = dao.findByPlan(planDao.findById(planId));
        model.addAttribute("workouts", items);
        return "/plan-details";
    }

    @ModelAttribute("workouts")
    public List<Workout> workouts() {
        return dao.findAll();
    }

    @ModelAttribute("goals")
    public List<Goal> goals() {
        return goalDao.findAll();
    }

    @ModelAttribute("plans")
    public List<Plan> plans() {
        return planDao.findAll();
    }

    @ModelAttribute("units")
    public List<Unit> units() {
        return unitDao.findAll();
    }
}