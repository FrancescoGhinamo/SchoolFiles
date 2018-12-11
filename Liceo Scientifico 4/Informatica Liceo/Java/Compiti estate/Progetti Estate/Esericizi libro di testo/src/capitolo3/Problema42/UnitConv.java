package capitolo3.Problema42;

public class UnitConv {
	
	private static final int BIT_IN_BYTE = 8;
	private static final int GEN_CONV = 1024;
	
	private long bit;
	
	

	public UnitConv(long bit) {
		super();
		this.bit = bit;
	}


	public double trovaByte() {
		return (double) (bit / BIT_IN_BYTE);
	}
	
	public double trovaKB() {
		return (double) (trovaByte() / GEN_CONV);
	}
	
	public double trovaMB() {
		return (double) (trovaKB() / GEN_CONV);
	}
	
	public double trovaGB() {
		return (double) (trovaMB() / GEN_CONV);
	}

	public static void main(String[] args) {
		Tastiera t = new Tastiera();
		System.out.print(" Inserire il numero di bit: ");
		UnitConv uc = new UnitConv(t.leggiLong());
		System.out.println(" Nr byte: "+uc.trovaByte()+" B");
		System.out.println(" Nr KB: "+uc.trovaKB()+ " KB");
		System.out.println(" Nr MB: "+uc.trovaMB()+" MB");
		System.out.println(" Nr GB: "+uc.trovaGB()+ " GB");
	}

}
