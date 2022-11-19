package pl.coderslab.springbootexample.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.coderslab.springbootexample.dao.PlanDao;
import pl.coderslab.springbootexample.model.Plan;

@Component
public class PlanConverter implements Converter<String, Plan>{
    @Autowired
    private PlanDao dao;


    @Override
    public Plan convert(String source) {
        return dao.findById(Long.parseLong(source));
    }
}
