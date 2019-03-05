package antivirus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Antivirus {
	
	private FileTester[] fileTesters;
	
	
	private String result;
	
	
	
	public void initAntivirus(String sourceFile) {
		BufferedReader buffR = null;
		try {
			buffR = new BufferedReader(new FileReader(sourceFile));
			
			int testCases = Integer.parseInt(buffR.readLine());
			
			fileTesters = new FileTester[testCases];
			
			for(int n = 0; n < testCases; n++) {
				
				
				
				String[] fileLengthsStr = buffR.readLine().split(" ");
				int virusLength = Integer.parseInt(buffR.readLine());
				String[] files = new String[fileLengthsStr.length];
				for(int i = 0; i < fileLengthsStr.length; i++) {
					int fileLength = Integer.parseInt(fileLengthsStr[i]);
					String _f = buffR.readLine();
					_f = _f.substring(0, fileLength);
					files[i] = _f;
					
				}
				
				fileTesters[n] = new FileTester(files, virusLength);
				
				
				
				
				
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
	
	
	public void runAntivirus() {
		if(fileTesters != null) {
			result = "";
			int count = 1;
			for(FileTester ft: fileTesters) {
				int[] indx = ft.virusStartIndexes();
				String out = "Case #" + count + ": ";
				out += indx[0] + " " + indx[1] + " " + indx[2] + " " + indx[3];
				out += "\r\n";
				count++;
				result += out;
			}
		}
		
	}
	
	public void saveOutput(String destination) {
		FileWriter fw = null;
		try {
			fw = new FileWriter(destination);
			fw.write(result);
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
		Antivirus a = new Antivirus();
		a.initAntivirus("F:\\School Files\\SchoolFiles\\Liceo Scientifico 4\\Reply code challenge\\Training\\Antivirus\\files\\Input.txt");
		a.runAntivirus();
		a.saveOutput("F:\\School Files\\SchoolFiles\\Liceo Scientifico 4\\Reply code challenge\\Training\\Antivirus\\files\\Output.txt");
		
	}

}
