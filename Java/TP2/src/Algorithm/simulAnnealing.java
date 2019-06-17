/**
 * 
 */
package Algorithm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @author arch
 *
 */
public class simulAnnealing {
	
	static final double alpha = 0.85;
	static final int startIter = 1500;
	
		private String[] cities;
		private int[][] distances;
		private int citiesCount;
		private int rowCount;
		private int minDistance;
		private int maxDistance;
		
		private int nIterTotal;
		
		
		public simulAnnealing(String filename) {
			citiesCount = 0;
			rowCount = 0;
			minDistance = 1000;
			maxDistance = 0;
			nIterTotal = 0;
			inputData(filename);
		}

		private void inputData(String filename) {
			// TODO Auto-generated method stub
			File file = new File(filename);
			try {
				Scanner fr = new Scanner(file);
				
				defineSize(fr);
				int colCount = 0;
				
				fr = new Scanner(file);
				while(fr.hasNextLine()) {
					String content = fr.nextLine();
					String[] words = content.split(" ");
					if(words[0].equalsIgnoreCase("Distancias")) {
						cities[citiesCount++] = words[1];
						distances[rowCount++][colCount] = 0;
						continue;
					}else
						cities[citiesCount++] = words[0];
					
					for(int i = 1; i < words.length-1; i++) {
						if(!words[i].isEmpty()) {
							int num = Integer.parseInt(words[i]);
							distances[rowCount][colCount] = num;
							distances[colCount++][rowCount] = num;
							if(num > maxDistance)
								maxDistance = num;
							else if(num < minDistance)
								minDistance = num;
						}
					}
					distances[rowCount++][colCount] = 0;
					colCount = 0;
				}
				
				startAlgorithm(cities);
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		private void defineSize(Scanner fr) {
			// TODO Auto-generated method stub
			int cities = 0;
			while(fr.hasNextLine()) {
				cities++;
				fr.nextLine();
			}
			
			this.cities = new String[cities];
			this.distances = new int[cities][cities];
		}

		public String[] startAlgorithm(String[] problem) {
			// TODO Auto-generated method stub
			double temp;
			int delta;
			int nIter = startIter;
			String[] current;
			String[] near;
			String[] best;
			
			current = initSolution(problem);
			best = current;
			temp = initialTemp();
			System.out.println("initial temp: " + temp);
			
			while(true) {
				int i;
				for(i = 0; i < nIter; i++) {
					near = next(current);
					delta = distance(near) - distance(current);
					if(delta < 0) {
						current = near;
						if(distance(current) < distance(best))
							best = current;
					} else if(hasProbability(delta, temp))
						current = near; 
				}
			
			if(stopCriteria(temp)) {
				nIterTotal += i;
				break;
			}
			nIter = varNIter(nIter);
			temp = tempDecay(temp);
			}
			System.out.println("numero iteracoes: " + nIterTotal);
			
			System.out.println("best");
			for(int j = 0; j < best.length; j++)
				System.out.print(best[j]);
			System.out.println();
			System.out.println("custo: " + distance(best));
			
			return best;
		}

		private int varNIter(int nIter) {
			// TODO Auto-generated method stub
			nIterTotal += nIter;
			return nIter+=10;
		}

		private boolean hasProbability(int delta, double temp) {
			// TODO Auto-generated method stub
			double prob = Math.exp(-delta/temp);
			Random r = new Random();
			double random = r.nextDouble();
			if(random < prob)
				return true;
			else
				return false;
		}

		private boolean stopCriteria(double temp) {
			// TODO Auto-generated method stub
			if(temp < 0.5)
				return true;
			else
				return false;
		}

		private int distance(String[] current) {
			// TODO Auto-generated method stub
			int sum = 0;
			int indexTwo;
			int indexOne;
			for(int i = 0; i < current.length; i++) {
				indexOne = searchCity(current[i]);
				if(i+1 == current.length)
					indexTwo = searchCity(current[0]);
				else
					indexTwo = searchCity(current[i+1]);
				int distance = distances[indexOne][indexTwo];
				sum += distance;
			}
				
			return sum;
		}

		private int searchCity(String string) {
			// TODO Auto-generated method stub
			for(int i = 0; i < citiesCount; i++) 
				if(cities[i].equalsIgnoreCase(string))
					return i;

			return -1;
		}

		private String[] next(String[] current) {
			// TODO Auto-generated method stub
			int size = current.length;
			
			Random r = new Random();
			int i;
			int j;
			do {
				i = r.nextInt(size);
				j = r.nextInt(size - 1) + 1;
			}while(j <= i+1);
			
			String[] swapped = new String[size];
			int k;
			for(k = 0; k < size; k++) {
				if(k == i+1)
					swapped[i+1] = current[j];
				else if(k == j)
					swapped[j] = current[i+1];
				else
					swapped[k] = current[k];
			}
			
			return swapped;
		}

		private String[] initSolution(String[] problem) {
			// TODO Auto-generated method stub
			List probList = Arrays.asList(problem);
			Collections.shuffle(probList);
			String[] shuffled = (String[]) probList.toArray();
			
			System.out.println("Initial");
			for(int i = 0; i < shuffled.length; i++)
				System.out.print(shuffled[i]);
			System.out.println();
			return shuffled;
		}

		private double tempDecay(double temp) {
			// TODO Auto-generated method stub
			double newTemp = alpha * temp;
			return newTemp;
		}

		private double initialTemp() {
			// TODO Auto-generated method stub
			return 2*maxDistance - 2*minDistance;
		}
		

}
