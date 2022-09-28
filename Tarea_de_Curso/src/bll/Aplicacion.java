package bll;
import java.util.ArrayList;
import java.util.Scanner;

import doll.Acount;
import ui.AcountForm;


public class Aplicacion {
	String decora="********************************";
	String decora1="================================";
	ArrayList<Acount> losp=new ArrayList<Acount>();
	AcountForm lss =new AcountForm();
	//Variable que almacena la opcion digitada por el usuario
	String opc;
	//Variable que almacena el valor numero de la opcion digitada por el usuario
	int numericOpc=0;
	Scanner scan= new Scanner(System.in);
	public void mop() {
		//Con esta funcion mostramos las opciones que dispone el usuario
		System.out.println("Porfavor Digite: ");
		System.out.println(decora);
		System.out.println("1. Mostrar Cuentas Existentes ");
		System.out.println("2. Crear nueva cuenta");
		System.out.println("3. Eliminar Cuenta");
		System.out.println("4. Editar Titular");
		System.out.println("5. Ingresar");
		System.out.println("6. Salir");
		System.out.println(decora);
	}
	
	public void take_actions() {
		mop();
		opc=scan.nextLine();
		System.out.println(decora);
		
		try {
			
			numericOpc=Integer.parseInt(opc);
		}
		catch(Exception ex) {
			System.out.println("Opcion invalida porfavor digite una opcion valida:\n");
			take_actions();
		}
		switch (numericOpc) {
		case 1:
			System.out.println(decora1);
			System.out.println("Agregar acciones para ingresar\n");
			lss.verUsuarios(this.losp);
			System.out.println(decora1);
			take_actions();
			break;
		case 2:
			System.out.println(decora1);
			lss.crear(losp);
			System.out.println(decora1);
			take_actions();
			break;
		case 3:
			System.out.println(decora1);
			System.out.println("Funciones de eliminar\n");
			lss.eliminar(losp);
			System.out.println(decora1);
			take_actions();
			break;
		case 4:
			System.out.println(decora1);
			lss.editar(losp);
			System.out.println(decora1);
			take_actions();
			break;
		case 5:
			System.out.println("Ingresar");
			take_actions();
			break;
		case 6:
			System.exit(0);
		default:
			System.out.println("Opcion invalida\nPorfavor ingrese una opcion valida\n");
			take_actions();
			break;
		}
	}
		
}