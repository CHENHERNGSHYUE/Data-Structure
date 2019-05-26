import static org.junit.Assert.*;
import org.junit.Test;
/** 
 * @author Herng-Shyue Chen
 * This class contains the test cases for Worksheet1 solutions.
 *  <MY TEST CASES IN BELOW>
 *  @version 2019-02-03
 */

public class Worksheet2Test {
	
	/**
	 * Check the positive numbers, negative numbers and 0
	 * whether would correctly change the sign symbol 
	 */
	
	@Test
	public void Exercise1() {
		
		Tree<Integer> t1 = new Tree(10, new Tree(-8, new Tree(7), new Tree(9)),
						new Tree(12, new Tree(0), new Tree(-13)));
		
		Tree<Integer> t2 = new Tree(-10, new Tree(8, new Tree(-7), new Tree(-9)),
				new Tree(-12, new Tree(0), new Tree(13)));
		
		Tree<Integer> expectedTree = t2;
		Tree<Integer> actualTree = Worksheet2.negateAll(t1);

		assertEquals(expectedTree, actualTree);
	}	
	
	/**
	 * Check the all numbers in the tree are positive or not
	 */
	
	@Test
	public void Exercise2() {
		
		Tree<Integer> t1 = new Tree(10, new Tree(8, new Tree(7), new Tree(9)),
				new Tree(12, new Tree(0), new Tree(13)));

		Tree<Integer> t2 = new Tree(10, new Tree(8, new Tree(-7), new Tree(-9)),
		new Tree(12, new Tree(1), new Tree(13)));

		assertTrue(Worksheet2.allPositive(t1));
		assertFalse(Worksheet2.allPositive(t2));
	}
	
	/**
	 * Check whether can find the number's level correctly, 
	 * and if this number does not exist, then should be return 0 
	 */
	
	@Test
	public void Exercise3() {
		
		Tree<Integer> t1 = new Tree(10, new Tree(8, new Tree(-7), new Tree(-9)),
				new Tree(12, new Tree(1), new Tree(13)));
		
		int expectedNumber = 0;
		int actualNumber = Worksheet2.level(t1,20);
		
		assertEquals(expectedNumber, actualNumber);
		
		int expectedNumber2 = 3;
		int actualNumber2 = Worksheet2.level(t1,-9);
		
		assertEquals(expectedNumber2, actualNumber2);
		
		int expectedNumber3 = 1;
		int actualNumber3 = Worksheet2.level(t1,10);
		
		assertEquals(expectedNumber3, actualNumber3);	
	}
	
	/**
	 * Check whether can correctly transfer BT and BST to list in postorder way
	 */
	
	@Test
	public void Exercise4() {
		
		Tree<Integer> t1 = new Tree(10, new Tree(8, new Tree(-7), new Tree(-9)),
				new Tree(12, new Tree(1), new Tree(13)));
		
		List<Integer> expectedList = new List(-7, new List(-9, new List(8, new List(1, 
				new List(13, new List(12, new List(10, new List())))))));
		List<Integer> actualList = Worksheet2.postorder(t1);
		
		assertEquals(expectedList, actualList);	
		
		Tree<Integer> t2 = new Tree(5, 
				new Tree(2, new Tree(1), new Tree(4, new Tree(3, new Tree(), new Tree()), new Tree())),
				new Tree(6, new Tree(), new Tree(8, new Tree(7, new Tree(), new Tree()), 
						new Tree(9, new Tree(), new Tree()))));
		
		List<Integer> expectedList2 = new List(1, new List(3, new List(4, new List(2, 
				new List(7, new List(9, new List(8, new List(6, new List(5, new List())))))))));
		List<Integer> actualList2 = Worksheet2.postorder(t2);
		
		assertEquals(expectedList2, actualList2);
	}
	
	/**
	 * Check whether it is the binary search tree
	 */
	
	@Test
	public void Exercise5() {
		
		Tree<Integer> t1 = new Tree(10, new Tree(8, new Tree(-7), new Tree(-9)),
				new Tree(12, new Tree(1), new Tree(13)));
		
		Tree<Integer> t2 = new Tree(5, 
				new Tree(2, new Tree(1), new Tree(4, new Tree(3, new Tree(), new Tree()), new Tree())),
				new Tree(6, new Tree(), new Tree(8, new Tree(7, new Tree(), new Tree()), 
						new Tree(9, new Tree(), new Tree()))));
		
		assertTrue(Worksheet2.isSearchTree(t2));
		assertFalse(Worksheet2.isSearchTree(t1));

	}
	
