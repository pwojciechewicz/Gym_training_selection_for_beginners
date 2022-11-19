package pl.coderslab.springbootexample.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.coderslab.springbootexample.dao.ExerciseDao;
import pl.coderslab.springbootexample.model.Exercise;

@Component
public class ExerciseConverter implements Converter<String, Exercise>{
    @Autowired
    private ExerciseDao dao;


    @Override
    public Exercise convert(String source) {
        return dao.findById(Long.parseLong(source));
    }
}
