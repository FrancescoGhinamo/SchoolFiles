package interfaccia;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileOperationsImpl implements IFileOperations {

	@Override
	public void salvaMultipli(int num, String percorso) {
		FileWriter fW = null;
		try {
			fW = new FileWriter(percorso);
			for(int i = 1; i <= 10; i++) {
				fW.write(String.valueOf(num * i));
				fW.write("\r\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(fW != null) {
				try {
					fW.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally {
					try {
						fW.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}

	}

	@Override
	public void serializzaValori(ArrayList<Double> listaValori, String percorso) {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(percorso));
			oos.writeObject(listaValori);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(oos != null) {
				try {
					oos.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally {
					try {
						oos.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}

	}

	@Override
	public ArrayList<Double> deserializzaValori(String percorso) {
		ArrayList<Double> ris = null;
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(percorso));
			ris = (ArrayList<Double>) ois.readObject();

		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(ois != null) {

				try {
					ois.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return ris;
	}



	public static void main(String[] args) {
		FileOperationsImpl i = new FileOperationsImpl();
		i.salvaMultipli(5, "C:\\Users\\franc\\OneDrive\\Documents\\Test.txt");
		ArrayList<Double> test = new ArrayList<Double>();
		test.add(2342D);
		test.add(3123D);
		i.serializzaValori(test, "C:\\Users\\franc\\OneDrive\\Documents\\Ser.dat");
		ArrayList<Double> ris = i.deserializzaValori("C:\\Users\\franc\\OneDrive\\Documents\\Ser.dat");

	}

}
