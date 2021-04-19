import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class DriverMap {

	public static void main(String[] args) {


		// ___MAP___
		// map ritorna uno stream, quindi è interemdio e va assegnato o seguito da un operazione finale
		// una mappa prende un elemento di tipo T e ritorna un elemento di tipo R
		// per esempio qui prende una persona e ritorna la sua età
		
		List<Person> persons = new ArrayList<Person>();
		persons.add(new Person ("Andrea", 32));persons.add(new Person ("Lucia", 30));persons.add(new Person ("Sergio", 15));
		Stream<Person> personsStream = persons.stream();
		
		personsStream
			.map(p -> p.getAge())
			.forEach(System.out::println);
		
		// TODO da rifare..
		// ___FLATMAP___
		// una flatMap prende un oggetto di tipo T e ritona uno stream<R>		
		// in breve, appiattisce su un livello solo

		List<Integer> list1 = Arrays.asList(1,2,3,4,5);
		List<Integer> list2 = Arrays.asList(1,2);
		List<Integer> list3 = Arrays.asList(7,8,9);
		
		List<List<Integer>> list = Arrays.asList(list1,list2,list3);
		System.out.println(list);
		
		
		Function<List<?>, Integer> size = List::size;

		list.stream()
		.map(size)
		.forEach(System.out::println);
		
		
		Function<List<Integer>, Stream<Integer>> flatMapper = l -> l.stream(); 
		
		list.stream()
		.flatMap(flatMapper)
		.forEach(System.out::println);
		
		
	}

}