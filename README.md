Serie di esercizi di demo con commenti a proposito degli Stream in java8
consiglio di partire con il filter (DriverFilter), da li approfondire il concetto di operazioni lazy (DriverLazyStream) e infine tutto il resto

1. Consumatore
Come suggerisce il nome, questa interfaccia funzionale consuma solo i dati e non produce nulla, ma può eseguire qualsiasi operazione sui dati consumati. La struttura è la seguente:

@FunctionalInterface
public interface Consumer<T> {

    /**
     * Performs this operation on the given argument.
     *
     * @param t the input argument
     */
    void accept(T t);
}
L'esempio seguente utilizza un numero intero e stampa il doppio di quel numero utilizzando stdout

Consumer<Integer> consumer = new Consumer<Integer>() {
   @Override
   public void accept(Integer integer) {
      System.out.println(integer * 2);
   }
};

consumer.accept(6);

------------------------------------------------

2. Fornitore
Come suggerisce il nome, questa interfaccia funzionale produce / fornisce solo alcuni dati e non consuma nulla. La struttura è la seguente:

@FunctionalInterface
public interface Supplier<T> {

    /**
     * Gets a result.
     *
     * @return a result
     */
    T get();
}
L'esempio seguente restituisce un numero intero casuale

Supplier<Integer> supplier = new Supplier<Integer>() {
   @Override
   public Integer get() {
      return new Random().nextInt();
   }
};

System.out.println(supplier.get());

------------------------------------------------

3. Funzione
La funzione è un'interfaccia funzionale che accetta alcuni dati di input e restituisce alcuni dati di output eseguendo alcune operazioni sui dati di input. È una combinazione di consumatore e fornitore. La struttura è la seguente:

@FunctionalInterface
public interface Function<T, R> {
    R apply(T var1);
}
Gli esempi seguenti accettano un numero e restituiscono la stringa che è una combinazione di quel numero e "test" aggiunto dopo quel numero

Function<Integer, String > function = new Function<Integer, String>() {
   @Override
   public String apply(Integer integer) {
      return "" + integer + "test";
   }
};

System.out.println(function.apply(10));

------------------------------------------------

4. Predicato
Come suggerisce il nome, questa interfaccia funzionale accetta i dati di input e restituisce il risultato booleano (vero o falso). La struttura è la seguente:

@FunctionalInterface
public interface Predicate<T> {
    boolean test(T var1);
}
L'esempio seguente prende una stringa nell'argomento e restituisce se contiene o meno il carattere "a".

Predicate<String> predicate = new Predicate<String>() {
   @Override
   public boolean test(String s) {
      return s.contains("a");
   }
};

System.out.println(predicate.test("australia"));
Esaminiamo anche una delle funzioni predefinite dell'interfaccia Predicate

default Predicate<T> and(Predicate<? super T> var1) {
    Objects.requireNonNull(var1);
    return (var2) -> {
        return this.test(var2) && var1.test(var2);
    };
}
Gli esempi seguenti restituiscono true se una stringa contiene sia a che b (anche se avremmo potuto farlo semplicemente usando 1 predicato ma solo per mostrare il funzionamento di e la funzione stiamo usando 2 predicati qui)

Predicate<String> predicate = new Predicate<String>() {
   @Override
   public boolean test(String s) {
      return s.contains("a");
   }
};

Predicate<String> predicate2 = new Predicate<String>() {
   @Override
   public boolean test(String s) {
      return s.contains("b");
   }
};

System.out.println(predicate.and(predicate2).test("australia"));

------------------------------------------------

5. Runnable
Come suggerisce il nome, questa interfaccia funzionale non consuma né produce nulla, ecco perché non esiste un tipo T così generico nella definizione di questa interfaccia, esegue solo una parte di codice definita nella funzione di esecuzione di questa interfaccia. La struttura è la seguente:

@FunctionalInterface
public interface Runnable {
    void run();
}
Runnable runnable = new Runnable() {
   @Override
   public void run() {
      int sum = 0;
      for(int i=1;i<10;i++){
         sum += i;
      }

      System.out.println(sum);
   }
};

runnable.run();
Runnable viene utilizzato anche durante la creazione di thread

------------------------------------------------

6. BiConusmer
Questa interfaccia funzionale accetta due tipi di oggetti nella sua definizione di tipo T e U, ora possono essere uguali o non essere e si comporta in modo simile all'interfaccia consumer, consuma i dati non produce / restituisce nulla. La struttura è la seguente:

@FunctionalInterface
public interface BiConsumer<T, U> {
    void accept(T var1, U var2);
}
L'esempio seguente rileva solo se un determinato luogo è presente nell'elenco dei luoghi o meno.

BiConsumer<String, List<String>> biConsumer = new BiConsumer<String, List<String>>() {
   @Override
   public void accept(String s, List<String> strings) {
      if(strings.contains(s)){
         System.out.println(s + " is present in the list");
      }else{
         System.out.println(s + " is not present in the list");
      }
   }
};

biConsumer.accept("delhi", Arrays.asList("china","delhi", "austria", "india"));
L'unica differenza tra Consumer e BiConsumer è che BiConsumer accetta due oggetti nell'argomento ma Consumer ne prende solo uno