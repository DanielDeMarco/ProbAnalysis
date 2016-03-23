import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("Problem 1: 100 Trials");
		calculateStats(generatePathLenData(100,100));
		System.out.println("Problem 1: 1000 Trials");
		calculateStats(generatePathLenData(100,1000));
		System.out.println("Problem 2a: 10 Trials");
		calculateStats(latticeData(5000, 10));
		System.out.println("Problem 2b: 10 Trials");
		calculateStats(distanceData(5000, 10));
		System.out.println("Problem 2a: 100 Trials");
		calculateStats(latticeData(5000, 100));
		System.out.println("Problem 2b: 100 Trials");
		calculateStats(distanceData(5000, 100));
		System.out.println("Problem 2a: 1000 Trials");
		calculateStats(latticeData(5000, 1000));
		System.out.println("Problem 2b: 1000 Trials");
		calculateStats(distanceData(5000, 1000));
	}
	
	public static int[] latticeData(int MaxSteps, int trials){
        int[] latticeSize  = new int[trials];

		for (int i = 0; i < trials; i++) {
			Lattice l = new Lattice(MaxSteps);
			Agent a = new Agent(l);
			while (!a.isTrapped()) {
				a.move();
			}
			latticeSize[i] = a.latticeSize()-MaxSteps/2;
			
		}
		return latticeSize;
		
	}
	public static int[] distanceData(int MaxSteps, int trials){
        int[] latticeSize  = new int[trials];

		for (int i = 0; i < trials; i++) {
			Lattice l = new Lattice(MaxSteps);
			Agent a = new Agent(l);
			while (!a.isTrapped()) {
				a.move();
			}
			latticeSize[i] = a.getDistance();
		}
		return latticeSize;
		
	}
	
	
	public static int[] generatePathLenData(int gridSize, int trials){
        int[] pathLens  = new int[trials];

		for (int i = 0; i < trials; i++) {
			Lattice l = new Lattice(gridSize);
			Agent a = new Agent(l);
			while (!a.isTrapped()) {
				a.move();
			}
			pathLens[i] = a.getPathLength();
		}
		return pathLens;
	}
	public static void calculateStats(int[] values){
		int sum = 0;
		int average;
		double variance = 0;
		
		for (int i = 0; i < values.length; i++) {
			sum+= values[i];
		}
		average = sum/values.length;
		System.out.printf("%s: %d\n", "Average: ", average);
		for (int i = 0; i < values.length; i++) {
			variance += Math.pow((average - values[i]), 2);
			variance /= values.length;
		}
		System.out.printf("%s %f\n%s %f\n", "Variance: ", variance, "Standard Deviation: ", Math.sqrt(variance));
		Arrays.sort(values);
		System.out.printf("Median: %d\n", values[values.length/2]); 
		System.out.printf("Mode: %d\n", findMode(values)); 
		System.out.println("------------------------");
			
			
	}
	static int findMode(int[] modeArray){
	    int t = 0;
	    for(int i=0; i<modeArray.length; i++){
	        for(int j=1; j<modeArray.length-i; j++){
	            if(modeArray[j-1] > modeArray[j]){
	                t = modeArray[j-1];
	                modeArray[j-1] = modeArray[j];
	                modeArray[j] = t;
	            }
	        }
	    }
	    int answer = modeArray[0];
	    int temporary = 1;
	    int temporary2 = 1;
	    for(int i=1;i<modeArray.length;i++){
	        if(modeArray[i-1] == modeArray[i]){
	            temporary++;
	        }
	        else {
	            temporary = 1;
	        }
	        if(temporary >= temporary2){
	            answer = modeArray[i];
	            temporary2 = temporary;
	        }
	    }
	    return answer;
	}

}
