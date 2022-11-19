package pl.coderslab.springbootexample.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.springbootexample.dao.ExerciseDao;
import pl.coderslab.springbootexample.dao.WorkoutDao;
import pl.coderslab.springbootexample.model.Workout;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/exercises")
public class ExerciseController {

    private final ExerciseDao dao;
    private final WorkoutDao workoutDao;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("exercises", dao.findAll());
        return "exercises-list";
    }

    @ModelAttribute("workouts")
    public List<Workout> workouts() {
        return workoutDao.findAll();
    }

}