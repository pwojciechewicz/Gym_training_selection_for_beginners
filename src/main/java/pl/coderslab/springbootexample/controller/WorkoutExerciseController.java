package pl.coderslab.springbootexample.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.springbootexample.dao.ExerciseDao;
import pl.coderslab.springbootexample.dao.WorkoutDao;
import pl.coderslab.springbootexample.dao.WorkoutExerciseDao;
import pl.coderslab.springbootexample.model.Exercise;
import pl.coderslab.springbootexample.model.Workout;
import pl.coderslab.springbootexample.model.WorkoutExercise;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/workouts_exercises")
public class WorkoutExerciseController {

    private final WorkoutExerciseDao dao;
    private final WorkoutDao workoutDao;
    private final ExerciseDao exerciseDao;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("workouts_exercises", dao.findAll());
        return "workouts_exercises-list";
    }

    @RequestMapping("/workouts/{workoutId}")
    public String listNew(@PathVariable Long workoutId, Model model) {
        List<WorkoutExercise> items = dao.findByWorkout(workoutDao.findById(workoutId));
        model.addAttribute("workouts_exercises", items);
        return "/exercises-list2";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String form(Model model) {
        model.addAttribute("workout_exercise", new WorkoutExercise());
        return "/workout_exercise-add";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String submit(@RequestParam Workout workout, @Valid @ModelAttribute WorkoutExercise workoutExercise, BindingResult result) {
        if (result.hasErrors()) {
            return "/workout_exercise-add";
        }
        dao.create(workoutExercise);
        return "redirect:/workouts_exercises/workouts/" + workout.getId();
    }


    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String formUpdate(@PathVariable Long id, Model model) {
        model.addAttribute("workout_exercise", dao.findById(id));
        return "/workout_exercise-add";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String submitUpdate(@RequestParam Workout workout, @PathVariable Long id, @Valid @ModelAttribute WorkoutExercise workoutExercise, BindingResult result) {
        if (result.hasErrors()) {
            return "/workout_exercise-add";
        }
        if (id.equals(workoutExercise.getId())) {
            dao.update(workoutExercise);
        }
        return "redirect:/workouts_exercises/workouts/" + workout.getId();
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
    public String formRemove(@PathVariable Long id, Model model) {
        model.addAttribute("workout_exercise", dao.findById(id));
        return "/workout_exercise-remove";
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.POST)
    public String submitRemove(@PathVariable Long id, @ModelAttribute WorkoutExercise workoutExercise, @RequestParam String remove) {
        if (remove.equals("Tak")) {
            dao.remove(workoutExercise);
        }
        return "redirect:/workouts_exercises";
    }

    @ModelAttribute("workouts_exercises")
    public List<WorkoutExercise> workoutsExercises() {
        return dao.findAll();
    }

    @ModelAttribute("workouts")
    public List<Workout> workouts() {
        return workoutDao.findAll();
    }

    @ModelAttribute("exercises")
    public List<Exercise> exercises() {
        return exerciseDao.findAll();
    }

}