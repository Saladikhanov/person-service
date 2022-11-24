package telran.java2022.person.service;

import telran.java2022.person.dto.AddressDto;
import telran.java2022.person.dto.CityPopulationDto;
import telran.java2022.person.dto.PersonDto;

public interface PersonService {
    Boolean addPerson(PersonDto personDto);

    PersonDto findPersonById(Integer id);

    PersonDto removePerson(Integer id);

    PersonDto updatePersonName(Integer id, String name);

    PersonDto updatePersonAddres(Integer id, AddressDto addresDto);

    Iterable<PersonDto> findByCity(String city);

    Iterable<PersonDto> findByName(String name);

    Iterable<PersonDto> findPersonsBetweenAge(Integer minAge, Integer maxAge);

    Iterable<CityPopulationDto> getCitiesPopulation();
}
