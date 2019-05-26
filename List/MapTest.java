import java.util.function.Function;

public class MapTest {
	


    static<E,R> List<R> map(Function<E,R> fun, List<E> a) {
        if (a.isEmpty())
            return new List();
        else
            return new List(fun.apply(a.getHead()), map(fun, a.getTail()));
    }


	public static void main(String[] args) {
		List<Integer> L2 = new List(20, new List(25, new List()));
		System.out.println(map((x)->-x,L2));

	}

}
