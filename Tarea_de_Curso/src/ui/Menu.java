package ui;
import java.util.Scanner;

import doll.Acount;


public class Menu {
	public int pos=0;
	Acount [] losp=new Acount[1000];
	MenuCrearCuenta lss =new MenuCrearCuenta();
	String opc;
	int numericOpc=0;
	Scanner scan= new Scanner(System.in);
	public void mop() {
		//Con esta funcion mostramos las opciones que dispone el usuario 
		System.out.println("1. Ingresar ");
		System.out.println("2. Crear nueva cuenta");
		System.out.println("3. Salir");
	}
	
	public void take_actions() {
		mop();
		opc=scan.nextLine();
		
		try {
			String kk=opc;
			numericOpc=Integer.parseInt(kk);
		}
		catch(Exception ex) {
			System.out.println("Opcion invalida porfavor digite una opcion valida:\n");
			take_actions();
		}
		switch (numericOpc) {
		case 1:
			System.out.println("Agregar acciones para ingresar\n");
			lss.verUsuarios(this.pos, this.losp);
			take_actions();
			break;
		case 2:
			this.pos++;
			lss.crear(pos, losp);
			take_actions();
			break;
		case 3:
			System.exit(0);
		default:
			System.out.println("Opcion invalida\nPorfavor ingrese una opcion valida\n");
			take_actions();
			break;
		}
	}
		
}
