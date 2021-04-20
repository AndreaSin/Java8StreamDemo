import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class DriverReduction {

	public static void main(String[] args) {
		
		// ___REDUCTION___
		// reduction porta ad un solo elemento il contenuto, attraverso una funzione

		Stream<Integer> stream = Stream.of(1,2,3);
		BinaryOperator<Integer> sum = (i1, i2) -> i1 + i2;
		Integer id = 99; // somma l identiti al risultato
		int red = stream.reduce(id, sum);
		System.out.println(red);
		
		
		
		
		List<Integer> list = Arrays.asList(10,8,5);
		Optional<Integer> res = 
		list.stream()
			.reduce(Integer::sum);
		System.out.println(res);
		
		
		
		
		
		// esistono anche reduction già implementati
		Stream<Integer> stream2= Stream.of(1,2,3);
		Optional<Integer> minAge = stream2.
					max(Comparator.naturalOrder());
		System.out.println(minAge.get());
		
	}

}
