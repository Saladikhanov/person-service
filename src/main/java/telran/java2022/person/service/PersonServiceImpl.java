package telran.java2022.person.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import telran.java2022.person.dao.PersonRepository;
import telran.java2022.person.dto.AddressDto;
import telran.java2022.person.dto.CityPopulationDto;
import telran.java2022.person.dto.PersonDto;
import telran.java2022.person.dto.PersonNotFoundException;
import telran.java2022.person.model.Person;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    final PersonRepository personRepository;
    final ModelMapper modelMapper;

    @Override
    public Boolean addPerson(PersonDto personDto) {
	    if (personRepository.findById(personDto.getId()).isPresent()) {
		return false;
	    }
	personRepository.save(modelMapper.map(personDto, Person.class));
	return true;
    }

    @Override
    public PersonDto findPersonById(Integer id) {
	Person person = personRepository.findById(id).orElseThrow(PersonNotFoundException::new);
	return modelMapper.map(person, PersonDto.class);
    }

    @Override
    public PersonDto removePerson(Integer id) {
	Person person = personRepository.findById(id).orElseThrow(PersonNotFoundException::new);
	PersonDto res = modelMapper.map(person, PersonDto.class);
	personRepository.deleteById(id);
	return res;
    }

    @Override
    public PersonDto updatePersonName(Integer id, String name) {
	Person person = personRepository.findById(id).orElseThrow(PersonNotFoundException::new);
	person.setName(name);
	personRepository.save(person);
	PersonDto res = modelMapper.map(person, PersonDto.class);
	return res;
    }

    @Override
    public PersonDto updatePersonAddres(Integer id, AddressDto addresDto) {
	Person person = personRepository.findById(id).orElseThrow(PersonNotFoundException::new);
	if (addresDto.getBuilding() != null) {
	    person.getAddress().setBuilding(addresDto.getBuilding());
	}
	if (addresDto.getCity() != null) {
	    person.getAddress().setCity(addresDto.getCity());
	}
	if (addresDto.getStreet() != null) {
	    person.getAddress().setStreet(addresDto.getStreet());
	}
	PersonDto res = modelMapper.map(personRepository.save(person), PersonDto.class);
	return res;
    }

    @Override
    public Iterable<PersonDto> findByCity(String city) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Iterable<PersonDto> findByName(String name) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Iterable<PersonDto> findPersonsBetweenAge(Integer minAge, Integer maxAge) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Iterable<CityPopulationDto> getCitiesPopulation() {
	// TODO Auto-generated method stub
	return null;
    }

}
