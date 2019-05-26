
public class MainTest {
	
	public static void main(String[] args) {
		//double S = System.currentTimeMillis();
		//int pow = Worksheet1.power(2,-1);
		//System.out.println(pow);
		//double E = System.currentTimeMillis();
		//System.out.println(E-S);
		
		//double S2 = System.currentTimeMillis();
		//int a = Worksheet1.fastPower(2,-1);
		//System.out.println(a);
		//double E2= System.currentTimeMillis();
		//System.out.println(E2-S2);
		
		//List<Integer> L = new List(1, new List(-15, new List(10, new List(25, new List(25, new List(25, new List(28, new List())))))));
		//List<Integer> L2 = new List(20, new List(25, new List()));
		//List<Integer> L = new List(2, new List());
		//System.out.println(L.getHead());
		//System.out.println(L.getTail());
		//System.out.println(L.getTail().getHead());
		//System.out.println(L);
		//System.out.println(Worksheet1.negateAll(L));
		//System.out.println(Worksheet1.find(-7,L));
		//System.out.println(Worksheet1.allPositive(L));
		//System.out.println(Worksheet1.positives(L));
		//System.out.println(Worksheet1.sorted(L));
		//System.out.println(L2);
		//System.out.println(Worksheet1.merge(L,L2));
		//System.out.println(Worksheet1.removeDuplicates(L));
//		List<Integer> L = new List(-3, new List(-2, new List(-1, new List())));
//		List<Integer> L2 = new List(-5, new List(-4, new List(-3, new List())));
//		System.out.println(Worksheet1.common(L,L2));
		List<Integer> LL = new List();
		List<Integer> L = new List(1, new List(2, new List(3, new List(3, new List()))));
		List<Integer> L2 = new List(-1, new List(0, new List(1, new List())));
		System.out.println(Worksheet1.delete(-1,L2));
	}

}
