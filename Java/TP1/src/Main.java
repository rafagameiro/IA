
/**
 * 
 */
import searchalgorithm.Algorithms;
import searchalgorithm.Node;
import undirectedgraph.Graph;

/**
 * @author arch
 *
 */

public class Main {

	public static void main(String[] args) {
		Graph graph = new Graph();
		graph.defineGraphRomenia();
		graph.showLinks();
		graph.showSets();
		Node n;
		n = graph.searchSolutionWProvince("Fagaras", "Eforie", "Crisana", Algorithms.AStarSearch);
//              String[] provinces = {"Dobrogea", "Banat"};
//              n = graph.searchSolutionProvinces("Arad", "Bucharest", provinces,Algorithms.AStarSearch);
		graph.showSolution(n);
	}
}
