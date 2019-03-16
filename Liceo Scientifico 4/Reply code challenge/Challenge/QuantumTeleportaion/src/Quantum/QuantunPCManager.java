package Quantum;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;

public class QuantunPCManager {

	private static final long VAL = 100003;
	private JFileChooser jrerifsjfdsj,APREILPICCIONE;

	private ArrayList<QuantumPC> pcs;


	public void initPC() {
		jrerifsjfdsj = new JFileChooser();
		jrerifsjfdsj.setDialogTitle("TI DEVI SPAVENTAREEEEEEE");
		if(jrerifsjfdsj.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			BufferedReader buffR = null;
			try {
				buffR = new BufferedReader(new FileReader(jrerifsjfdsj.getSelectedFile().getAbsolutePath()));

				int testCases = Integer.parseInt(buffR.readLine());
				for(int nT = 0; nT < testCases; nT++) {
					buffR.readLine();
					String qCoord[] = buffR.readLine().split(" ");
					int xQ = Integer.parseInt(qCoord[0]);
					int yQ = Integer.parseInt(qCoord[1]);

					Qubit q = new Qubit(xQ, yQ);

					int nPort = Integer.parseInt(buffR.readLine());
					ArrayList<Portal> portals = new ArrayList<Portal>();
					for(int nPo = 0; nPo < nPort; nPo++) {
						String[] pCoo = buffR.readLine().split(" ");
						portals.add(new Portal(Integer.parseInt(pCoo[0]), Integer.parseInt(pCoo[1]), Integer.parseInt(pCoo[2]), Integer.parseInt(pCoo[3])));
					}
					pcs.add(new QuantumPC(portals, q));


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

	}

	public void run() {
		for(QuantumPC p: pcs) {
			p.runPC();
		}
	}


	public QuantunPCManager() {
		super();
		this.pcs = new ArrayList<QuantumPC>();

	}

	public void saveOutput() {
		APREILPICCIONE = new JFileChooser();
		APREILPICCIONE.setDialogTitle("POTENTISSIMO");
		if(APREILPICCIONE.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			FileWriter fW = null;
			try {
				fW = new FileWriter(APREILPICCIONE.getSelectedFile().getAbsolutePath());

				int n = 1;
				for(QuantumPC p: pcs) {
					fW.write("Case #"+n+": "+Math.floorMod(p.getMovements(), VAL));
					fW.write("\r\n");
					n++;
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
	}

	public static void main(String[] args) {
		QuantunPCManager pc = new QuantunPCManager();
		pc.initPC();
		pc.run();
		pc.saveOutput();


	}

}
