package capitolo3.Problema44;

public class Ricerca {
	
	private int val[];
	
	

	public Ricerca(int[] val) {
		super();
		this.val = val;
	}


	public boolean presente(int num) {
		boolean p = false;
		for(int c = 0; c < val.length; c++) {
			if(val[c] == num) {
				p = true;
				break;
			}
		}
		return p;
	}

	public static void main(String[] args) {
		int[] nums = new int[30];
		for(int c = 0; c < nums.length; c++) {
			nums[c] = (int) ((Math.random() * 10000) % 100);
		}
		System.out.println(" Array caricato:");
		for(int c = 0; c < nums.length; c++) {
			System.out.print(nums[c]+" ");
		}
		Ricerca r = new Ricerca(nums);
		System.out.println("\n Presenza valore 50: "+r.presente(50));

	}

}
