package se.ecutb;


import se.ecutb.data.DataStorage;
import se.ecutb.model.Person;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class App
{

    private static DataStorage dataStorage;

    static {
        dataStorage = DataStorage.INSTANCE;
    }


    public static void main( String[] args )
    {
        //2001-01-01
        /*
        dataStorage.findManyAndMapEachToString(
                p -> ! p.getBirthDate().isBefore(LocalDate.parse("2001-01-01")),
                p -> p.getBirthDate().toString() )
        .forEach(System.out::println);
        */
    /*
        List<Person> people = dataStorage.findMany(p -> true);

        people.stream()
                .sorted(Comparator.comparing(Person::getLastName)
                        .thenComparing(Person::getFirstName)
                        .thenComparing(Person::getBirthDate))
                .forEach(System.out::println);
    */

    /*
    5.	Find the Person that has an id of 456 and convert to String with following content:
“Name: Nisse Nilsson born 1999-09-09”. Use findOneAndMapToString().


     */
    String result = dataStorage.findOneAndMapToString(
            p -> p.getId() == 456,
            p -> "Name: " + p.getFirstName() + " " + p.getLastName() + " born " + p.getBirthDate());

    System.out.printf(result);
    }
}











