/**
 * @author <Herng-Shyue Chen> This class contains the solution for Worksheet1
 * @version 2019-01-23
 */

 public class Worksheet1 {

	 // Exercise 1

	 static int power(int m, int n) {
		return (int)Math.pow(m, n);
	 }

	 static int fastPower(int m, int n) {
		if(n==0) {
			return 1;
		}
		if(n%2==0) {
			return fastPower(m*m,n/2);
		}
		return m*fastPower(m, n-1);
	 }

	 // Exercise 2

	 static List<Integer> negateAll(List<Integer> a) {
		if(a.isEmpty()) {
			return new List<Integer>();
		}
		return new List<Integer>(a.getHead()*-1, negateAll(a.getTail())); 
	 }

	 // Exercise 3

	 static int find(int x, List<Integer> a) {
			if (a.isEmpty()) {
				throw new IllegalStateException("element not in list");
			}
			else if (x == a.getHead()) {
				return 0;
			}
			else {
				return 1 + find(x, a.getTail());
			}
		}


	 // Exercise 4

	 static boolean allPositive(List<Integer> a) {
		if(a.isEmpty()) {
			return true;		
		}
		if(a.getHead()<0) {
			return false;
		}
		return allPositive(a.getTail());
	 }

	 // Exercise 5

	 static List<Integer> positives(List<Integer> a) {
		if(a.isEmpty()) {
			return a;		
		}
		if(a.getHead()<0) {
			return positives(a.getTail());
		}
		return new List<Integer>(a.getHead(), positives(a.getTail()));
	 }

	 // Exercise 6

	 static boolean sorted(List<Integer> a) {
		 if(a.getTail().isEmpty()) {
			 return true;
		 }
		 if(a.getHead()>a.getTail().getHead()) {
			 return false;
		 }
		 return sorted(a.getTail());
	 }

	 // Exercise 7

	 static List<Integer> merge(List<Integer> a, List<Integer> b) {
		 if(a.isEmpty()) {
			 return b;
		 }
		 else if(b.isEmpty()) {
			 return a;
		 }
		 if(a.getHead()<=b.getHead()) {
			 return new List<Integer>(a.getHead(),merge(a.getTail(),b));
		 }
		 return new List<Integer>(b.getHead(),merge(a, b.getTail())); 
	 }

	// Exercise 8

	static List<Integer> removeDuplicates(List<Integer> a) {
		if(a.getTail().isEmpty()) {
			return a;
		}
		if(a.getTail().getHead()==a.getHead()) {
			return removeDuplicates(a.getTail());
		}
		return new List<Integer>(a.getHead(), removeDuplicates(a.getTail())); 
	}
	
	// 2017test
	static List<Integer> common(List<Integer> a, List<Integer> b) {
		
		if(a.isEmpty())
			return a;//b->a
		else if (b.isEmpty())
			return b;//a->b
		else if (a.getHead() < b.getHead())
			return common(a.getTail(), b);
		else if (a.getHead() > b.getHead())
			return common(a, b.getTail());
		//return common(a.getTail(), b.getTail());
		return new List<Integer>(a.getHead(), common(a.getTail(),b.getTail()));
	}
	
	//2015 test
	static List<Integer> delete(int x, List<Integer> list) {
		if(list.isEmpty()) {
			return list;
		}
		else if(x<list.getHead()) {
			return list;
		}
		else if(x==list.getHead()) {
			return delete(x, list.getTail());
		}
		return new List<Integer>(list.getHead(), delete(x, list.getTail()));
		
	}
	
	

}
