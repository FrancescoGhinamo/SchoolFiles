package capitolo3.Problema43;

public class MoltiplicaMatrici {

	public static float[][] moltiplica(float[][] mat1, float[][] mat2) {
		float[][] ris = new float[2][2];
		
		for(int r = 0; r < 2; r++) {
			for(int c = 0; c < 2; c++) {
				int _val = 0;
				for(int _i = 0; _i < 2; _i++)
					_val += mat1[c][_i] * mat2[_i][c];
				ris[r][c] = _val;
			}
		}
		
		return ris;
	}
	
	public static void main(String[] args) {
		float[][] mat1 = new float[3][2];
		float[][] mat2 = new float[2][3];
		
		for(int c = 0; c < 3; c++) {
			for(int i = 0; i < 2; i++) {
				mat1[c][i] = (float) (Math.random() * 10);
				mat2[i][c] = (float) (Math.random() * 10);
			}
		}
		
		float[][] ris = moltiplica(mat1, mat2);
		
		for(int r = 0; r < 2; r++) {
			for(int c = 0; c < 2; c++) {
				System.out.print(ris[r][c]+" ");
			}
			System.out.println("");
		}
		
 		

	}

}
