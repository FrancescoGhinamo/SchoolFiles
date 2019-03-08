package antivirus;

import java.util.HashSet;
import java.util.Set;

public class FileTester {

	private String[] fileSet;
	private int virusLength;

	public FileTester(String[] fileSet, int virusLength) {
		super();
		this.fileSet = fileSet;
		this.virusLength = virusLength;
	}

	public int[] virusStartIndexes() {
		int[] indexes = new int[4];
		String virus = findVirus();
		int n = 0;
		indexes[n] = fileSet[n].indexOf(virus);
		n++;
		indexes[n] = fileSet[n].indexOf(virus);
		n++;
		indexes[n] = fileSet[n].indexOf(virus);
		n++;
		indexes[n] = fileSet[n].indexOf(virus);
		n++;
		return indexes;
	}

	public String[] getFileSet() {
		return fileSet;
	}

	public String findVirus() {
		String virus = "";
		String[] _vir = new String[6];

		_vir[0] = findCommonSubstring(fileSet[0], fileSet[1], virusLength);
		_vir[1] = findCommonSubstring(fileSet[0], fileSet[2], virusLength);
		_vir[2] = findCommonSubstring(fileSet[0], fileSet[3], virusLength);
		_vir[3] = findCommonSubstring(fileSet[1], fileSet[2], virusLength);
		_vir[4] = findCommonSubstring(fileSet[1], fileSet[3], virusLength);
		_vir[5] = findCommonSubstring(fileSet[2], fileSet[3], virusLength);
		
		int occ = 0;
		for(String _v: _vir) {
			for(String f: fileSet) {
				if(f.contains(_v)) {
					occ++;
				}
			}
			if(occ == 4) {
				virus = _v;
				break;
			}
			occ = 0;
		}



		return virus;
	}

	public static Set<String> longestCommonSubstrings(String s, String t) {
		int[][] table = new int[s.length()][t.length()];
		int longest = 0;
		Set<String> result = new HashSet<>();

		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < t.length(); j++) {
				if (s.charAt(i) != t.charAt(j)) {
					continue;
				}

				table[i][j] = (i == 0 || j == 0) ? 1
						: 1 + table[i - 1][j - 1];
				if (table[i][j] > longest) {
					longest = table[i][j];
					result.clear();
				}
				if (table[i][j] == longest) {
					result.add(s.substring(i - longest + 1, i + 1));
				}
			}
		}
		return result;
	}
	public String findCommonSubstring(String X, String Y) {
		int m = X.length();
		int n = Y.length();
		// Create a table to store lengths of longest common 
		// suffixes of substrings.   Note that LCSuff[i][j] 
		// contains length of longest common suffix of X[0..i-1] 
		// and Y[0..j-1]. The first row and first column entries 
		// have no logical meaning, they are used only for 
		// simplicity of program 
		int[][] LCSuff = new int[m + 1][n + 1]; 

		// To store length of the longest common substring 
		int len = 0; 

		// To store the index of the cell which contains the 
		// maximum value. This cell's index helps in building 
		// up the longest common substring from right to left. 
		int row = 0, col = 0; 

		/* Following steps build LCSuff[m+1][n+1] in bottom 
           up fashion. */
		for (int i = 0; i <= m; i++) { 
			for (int j = 0; j <= n; j++) { 
				if (i == 0 || j == 0) 
					LCSuff[i][j] = 0; 

				else if (X.charAt(i - 1) == Y.charAt(j - 1)) { 
					LCSuff[i][j] = LCSuff[i - 1][j - 1] + 1; 
					if (len < LCSuff[i][j]) { 
						len = LCSuff[i][j]; 
						row = i; 
						col = j; 
					} 
				} 
				else
					LCSuff[i][j] = 0; 
			} 
		} 



		// allocate space for the longest common substring 
		String resultStr = ""; 

		// traverse up diagonally form the (row, col) cell 
		// until LCSuff[row][col] != 0 
		while (LCSuff[row][col] != 0) { 
			resultStr = X.charAt(row - 1) + resultStr; // or Y[col-1] 
			--len; 

			// move diagonally up to previous cell 
			row--; 
			col--; 
		} 

		// required longest common substring 
		return resultStr; 
	} 

	public String findCommonSubstring(String X, String Y, int len) {
		String res = "";

		int lastBIn = 0;

		do {
			if(lastBIn + len <= X.length()) {
				res = X.substring(lastBIn, lastBIn + len);
				lastBIn++;
			}
			else {
				break;
			}
		}
		while(!Y.contains(res));


		return res;
	}

	public int getVirusLength() {
		return virusLength;
	}

}
