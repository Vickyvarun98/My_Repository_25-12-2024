package JavaPrograms;

public class LeftCross {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int count=5;
		for(int i=1;i<=count;i++) {
			for(int j=1;j<=i;j++) {
				if(i==j) {
					System.out.print("* ");
				}else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}



	}

}
