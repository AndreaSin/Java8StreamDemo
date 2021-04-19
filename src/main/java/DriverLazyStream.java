import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class DriverLazyStream {

	public static void main(String[] args) {

		/* ESEMPIO QUALSIASI
		streamString
			.filter(p4)
			.forEach(System.out::println);
		*/
		
		// se un metodo ritorna uno stream è un metodo intermedio, lazy,
		// ed è solo una dichiarazione (metodi come filter, peek, ecc)
		// quindi nell'ultimo esempio, dove non sto assegnando nulla ma solo eseguendo,
		// non avrebbe senso usare metodi intermedi SENZA un metodo finale in fondo
		// allo stesso modo non potrei mai assegnare ad uno stream quell'operazione perche
		// forEach non ritorna uno stream!
		
		Stream<String> s = Stream.of("one", "two", "three");
		Stream<String> s2 = Stream.of("one", "two", "three");
		Predicate<String> p1 = Predicate.isEqual("one");
		Predicate<String> p2 = Predicate.isEqual("two");
		
		List<String> l = new ArrayList<String>();
		System.out.println(l.size());
		
		// questo blocco non viene eseguito mai, perchè peek è come un foreach ma lazy,
		// infatti ritorna uno stream (di cui non faccio nulla in questo caso)
		s
			.peek(System.out::println)
			.filter(p1.or(p2))
			.peek(i -> l.add(i));
			//.peek(l::add);
		

		System.out.println(l.size());

		// in questo caso le operazioni vengono eseguite perchè il forEach finale triggera tutte le operazioni precedenti
		s2
			.peek(System.out::println)
			.filter(p1.or(p2))
			.forEach(i -> l.add(i));
			//.forEach(l::add);
		
		System.out.println(l.size());

	}

}