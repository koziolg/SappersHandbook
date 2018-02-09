package pl.handbook.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.handbook.entity.TypeOfMine;
import pl.handbook.repository.TypeOfMineRepository;
@Component
public class TypeOfMineConverter implements Converter<String, TypeOfMine> {

    @Autowired
    TypeOfMineRepository typeOfMineRepository;

    public TypeOfMineConverter() {
    }


    @Override
    public TypeOfMine convert(String s) {
        TypeOfMine typeOfMine = typeOfMineRepository.findOne(Long.valueOf(s));
        return typeOfMine;

    }
}