	/**
	 * Find the max number in the binary search tree
	 */
	
	@Test
	public void Exercise7A() {
		
		Tree<Integer> t2 = new Tree(5, 
				new Tree(2, new Tree(1), new Tree(4, new Tree(3, new Tree(), new Tree()), new Tree())),
				new Tree(6, new Tree(), new Tree(8, new Tree(7, new Tree(), new Tree()), 
						new Tree(9, new Tree(), new Tree()))));
		
		int expectedNumber = 9;
		int actualNumber = Worksheet2.max(t2);
		
		assertEquals(expectedNumber, actualNumber);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void Exercise7B() {
		
		Tree<Integer> t3 = new Tree();
		
		Worksheet2.max(t3);	
	}
	
	/**
	 * Check whether can correctly delete the number and still keep in the binary search tree
	 * with the three different cases (no child, one child, and two children)
	 */
	
	@Test
	public void Exercise8() {
		
		Tree<Integer> t1 = new Tree(5, 
				new Tree(2, 
						new Tree(1, new Tree(), new Tree()),
						new Tree(4, new Tree(3, new Tree(), new Tree()), new Tree())),
				new Tree(6, 
						new Tree(), 
						new Tree(8, new Tree(7, new Tree(), new Tree()), new Tree(9, new Tree(), new Tree()))));
		Tree<Integer> t1_1 = new Tree(5, 
				new Tree(2, 
						new Tree(1, new Tree(), new Tree()),
						new Tree(4, new Tree(), new Tree())),
				new Tree(6, 
						new Tree(), 
						new Tree(8, new Tree(7, new Tree(), new Tree()), new Tree(9, new Tree(), new Tree()))));
		Tree<Integer> t1_2 = new Tree(5, 
				new Tree(2, 
						new Tree(1, new Tree(), new Tree()),
						new Tree(3, new Tree(), new Tree())),
				new Tree(6, 
						new Tree(), 
						new Tree(8, new Tree(7, new Tree(), new Tree()), new Tree(9, new Tree(), new Tree()))));
		Tree<Integer> t1_3 = new Tree(4, 
				new Tree(2, new Tree(1, new Tree(), new Tree()), new Tree(3, new Tree(), new Tree())),
				new Tree(6, new Tree(), new Tree(8, new Tree(7, new Tree(), new Tree()), 
						new Tree(9, new Tree(), new Tree()))));
		
		
		Tree<Integer> expectedTree = t1_1;
		Tree<Integer> actualTree = Worksheet2.delete(t1, 3);
		Tree<Integer> expectedTree2 = t1_2;
		Tree<Integer> actualTree2 = Worksheet2.delete(t1, 4);
		Tree<Integer> expectedTree3 = t1_3;
		Tree<Integer> actualTree3 = Worksheet2.delete(t1, 5);

		assertEquals(expectedTree, actualTree);
		assertEquals(expectedTree2, actualTree2);
		assertEquals(expectedTree3, actualTree3);
	}
	
	/**
	 * Check whether is the AVL tree
	 */
	
	@Test
	public void Exercise9() {
		
		Tree<Integer> t1 = new Tree(5, 
				new Tree(2, new Tree(1), new Tree(4, new Tree(3, new Tree(), new Tree()), new Tree())),
				new Tree(6, new Tree(), new Tree(8, new Tree(7, new Tree(), new Tree()), 
						new Tree(9, new Tree(), new Tree()))));
		Tree<Integer> t2 = new Tree(5, 
				new Tree(2, 
						new Tree(1, new Tree(), new Tree()),
						new Tree(4, new Tree(3, new Tree(), new Tree()), new Tree())),
				new Tree(6, new Tree(),  new Tree()));
		
		assertTrue(Worksheet2.isHeightBalanced(t1));
		assertFalse(Worksheet2.isHeightBalanced(t2));
	}
	
	/**
	 * Check whether can insert the number correctly and keep in the AVL tree
	 * with the four different cases (LL, RR, LR, RL)
	 */
	
	@Test
	public void Exercise10A() {
		
		Tree<Integer> t1 = new Tree(12,
				new Tree(8, new Tree(6, new Tree(), new Tree()), new Tree(10, new Tree(), new Tree())),
				new Tree(16, new Tree(), new Tree()));
		
		Tree<Integer> LL = new Tree(8,
				new Tree(6, new Tree(5, new Tree(), new Tree()), new Tree()),
				new Tree(12, new Tree(10, new Tree(), new Tree()), new Tree(16, new Tree(), new Tree())));
		
		Tree<Integer> LR = new Tree(10,
				new Tree(8, new Tree(6, new Tree(), new Tree()), new Tree()),
				new Tree(12, new Tree(11, new Tree(), new Tree()), new Tree(16, new Tree(), new Tree())));
		
		Tree<Integer> expectedTree = LL;
		Tree<Integer> actualTree = Worksheet2.insertHB(t1, 5);
		
		Tree<Integer> expectedTree2 = LR;
		Tree<Integer> actualTree2 = Worksheet2.insertHB(t1, 11);
		
		assertEquals(expectedTree, actualTree);
		assertEquals(expectedTree2, actualTree2);
		
		Tree<Integer> t2 = new Tree(12,
						new Tree(),
						new Tree(16, new Tree(), new Tree()));
		
		Tree<Integer> RL = new Tree(15,
				new Tree(12, new Tree(), new Tree()),
				new Tree(16, new Tree(), new Tree()));
		
		Tree<Integer> expectedTree3 = RL;
		Tree<Integer> actualTree3 = Worksheet2.insertHB(t2, 15);
		
		assertEquals(expectedTree3, actualTree3);
		
		Tree<Integer> t3 = new Tree(12,
				new Tree(8, new Tree(), new Tree()),
				new Tree(16, new Tree(14, new Tree(), new Tree()), new Tree(18, new Tree(), new Tree()))
				);
		
		Tree<Integer> RL2 = new Tree(16,
				new Tree(12, new Tree(8, new Tree(), new Tree()), new Tree(14, new Tree(), new Tree())),
				new Tree(18, new Tree(17, new Tree(), new Tree()), new Tree()));
		
		Tree<Integer> RR = new Tree(16,
				new Tree(12, new Tree(8, new Tree(), new Tree()), new Tree(14, new Tree(), new Tree())),
				new Tree(18, new Tree(), new Tree(20, new Tree(), new Tree())));
		
		Tree<Integer> expectedTree4 = RL2;
		Tree<Integer> actualTree4 = Worksheet2.insertHB(t3, 17);
		
		Tree<Integer> expectedTree5 = RR;
		Tree<Integer> actualTree5 = Worksheet2.insertHB(t3, 20);
		
		assertEquals(expectedTree4, actualTree4);
		assertEquals(expectedTree5, actualTree5);
		
		Tree<Integer> t4 = new Tree(12,
				new Tree(9, new Tree(), new Tree()),
				new Tree(16, new Tree(), new Tree()));
		Tree<Integer> normal = new Tree(12,
				new Tree(9, new Tree(), new Tree()),
				new Tree(16, new Tree(), new Tree(17, new Tree(), new Tree())));
		
		Tree<Integer> expectedTree6 = normal;
		Tree<Integer> actualTree6 = Worksheet2.insertHB(t4, 17);
		
		assertEquals(expectedTree6, actualTree6);	
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void Exercise10B() {
		
		Tree<Integer> t1 = new Tree(12,
				new Tree(9, new Tree(), new Tree()),
				new Tree(16, new Tree(), new Tree()));
		
		Worksheet2.insertHB(t1, 16);
		
	}
	
	@Test
	public void Exercise10C() {
		
		Tree<Integer> t1 = new Tree(16,
				new Tree(12, new Tree(8, new Tree(), new Tree()), new Tree(14, new Tree(), new Tree())),
				new Tree(18, new Tree(), new Tree(20, new Tree(), new Tree())));
		
		Tree<Integer> t2 = new Tree(16,
				new Tree(12, new Tree(8, new Tree(), new Tree()), new Tree(14,new Tree(), new Tree())),
				new Tree(18, new Tree(), new Tree()));
		
		Tree<Integer> expectedTree = t2;
		Tree<Integer> actualTree = Worksheet2.delete(t1, 20);
		
		assertEquals(expectedTree, actualTree);	
	}
	
}
