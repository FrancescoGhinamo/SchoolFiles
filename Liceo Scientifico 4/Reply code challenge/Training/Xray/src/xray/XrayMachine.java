package xray;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class XrayMachine {
	
	private ArrayList<Bone> bones;
	
	public XrayMachine() {
		bones = new ArrayList<Bone>();
	}
	
	public void initMachine(String sourcePath) {
		BufferedReader buffR = null;
		try {
			buffR = new BufferedReader(new FileReader(sourcePath));
			
			
			int testCases = Integer.parseInt(buffR.readLine());
			
			for(int nTest = 0; nTest < testCases; nTest++) {
				int nCent = Integer.parseInt(buffR.readLine());
				String[] centVals = buffR.readLine().split(" ");
				ArrayList<Centimeter> _cents = new ArrayList<Centimeter>();
				for(int n = 0; n < nCent; n++) {
					_cents.add(new Centimeter(Integer.parseInt(centVals[n])));
				}
				bones.add(new Bone(_cents));
				
			}
			
			
			
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(buffR != null) {
				try {
					buffR.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public boolean bonesNeedPassing() {
		boolean res = false;
		for(Bone b: bones) {
			if(b.needsPassing()) {
				res = true;
				break;
			}
		}
		return res;		
	}
	
	public void passBones() {
		for(Bone b: bones) {
			if(b.needsPassing()) {
				b.pass();
			}
		}
	}
	
	public void runMachine() {
		while(bonesNeedPassing()) {
			passBones();
		}
	}
	
	public void runMachineFast() {
		for(Bone b: bones) {
			b.passCompletely();
		}
	}
	
	public String prepareOuputString() {
		String res = "";
		int count = 1;
		for(Bone b: bones) {
			res += "Case #" + count + ": ";
			res += b.getPassings();
			res += "\r\n";
			count++;
		}
		return res;
	}
	
	public void saveOutput(String outputString, String outputPath) {
		FileWriter fw = null;
		try {
			fw = new FileWriter(outputPath);
			fw.write(outputString);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(fw != null) {
				try {
					fw.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally {
					try {
						fw.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		XrayMachine mac = new XrayMachine();
		mac.initMachine("F:\\School Files\\SchoolFiles\\Liceo Scientifico 4\\Reply code challenge\\Training\\Xray\\files\\input-xray-69df.txt");
		mac.runMachineFast();
		mac.saveOutput(mac.prepareOuputString(), "F:\\School Files\\SchoolFiles\\Liceo Scientifico 4\\Reply code challenge\\Training\\Xray\\files\\output-xray-69df.txt");
		

	}

}
