
public class Main {
	
	public static void main(String[] args) {
		
		int accPathLen = 0;
		Lattice l = new Lattice(100);
		Agent a = new Agent(l);
		while (!a.isTrapped()) {
			a.move();
		}
		
//		for (int i = 0; i < 1000; i++) {
//			Lattice l = new Lattice(100);
//			Agent a = new Agent(l);
//			while (!a.isTrapped()) {
//				a.move();
//			}
//			accPathLen += a.getPathLength();
//		}

		
		System.out.println(l.toString());
		System.out.println(accPathLen/1000);
		
	}

}
