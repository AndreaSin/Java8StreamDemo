import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class DriverFilter {

	public static void main(String[] args) {
		
		List<Person> persons = new ArrayList<Person>();
		persons.add(new Person ("Andrea", 32));persons.add(new Person ("Lucia", 30));persons.add(new Person ("Sergio", 15));
		
		// creo uno stream (interfaccia) di Person usando il metodo .stream della classe collection
		Stream<Person> stream = persons.stream();
		
		// il forEach di Stream prende come argomento un consumer, quindi un interfaccia funzionale
		// rappresentata come una lambda che prende un parametro ma non ritorna nulla
		System.out.println("___Lista non filtrata___");
		stream.forEach(p -> System.out.println(p));
		// stream.forEach(System.out::println);
		// (versioni senza stream)
		// persons.forEach(p -> System.out.println(p));
		// persons.forEach(System.out::println);
		
		
		// ___FILTER___
		
		// devo ridefinire un nuovo stream, il precedente è chiuso
		Stream<Person> stream2 = persons.stream();
		
		// filter è un metodo di stream che prende un predicato (quindi che ritorna un boolean) e filtra 
		// la collezione su cui era stato creato lo stream
		// il metodo filter torna un altro stream
		Stream<Person> filtered = stream2.filter(p -> p.getAge()>20);
		System.out.println("___Lista filtrata age > 20___");
		filtered.forEach(System.out::println);
		
		// posso concatenare i predicate
		Stream<Person> stream3 = persons.stream();
		Predicate<Person> p1 = i -> i.getAge() > 20;
		//Predicate<Person> p2 = i -> i.getAge() < 31;
		Predicate<Person> p2 = i -> i.getAge() < 31;
		
		Predicate<Person> p3 = p1.and(p2);
		
		Stream<Person> filtered2 = stream3.filter(p3);
		System.out.println("___Lista filtrata age > 20 and < 31___");
		filtered2.forEach(System.out::println);
		
		
		// la classe Predicate ha anche un metodo statico .isEqual
		Predicate<String> p4 = Predicate.isEqual("two");
		Stream<String> streamString = Stream.of("one", "two");
		
		Stream<String> filteredString = streamString.filter(p4);
		filteredString.forEach(System.out::println);
		
		//metodo alternativo senza necessita di dichiarare filteredString
		/*
		streamString
			.filter(p4)
			.forEach(System.out::println);
		*/		
		
		
	}
}