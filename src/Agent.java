import java.util.ArrayList;

public class Agent {
	Lattice lattice;
	private int x, y;
	private int pathLen = 0;
	boolean isTrapped = false;
	
	public Agent(Lattice lattice) {
		this.lattice = lattice;
		x = y = lattice.getSize()/2;	
	}
	
	public void move(){
		int moveToMake = pickRandomDirFromList(checkValidMoves());
		lattice.setStep(x, y);
		pathLen++;
		switch (moveToMake){
		case 0:
			x+=1;
			break;
		case 1: 
			x-=1;
			break;
		case 2: 
			y+=1;
			break;
		case 3:
			y-=1;
			break;
		case -1:
			isTrapped = true;
		default:
			break;
		}
	}
	
	public int pickRandomDirFromList(ArrayList<Integer> al){
		return (al.isEmpty())? -1 : al.get((int)(Math.random()*al.size()));
	}
	public ArrayList<Integer> checkValidMoves(){
		ArrayList<Integer> movesArray = new ArrayList<Integer>();
		
		if (lattice.getStep(x+1, y) == 0) {
			movesArray.add(0);			//Valid move Right
		}	
		if(lattice.getStep(x-1,y) == 0 ){
			movesArray.add(1); 		     //Vaid move left
		}
		if(lattice.getStep(x,y+1) == 0){
			movesArray.add(2);			 //Valid Up
		}
		if(lattice.getStep(x, y-1) == 0){
			movesArray.add(3);			   //Valid Down
		}
		return movesArray;
		
	}
	public boolean isTrapped(){
		return isTrapped;
	}
	public int getPathLength(){
		return pathLen;
		
	}

}
