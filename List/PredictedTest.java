import java.util.function.Predicate;

public class PredictedTest {
	

    static<E> List<E> filter(Predicate<E> pred, List<E> a) {
        if (a.isEmpty())
            return new List();
        else if (pred.test(a.getHead()))
            return new List(a.getHead(), filter(pred, a.getTail()));
        else
            return filter(pred, a.getTail());
    }

	public static void main(String[] args) {
		List<Integer> L2 = new List(20, new List(25, new List(9, new List())));
		Predicate<Integer> L3 = i -> i%2!=0;
		System.out.println(filter(L3,L2));

	}

}
