package se.ecutb.data;

import se.ecutb.model.Person;
import se.ecutb.util.PersonGenerator;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;


/**
 * Skapa implementationer till alla metoder. Jag har redan skrivit en metodimplementation för hjälp
 */
public class DataStorageImpl implements DataStorage {

    private static final DataStorage INSTANCE;

    static {
        INSTANCE = new DataStorageImpl();
    }

    private List<Person> personList;

    private DataStorageImpl(){
        personList = PersonGenerator.getInstance().generate(1000);
    }

    static DataStorage getInstance(){
        return INSTANCE;
    }


    @Override
    public List<Person> findMany(Predicate<Person> filter) {
        List<Person> result = new ArrayList<>();
        for(Person person : personList){
            if(filter.test(person)){
                result.add(person);
            }
        }
        return result;
    }

    @Override
    public Person findOne(Predicate<Person> filter) {

        Optional<Person> personOptional = personList.stream()
                .filter(filter)
                .findFirst();
        if (personOptional.isPresent())
        {
            return personOptional.get();
        }
        else
        {
            return null;
        }
    }

    @Override
    public String findOneAndMapToString(Predicate<Person> filter, Function<Person, String> personToString){
        return personToString.apply(findOne(filter));
    }

    @Override
    public List<String> findManyAndMapEachToString(Predicate<Person> filter, Function<Person, String> personToString){
        return personList.stream()
                .filter(filter)
                .map(personToString)
                .collect(Collectors.toList());
    }

    @Override
    public void findAndDo(Predicate<Person> filter, Consumer<Person> consumer){

    }

    @Override
    public List<Person> findAndSort(Comparator<Person> comparator){
        LocalDate date = LocalDate.now();

        return null;
    }

    @Override
    public List<Person> findAndSort(Predicate<Person> filter, Comparator<Person> comparator){
        return null;
    }
}
