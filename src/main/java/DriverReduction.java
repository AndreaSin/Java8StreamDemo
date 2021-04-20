import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class DriverReduction {

	public static void main(String[] args) {
		
		// ___REDUCTION___
		// reduction porta ad un solo elemento il contenuto, attraverso una funzione

		Stream<Integer> stream = Stream.of(1,2,3);
		BinaryOperator<Integer> sum = (i1, i2) -> i1 + i2;
		Integer id = 99; // se il risultato fosse 0 usa l'identity
		int red = stream.reduce(id, sum);
		System.out.println(red);
		
		
		
	}

}
