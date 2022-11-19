package pl.coderslab.springbootexample.converter;
import org.springframework.core.convert.converter.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.springbootexample.dao.GoalDao;
import pl.coderslab.springbootexample.model.Goal;

@Component
public class GoalConverter implements Converter<String, Goal>{
    @Autowired private GoalDao dao;


    @Override
    public Goal convert(String source) {
        return dao.findById(Long.parseLong(source));
    }
}
