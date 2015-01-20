/**
 * An abstract class for Suffix Trees.
 * 
 * @author Paul Chew for CS409, Apr 2000.
 * 
 * A Suffix Tree is built from a single string and contains all suffixes of
 * that string.  For this implementation, only letters and the separator ($) 
 * can appear in the string.
 * 
 * The separators ($s) are treated specially: they terminate suffixes.
 * In other words, each suffix is stored only up to its first $.  This implies
 * that identical suffixes can be stored in the tree.  To handle this situation
 * this implementation allows multiple leaf nodes.
 */
public abstract class SuffixTree {
	
	/* Internal classes */
	
	/**
	 * Generic tree node.  Parent class of LeafNode and InternalNode.
	 */
	class Node {						// Generic tree node
	}
	
	/**
	 * Leaf node.  Holds a suffix ID (where the suffix begins in the string).
	 * For this implementation, a suffix can appear multiple times in the
	 * same tree; this is because $ is treated as a separator/terminator.
	 * The more field allows a linked list of leaf nodes.  Using this,
	 * multiple suffixes can be stored at one "leaf".
	 */
	class LeafNode extends Node {		// Leaf node
		int beginIndex;					// ID for the suffix that ends here
		LeafNode more;					// More than one suffix can end here
	}
	
	/**
	 * Internal node.  Each internal node has up to 27 children, one for
	 * each letter and one for the separator ($).  Letters are stored in
	 * locations 1 through 26 and the separator corresponds to location 0.
	 */
	class InternalNode extends Node {	// Internal (nonleaf) node
		Edge[] child = new Edge[27];	// Child for each letter + separator
	}
	
	/**
	 * Tree edge.  Each edge corresponds to a substring of the original string.
	 * The beginIndex and endIndex define this substring.  The node is the
	 * node (either LeafNode or InternalNode) that this edge goes to.  The
	 * inclusive/exclusive rules used on the indices are chosen to match
	 * the arguments to String.substring().
	 */
	class Edge {						// Tree edge (labeled with a substring)
		int beginIndex;					// Beginning index, inclusive
		int endIndex;					// Ending index, exclusive
		Node node;						// Child node
	}
	
	
	/* Fields */
	
	/**
	 * The Suffix Tree.
	 * The root is the root of the entire suffix tree.
	 * The string is the original string (after converting to lower case
	 * and appending of a $ if necessary).  Indices stored within the suffix
	 * tree refer to locations within the string.
	 */
	InternalNode root = null;			// Root of the SuffixTree
	String string;						// String that is held in SuffixTree
	
	
	/* Abstract Methods */
	
	/**
	 * Constructor; create a SuffixTree.
	 * The input string should consist only of letters and the separator ($).
	 * If the original string does not end with '$' then '$' is appended.
	 */
	public SuffixTree (String inputString) {
		// This does nothing.
		// You have to implement a constructor that actually does
		// something for MySuffixTree.
	}
	
	/**
	 * Constructor; create a SuffixTree.
	 * This version is needed here just so that the constructor in
	 * MySuffixTree will work properly. This constructor is called automatically
	 * by the system as the first step of the MySuffixTree constructor.
	 * Your constructor for MySuffixTree should look like the previous
	 * constructor (i.e., it should take a string as input) rather than
	 * this constructor.
	 */
	public SuffixTree () {}

	/**
	 * Find all occurrences of a query string.
	 * @return an array of integer indices showing all the places in
	 *  the original string where the query string starts; note that
	 *  the size of the array matches the number of occurrences
	 */
	public abstract int[] findAll (String query);

	/**
	 * Locate the longest prefix of the given query string that appears as a
	 * suffix in the SuffixTree.
	 * @param query the query string
	 * @return an array of integer indices showing all the places in
	 *  the original string where the longest prefix starts
	 */
	public abstract int[] longestPrefix (String query);

		
		
	/* Other Methods */
	
	/**
	 * Shows all suffixes stored in the tree in sorted (alphabetical) order.
	 * If the SuffixTree is built correctly this is easy to do recursively.
	 * @return a String representation of the SuffixTree.
	 */
	public String toString () {
		// Note: "\n" is treated as end-of-line when used within a String.
		return "SuffixTree for " + string + ":" + toString("\n ",root);
	}
	
	/**
	 * Shows all Strings stored in the give subtree.  Each string has
	 * prefix placed in front of it.  This implementation is not
	 * particularly efficient; it does a lot of String recopying.
	 * @param prefix a prefix string
	 * @param node the subtree
	 * @return a String representation of the subtree
	 */
	private String toString(String prefix, InternalNode node) {
		StringBuffer buf = new StringBuffer();
		
		// Create strings for each edge leaving this node.
		for (int i = 0; i < node.child.length; i++) {
			Edge e = node.child[i];
			if (e == null) continue;			// Skip unused edges
			
			// String for this edge; include '.' as node marker.
			String edgeString = "." + string.substring(e.beginIndex,e.endIndex);
			
			// If we are at a leaf node, we create the string.
			if (e.node instanceof LeafNode) {
				LeafNode leaf = (LeafNode)e.node;
				
				// Include the edge string and the ID of corresponding suffix.
				buf.append(prefix + edgeString + " " + leaf.beginIndex);
				
				// Include suffix data from any extra leaf nodes.
				while (leaf.more != null) {
					leaf = leaf.more;
					buf.append("," + leaf.beginIndex);
				}
			}
			
			// If not at a leaf node, we recursively build the strings
			// corresponding to this node.  The prefix changes.
			else buf.append(toString(prefix+edgeString,(InternalNode)e.node));
		}
		return buf.toString();
	}
	
	/**
	 * Return a string representation of an array of integers.  Used for
	 * printing results of subtree searches.
	 * @param array the array of integers
	 * @return a String representation of the array of integers
	 */
	static String toString (int[] array) {
		if (array.length == 0) return "{}";
		StringBuffer buf = new StringBuffer("{" + array[0]);
		for (int i = 1; i < array.length; i++)
			buf.append("," + array[i]);
		return buf.append("}").toString();
	}
	
	/**
	 * A simple testing program for suffix trees.
	 * @param string the string used to build the suffix tree
	 */
	private static void test (String string) {
		SuffixTree tree;
		tree = new MySuffixTree(string);
		System.out.println(tree);
		System.out.println("'miss' occurs at " + toString(tree.findAll("miss")));
		System.out.println("'is' occurs at " + toString(tree.findAll("is")));
		System.out.println("'i' occurs at " + toString(tree.findAll("i")));
		System.out.println("The longest prefix of 'issue' occurs at " +
						   toString(tree.longestPrefix("issue")));
		System.out.println();
	}
		

	/* Main Program */
	
	/**
	 * Main program; used for testing.
	 */
	public static void main (String[] args) {
		test("mississippi$");
		test("mississippi$missouri$");
		test("indiana$louisiana$");
		test("data$structures$and$algorithms$sure$are$fun$");
	}
}