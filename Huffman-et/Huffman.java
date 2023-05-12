import java.util.*;


public class Huffman {

	private static class Node  {
		private char ch;
		private int freq;
		private final Node left, right;

		public Node(char ch, int freq, Node left, Node right) {
			this.ch = ch;
			this.freq = freq;
			this.left = left;
			this.right = right;
		}

		public boolean isLeaf() {
			return left == null && right == null;
		}

	}
	public static void main(String[] args) {
		String s ="Bonjour! Au revoir!";
		Map<Character, Integer> freq = computeFreq(s);
		Node root = buildTree(freq);
		System.out.println("Nbre de lettre dans la chaine de caractere a encoder: "+ root.freq );
		System.out.println("Fréquence des lettres dans le sous-arbre de gauche: "+ root.left.freq );
		System.out.println("Fréquence des lettres dans le sous-arbre de droite: "+ root.right.freq );
	}
	
	// renvoie une map qui a comme cl� les lettres de la chaine de 
	// caract�re donn�e en param�tre et comme valeur la fr�quence de 
	// ces lettres 
	public static Map<Character, Integer> computeFreq(String s) {
		Map<Character,Integer> map = new HashMap<>();
		for (char c : s.toCharArray()) {
			if (!map.containsKey(c)){
				map.put(c,1);
			}
			else {
				int num = map.get(c);
				map.put(c,++num);
			}
		}
		return map;
	}	
	
	// renvoie l'arbre de Huffman obtenu � partir de la map des fr�quences des lettres 
	public static Node buildTree(Map<Character, Integer> freq) {
		Queue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(node -> node.freq));
		for (Character character : freq.keySet()) {
			priorityQueue.add(new Node(character,freq.get(character),null,null));
		}
		while(priorityQueue.size()!=1){
			Node firstNode = priorityQueue.poll();
			Node secondNode = priorityQueue.poll();
			Node newNode = new Node('\0',firstNode.freq+secondNode.freq,firstNode,secondNode);
			priorityQueue.add(newNode);
		}
		return priorityQueue.poll();
	}

	// renvoie une map qui associe chaque lettre � son code (suite de 0 et de 1). 
	// Ce code est obtenu en parcourant l'arbre de Huffman donn� en param�tre
	public static Map<Character, String> buildCode(Node root) {
		return null;
	}

	
	// encode la chaine de caract�re prise en param�tre en une chaine de 
	// bit (0 et 1) en utilisant la map des codes codeMap
	public static String compress(String s, Map<Character, String> codeMap) {
		return null;
	}
	
	// Cette m�thode d�code une chaine de 0 et de 1 cod� � l'aide de l'algorithme de Huffman
	// En param�tre, en plus de la chaine � d�coder, est sp�cifi� la racine de l'arbre de 
	// Huffman 
	public static String expand(Node root, String t) {
		return null;
	}
	
}
