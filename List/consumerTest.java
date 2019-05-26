import java.util.function.Consumer;

public class consumerTest {
	
//	public static void main(String[] args) {
//	    Consumer<String> c = (x) -> System.out.println(x.toUpperCase());
//	    c.accept("Java2s.com");
//	  }
	
	public static void main(String[] args) {
	      int x = 99;
	      
	      Consumer<Integer> myConsumer = y -> 
	      {
	          System.out.println("x = " + x); // Statement A
	          System.out.println("y = " + y);
	      };

	     myConsumer.accept(x);
	    }

}
