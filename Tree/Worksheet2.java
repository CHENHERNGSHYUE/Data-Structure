/**
 * @author <Herng-Shyue Chen> This class contains the solution for Worksheet2
 * @version 2019-02-03
 */

public class Worksheet2 implements Worksheet2Interface {

	// Exercise 1

	/**
	 * 
	 * @param t Tree
	 * @return Tree
	 */
	
	static Tree<Integer> negateAll(Tree<Integer> t) {
		if(t.isEmpty()) {
			return t;
		}
		return new Tree<Integer>(t.getValue()*-1, negateAll(t.getLeft()), negateAll(t.getRight()));
	}

	// Exercise 2
	
	/**
	 * 
	 * @param t Tree
	 * @return true or false
	 */
	
	static boolean allPositive(Tree<Integer> t) {
		if(t.isEmpty()) {
			return true;
		}
		else if(t.getValue()<0) {
			return false;
		}
		else {
			return (allPositive(t.getLeft()) && allPositive(t.getRight()));
		}
	}

	// Exercise 3
	
	/**
	 * 
	 * @param t tree
	 * @param e element
	 * @param l level
	 * @return level
	 */
	
	static int getLevel(Tree<Integer> t, int e, int l) {
		if(t.isEmpty()) {
			return 0;
		}
		if(t.getValue()==e) {
			return l;
		}
		if(getLevel(t.getLeft(), e ,l)!=0) {
			return getLevel(t.getLeft(), e, l+1);
		}
		return getLevel(t.getRight(), e, l+1);
	}
	
	/**
	 * 
	 * @param t tree
	 * @param e element
	 * @return level
	 */
	
	static int level(Tree<Integer> t, int e) {
		return getLevel(t,e,1);
	}

	// Exercise 4
	
	/**
	 * 
	 * @param l1 List
	 * @param l2 List
	 * @return append List
	 */
	
	static <E> List<E> append(List<E> l1, List<E> l2) {
        if (l1.isEmpty()) {
            return l2;
        } else {
            return new List<E>(l1.getHead(), append(l1.getTail(), l2));
        }
    }
	
	/**
	 * 
	 * @param l list
	 * @param e element
	 * @return new list after add new element
	 */
	
	static <E> List<E> addToEnd(List<E> l, E e) {
        if (l.isEmpty()) {
            return new List<E>(e, new List<E>());
        } else {
            return new List<E>(l.getHead(), addToEnd(l.getTail(), e));
        }
    }
	
	/**
	 * 
	 * @param t tree
	 * @return list with post order
	 */
	
	static <E> List<E> postorder(Tree<E> t) {
		if(t.isEmpty()) {
			return new List<E>();
		}
        return append(postorder(t.getLeft()), addToEnd(postorder(t.getRight()),t.getValue()));
	}

	// Exercise 5
	
	/**
	 * 
	 * @param t tree
	 * @param e1 element
	 * @param e2 element
	 * @return true or false
	 */
	
	static boolean compareNode(Tree<Integer> t, int e1, int e2) {
		if(t.isEmpty()) {
	    	return true;
	    }
		return (t.getValue() > e1 && t.getValue() < e2 && 
	    		compareNode(t.getLeft(), e1, t.getValue()) && 
	    		compareNode(t.getRight(), t.getValue(), e2));
	}
	
	/**
	 * 
	 * @param t tree
	 * @return
	 */
	
