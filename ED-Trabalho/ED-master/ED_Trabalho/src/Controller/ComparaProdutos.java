import Model.Produto;


public class ComparaProdutos implements Comparator{
	
	
	public int compare (Produto p1, Produto p2) {
		return p1.getName().compareTo(p2.getName());
		
	}
	
}
