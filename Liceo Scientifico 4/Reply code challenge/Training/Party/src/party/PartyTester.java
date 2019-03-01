package party;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PartyTester {
	
	private String inputFile;
	private String outputFile;
	
	private ArrayList<Party> parties;
	
	
	
	public PartyTester(String inputFile, String outputFile) {
		super();
		this.inputFile = inputFile;
		this.outputFile = outputFile;
		this.parties = new ArrayList<Party>();
	}

	public void initPartiesData() {
		BufferedReader buffR = null;
		try {
			FileReader fr = new FileReader(inputFile);
			buffR = new BufferedReader(fr);
			
			String firstLine = buffR.readLine();
			int testsNumber = Integer.parseInt(firstLine);
			for(int n = 0; n < testsNumber; n++) {
				String nrFriendsLine = buffR.readLine();
				int nrFriends = Integer.parseInt(nrFriendsLine);
				String friendValues = buffR.readLine();
				String[] friends = friendValues.split(" ");
				ArrayList<Friend> invFriends = new ArrayList<Friend>();
				for(int nF = 0; nF < nrFriends; nF++) {
					
					invFriends.add(new Friend(Integer.parseInt(friends[nF])));
				}
				parties.add(new Party(invFriends));
			}
			
		} catch (IOException e) {
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
	
	public String prepareOutputString() {
		String res = "";
		int count = 1;
		for(Party p: parties) {
			res += "Case #" + count + ": ";
			res += p.calcMaxBeauty();
			res += "\r\n";
			count++;
		}
		return res;
	}
	
	public void makeOuputFile(String str) {
		FileWriter fw = null;
		try {
			fw = new FileWriter(outputFile);
			fw.write(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
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
	
	public static void main(String[] args) {
		PartyTester pt = new PartyTester("F:\\School Files\\SchoolFiles\\Liceo Scientifico 4\\Reply code challenge\\Training\\Party\\files\\input-party-0d22.txt", "F:\\School Files\\SchoolFiles\\Liceo Scientifico 4\\Reply code challenge\\Training\\Party\\files\\output-party-0d22.txt");
		pt.initPartiesData();
		pt.makeOuputFile(pt.prepareOutputString());
	}
	

}
