package threadCartelle;

import java.io.File;

public class DirDigger implements Runnable {
	
	private String sourcePath;
	
	

	public DirDigger(String sourcePath) {
		super();
		this.sourcePath = sourcePath;
	}

	@Override
	public void run() {
		File dir = new File(sourcePath);
		
		
		int nFiles = dir.list().length;
		
		System.out.println("Nr cartelle e file della directory " + sourcePath + ": " + nFiles);

	}

	public static void main(String[] args) {
		DirDigger d = new DirDigger("C:\\Users\\franc\\OneDrive\\Desktop");
		new Thread(d).start();

	}

}
