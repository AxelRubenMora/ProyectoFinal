package bll;

import java.util.Scanner;

public class Validaciones {
	private Scanner scan;
	
	public Validaciones(Scanner scan) {
		super();
		this.scan = scan;
	}
	public int validarInt(String opc) {
		int numericOpc=0;
		
		try {
			numericOpc=Integer.parseInt(opc);
		}
		catch(Exception ex) {
			System.out.println("opcion Invalida porfavor digite un carcter alfanumerico");
			validarInt(this.scan.next());	
		}
		
		return numericOpc;
	}
	public double validarDou(String opc) {
		double numericOpc = 0;
		try {
			numericOpc=Double.parseDouble(opc);
		}
		catch(Exception ex) {
		}
		return numericOpc;
	}

}