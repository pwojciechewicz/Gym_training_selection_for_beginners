package pl.coderslab.springbootexample.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.coderslab.springbootexample.dao.WorkoutDao;
import pl.coderslab.springbootexample.model.Workout;

@Component
public class WorkoutConverter implements Converter<String, Workout>{
    @Autowired
    private WorkoutDao dao;


    @Override
    public Workout convert(String source) {
        return dao.findById(Long.parseLong(source));
    }
}
