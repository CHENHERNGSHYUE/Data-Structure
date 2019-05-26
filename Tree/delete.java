
public class delete {
	
	public static Tree<Integer> delete(Tree<Integer> a, int x) {
		if (a.isEmpty())
			throw new IllegalArgumentException("value not present in tree");
		else {
			int value = a.getValue();
			Tree<Integer> left = a.getLeft();
			Tree<Integer> right = a.getRight();
		if (x > value) {
			Tree<Integer> newRight = delete(right, x);
			return new Tree(a.getValue(), left, newRight);
		}
		else if (x < value) {
			Tree<Integer> newLeft = delete(left, x);
			return new Tree(a.getValue(), newLeft, right);
		}
		else {
			int newValue = Worksheet2.max(left);
			return new Tree(newValue, delete(left, newValue), right);
			}
		}
	}
	public static void main(String args[]) {
		Tree<Integer> t1 = new Tree(10, new Tree(8, new Tree(7), new Tree(9)),
				new Tree(12, new Tree(11), new Tree(13)));
		System.out.println(delete(t1, 10));
	}
	


}
