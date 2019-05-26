import java.util.function.BinaryOperator;
import java.util.function.Predicate;

public class ReduceTest {
	
    static<E> E reduce(BinaryOperator<E> op, List<E> a, E identity) {
        if (a.isEmpty()) {
        	System.out.println("EMPTY");
            return identity;
        }
        else {
        	System.out.println(a.getTail());
        	System.out.println("("+a.getHead()+","+reduce(op, a.getTail(), identity)+")");
        	System.out.print(op.apply(a.getHead(), reduce(op, a.getTail(), identity))+" ");
            return op.apply(a.getHead(), reduce(op, a.getTail(), identity));
        }
    }

	public static void main(String[] args) {
		List<Integer> L2 = new List(5,new List(4,new List(3,new List())));
		BinaryOperator<Integer> L3 = (i,j) -> i*j;
		System.out.println(reduce(L3,L2,1));

	}

}
