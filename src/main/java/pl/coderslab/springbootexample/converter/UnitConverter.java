package pl.coderslab.springbootexample.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.coderslab.springbootexample.dao.UnitDao;
import pl.coderslab.springbootexample.model.Unit;

@Component
public class UnitConverter implements Converter<String, Unit>{
    @Autowired private UnitDao dao;


    @Override
    public Unit convert(String source) {
        return dao.findById(Long.parseLong(source));
    }
}
