
public class Lattice {

	private int[][] lattice;
	private int size;
	
	public Lattice(int size) {
		this.size = size;
		lattice = new int[size][size];
	}
	public int getStep(int i, int j){
		return (i < size && j < size && i > 0 && j > 0) ? lattice[i][j] : -1;
	}
	public void setStep(int i, int j){
		lattice[i][j] = 1;
	}
	public void fillLattice(int fillValue){
		for (int i = 0; i < lattice.length; i++) {
			for (int j = 0; j < lattice.length; j++) {
				lattice[i][j] = fillValue;
			}
		}
	}
	public int getSize(){
		return size;
	}
	public String toString(){
		for (int i = 0; i < lattice.length; i++) {
			for (int j = 0; j < lattice.length; j++) {
				System.out.print(lattice[i][j]);
			}
			System.out.println();
		}
		return lattice.toString();
			
	}
}
