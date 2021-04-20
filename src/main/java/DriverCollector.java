import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DriverCollector {
	
	public static void main(String[] args) {
		
	
		List<Person> persons = new ArrayList<Person>();
		
		persons.add(new Person("Andrea",31));
		persons.add(new Person("Luca",31));
		persons.add(new Person("Marco",28));
		persons.add(new Person("Selter",15));
		
		Stream<Person> stream = persons.stream();

		Optional<Person> s = stream
				.filter(i -> i.getAge() > 18)
				.min(Comparator.comparing(i -> i.getAge()));
		
		System.out.println(s);
		
		
		
		// ___COLLECTOR___
		// un collector puo raggrupare 
		
		
		Map<Integer, List<Person>> map =
		persons
			.stream()
					.collect(
							Collectors.groupingBy(
									Person::getAge
									)
							);		
		System.out.println(map);
		
		// o contare
		
		Map<Integer, Long> map2 =
		persons
			.stream()
					.collect(
							Collectors.groupingBy(
									Person::getAge,
									Collectors.counting()
									)
							);		
		System.out.println(map2);
		
		// o altro!
		
		/////
		
		
		List<Person> listSorted =
		persons
			.stream()
				.sorted(Comparator.comparingInt(i -> i.getAge()))
				.collect(Collectors.toList());
		
		System.out.println(listSorted);
		
	}
	
}
