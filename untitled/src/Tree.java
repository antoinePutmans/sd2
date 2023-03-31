import java.util.Arrays;
import java.util.Iterator;

public class Tree implements Iterable<Tree> {

	private int value;

	private Tree parent;

	private Tree[] children;

	// *******************************************************
	// CONSTRUCTEURS
	// *******************************************************
	public Tree(int v, Tree[] chd) {
		value = v;
		children = chd;

		for (Tree child : chd) {
			child.parent = this;
		}
	}

	public Tree(int v) {
		this(v, new Tree[0]);
	}

	// *******************************************************
	// GETTERS
	// *******************************************************
	public int getValue() {
		return value;
	}

	public Tree getParent() {
		return parent;
	}

	public Tree[] getChildren() {
		return children;
	}

	// *******************************************************
	// ITERATEUR
	// *******************************************************
	public Iterator<Tree> iterator() {
		return Arrays.asList(children).iterator();
	}

	public int nbrChildren() {
		return children.length;
	}

	public boolean isLeaf() {
		return children.length == 0;
	}

	static int nbrNodes(Tree t){
		int r = 1;
		for (Tree child : t.children) {
			r += nbrNodes(child);
		}
		return r;
	}

	static int min(Tree t){
		int mini = t.getValue();
		for (Tree child : t.children) {
			int minFor = min(child);
			if (mini > minFor) mini	= minFor;
		}
		return mini;
	}

	static int sum(Tree t){
		int sum = t.getValue();
		for (Tree child : t.getChildren()) {
			sum += sum(child);
		}
		return sum;
	}

	static boolean equals(Tree t1,Tree t2){
		if (t1.getValue()!=t2.getValue()) return false;
		if (t1.children.length != t2.children.length) return false;
		for (int i = 0 ; i < t1.children.length ; i++){

		}
	}
}
