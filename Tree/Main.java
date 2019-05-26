
public class Main {

	public static void main(String[] args) {
		//Tree<Integer> t1 = new Tree(10, new Tree(8, new Tree(7), new Tree(9)),
		//		new Tree(12, new Tree(11), new Tree(13)));
		//Tree<Integer> t2 = new Tree(10, 
		//		new Tree(9, new Tree(5, new Tree(4, new Tree(), new Tree()), new Tree()), new Tree(7, new Tree(), new Tree())), 
		//		new Tree(8, new Tree(), new Tree()));
		//Tree<Integer> t3 = new Tree(10, new Tree(8, new Tree(), new Tree()),
		//		new Tree(12, new Tree(), new Tree()));
		//		new Tree(12, new Tree(), new Tree()));
		//System.out.println(Worksheet2.negateAll(t1));
		//System.out.println(Worksheet2.allPositive(t1));
		//System.out.println(Worksheet2.level(t1, 8));
		//System.out.println(Worksheet2.postorder(t1));
		//System.out.println(Worksheet2.isSearchTree(t1));
		//System.out.println(Worksheet2.max(t1));
		//System.out.println(Worksheet2.isHeightBalanced(t2));
		//Worksheet2.printDescending(t1);
		//System.out.println(t1);
		//System.out.println(Worksheet2.delete(t3, 8));
		
		//Tree<Integer> t1 = new Tree(12,
		//		new Tree(8, new Tree(6, new Tree(), new Tree()), new Tree(10, new Tree(), new Tree())),
		//		new Tree(16, new Tree(), new Tree()));
		//System.out.println(Worksheet2.insertHB(t1, 5));
		
		//Tree<Integer> t3 = new Tree(12,
		//		new Tree(8, new Tree(), new Tree()),
		//		new Tree(16, new Tree(14, new Tree(), new Tree()), new Tree(18, new Tree(), new Tree()))
		//		);
		
		//Tree<Integer> t1 = new Tree(16,
		//		new Tree(12, new Tree(8, new Tree(), new Tree()), new Tree(14, new Tree(), new Tree())),
		//		new Tree(18, new Tree(), new Tree(20, new Tree(), new Tree())));
		//System.out.println(Worksheet2.insertHB(t3, 17));
		//System.out.println(Worksheet2.insertHB(t3, 20));
		//System.out.println(Worksheet2.deleteHB(t1, 20));
		

		 Tree<Integer> actual = new Tree<Integer>(13,
	                new Tree(10,
	                        new Tree<Integer>(5, 
	                                new Tree<Integer>(4), new Tree<Integer>(8)),
	                        new Tree<Integer>(11)),
	                new Tree<Integer>(15,
	                        new Tree<Integer>(), new Tree<Integer>(16)));

		
		System.out.println(Worksheet2.insert(actual, 9));
	}

}
