import Algorithm.simulAnnealing;

/**
 * 
 */

/**
 * @author arch
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double time = System.currentTimeMillis();
		simulAnnealing sa = new simulAnnealing("table2.txt");
		System.out.println("total tempo " + (System.currentTimeMillis() - time));
//		String[] problem = {"Cerdeira", "Douro", "Gonta", "Infantado", "Lourel", "Nelas", "Oura", "Quebrada", "Roseiral", "Serra", "Teixoso", "Ulgueira"};
//		String[] solution = sa.startAlgorithm(problem);
//		for(int i = 0; i < solution.length; i++)
//			System.out.print(solution[i] + " ");
	}

}