	static boolean isSearchTree(Tree<Integer> t) {
		return  compareNode(t, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	// Exercise 6
	
	/**
	 * 
	 * @param t tree
	 */
	
	static void printDescending(Tree<Integer> t) {
		if(!t.isEmpty()) {
			printDescending(t.getRight());
			System.out.print(t.getValue()+" ");
			printDescending(t.getLeft());
		}
	}
	
	/**
	 * 
	 * @param args main test
	 */
	
	public static void main(String[] args) {
		Tree<Integer> t1 = new Tree<Integer>(10, new Tree(8, new Tree(7), new Tree(9)),
						new Tree(12, new Tree(11), new Tree(13)));
		printDescending(t1);
	}

	// Exercise 7
	
	/**
	 * 
	 * @param t tree
	 * @return max number in the tree
	 */
	
	static int max(Tree<Integer> t) {
		if(t.isEmpty()) {
			throw new IllegalArgumentException("It is empty tree.");
		}
		if(t.getRight().isEmpty()) {
			return t.getValue();
		}
		return max(t.getRight());
	}

	// Exercise 8
	
	/**
	 * 
	 * @param t tree
	 * @param e element
	 * @return
	 */
	
	static Tree<Integer> delete(Tree<Integer> t, int e) {
		if (t.isEmpty()) {
			return new Tree<Integer>();//return t
		}
		else if(t.getValue()>e) { 
			return new Tree<Integer>(t.getValue(), delete(t.getLeft(),e), t.getRight());
		}else if(t.getValue()<e) {
			return new Tree<Integer>(t.getValue(), t.getLeft(), delete(t.getRight(),e));
		}else
			if(t.getLeft().isEmpty() && t.getRight().isEmpty()) {
				return new Tree<Integer>();
			}
			if(t.getLeft().isEmpty()) {
				return new Tree<Integer>(t.getRight().getValue(), new Tree(), new Tree());
			}//return t.getRight()
			if(t.getRight().isEmpty()) {
				return new Tree<Integer>(t.getLeft().getValue(), new Tree(), new Tree());
			}//return t.getLeft()
			if(!t.getRight().isEmpty() && !t.getLeft().isEmpty()) {
				return new Tree<Integer>(max(t.getLeft()), delete(t.getLeft(), max(t.getLeft())), t.getRight());
			}
		return t; 
	}
	
	// Exercise 9
	
	/**
	 * 
	 * @param t tree
	 * @return
	 */
	
	static <E> boolean isHeightBalanced(Tree<E> t) {
		if(t.isEmpty()) {
			return true;
		}
		if(Math.abs(t.getLeft().getHeight()-t.getRight().getHeight())>1) {
			return false;
		}
		isHeightBalanced(t.getRight());
		isHeightBalanced(t.getLeft());
		return true; 
	}

	// Exercise 10
	
	/**
	 * 
	 * @param t tree
	 * @param e element
	 * @return tree after insert new element
	 */
	
	static Tree<Integer> insert(Tree<Integer> t, int e) {
		if(t.isEmpty()) {
			return new Tree<Integer>();
		}
		if(t.getValue()==e) {
			throw new IllegalArgumentException("The number is existed.");
		}
		if(t.getValue()<e && t.getRight().isEmpty()) {
			return new Tree<Integer>(t.getValue(), t.getLeft(), new Tree(e, new Tree(), new Tree()));
		}else if(t.getValue()<e && !t.getRight().isEmpty())	{
			return new Tree<Integer>(t.getValue(), t.getLeft(), insert(t.getRight(), e));
		}else if(t.getValue()>e && t.getLeft().isEmpty()) {
			return new Tree<Integer>(t.getValue(), new Tree(e, new Tree(), new Tree()), t.getRight());
		}else if(t.getValue()>e && !t.getLeft().isEmpty()) {
			return new Tree<Integer>(t.getValue(), insert(t.getLeft(), e), t.getRight());
		}
		return new Tree<Integer>();
	}
	
	/**
	 * 
	 * @param t tree
	 * @return new tree after LL rotate
	 */
	
	static Tree<Integer> llRotate(Tree<Integer> t){
			return new Tree<Integer>(t.getLeft().getValue(), t.getLeft().getLeft(), 
				new Tree<Integer>(t.getValue(), t.getLeft().getRight() , t.getRight()));
	}
	
	/**
	 * 
	 * @param t tree
	 * @return new tree after RR rotate
	 */
	
	static Tree<Integer> rrRotate(Tree<Integer> t){
			return new Tree<Integer>(t.getRight().getValue(),  
				new Tree<Integer>(t.getValue(), t.getLeft(), t.getRight().getLeft()),
				t.getRight().getRight());
	}
	
	/**
	 * 
	 * @param t tree
	 * @return new tree after LR rotate
	 */
	
	static Tree<Integer> lrRotate(Tree<Integer> t){
			return llRotate(new Tree<Integer>(t.getValue(), rrRotate(t.getLeft()), t.getRight()));
	}
	
	/**
	 * 
	 * @param t tree
	 * @return new tree after RL rotate
	 */
	
	static Tree<Integer> rlRotate(Tree<Integer> t){
			return rrRotate(new Tree<Integer>(t.getValue(), t.getLeft(), llRotate(t.getRight())));
	}
	
	/**
	 * 
	 * @param t tree
	 * @param e element
	 * @return new AVL tree after insert a element
	 */
	
	static Tree<Integer> insertHB(Tree<Integer> t, int e) {
		if(t.isEmpty()) {
			return new Tree<Integer>();
		}
		if(isHeightBalanced(insert(t,e)) == false) {
			if(e<t.getValue()) {
				if(e>t.getLeft().getValue()) {
					return lrRotate(insert(t,e));
				}else
					return llRotate(insert(t,e));
			}else
				if(e>t.getRight().getValue()) {
					return rrRotate(insert(t,e));
				}else
					return rlRotate(insert(t,e));
		}
		return insert(t,e);
	}
	
	/**
	 * 
	 * @param t tree
	 * @param e element
	 * @return new AVL tree after delete a element
	 */
	static Tree<Integer> deleteHB(Tree<Integer> t, int e) {
		if(t.isEmpty()) {
			return new Tree<Integer>();
		}
		if(isHeightBalanced(delete(t,e)) == false) {
			if(e<t.getValue()) {
				if(e>t.getLeft().getValue()) {
					return lrRotate(delete(t,e));
				}else
					return llRotate(delete(t,e));
			}else
				if(e>t.getRight().getValue()) {
					return rrRotate(delete(t,e));
				}else
					return rlRotate(delete(t,e));
		}
		return delete(t,e);
	}
}

