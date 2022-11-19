package pl.coderslab.springbootexample.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.coderslab.springbootexample.dao.WorkoutExerciseDao;
import pl.coderslab.springbootexample.model.WorkoutExercise;

@Component
public class WorkoutExerciseConverter implements Converter<String, WorkoutExercise>{
    @Autowired
    private WorkoutExerciseDao dao;


    @Override
    public WorkoutExercise convert(String source) {
        return dao.findById(Long.parseLong(source));
    }
}
