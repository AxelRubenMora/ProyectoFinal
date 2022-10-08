package bll;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dal.AcountDal;
import doll.Acount;
import ui.AcountForm;


public class Aplicacion {
	private List<Acount> listCuentas;
	private Scanner scan;
	private Validaciones val;
	public Aplicacion() {
		scan= new Scanner(System.in);
		listCuentas =new ArrayList<Acount>();
		val=new Validaciones(scan);
	}
	private String decora="********************************";
	private String decora1="================================";
	
	//Variable que almacena la opcion digitada por el usuario
	//Variable que almacena el valor numero de la opcion digitada por el usuario
	int numericOpc=0;
	
	public void mostrarOpciones() {
		//Con esta funcion mostramos las opciones que dispone el usuario
		System.out.println("Porfavor Digite: ");
		System.out.println(decora);
		System.out.println("1. Mostrar Base de datos ");
		System.out.println("2. Crear nueva cuenta");
		System.out.println("3. Eliminar Cuenta");
		System.out.println("4. Editar Titular");
		System.out.println("5. Guardar Base de Datos");
		System.out.println("6. Salir");
		System.out.println(decora);
	}
	
	public void take_actions() {
		String opc;
		mostrarOpciones();
		System.out.println();
		opc=scan.nextLine();
		
		numericOpc=val.validarInt(opc);
		switch (numericOpc) {
		case 1:
			System.out.println(decora1);
			open();
			System.out.println(decora1);
			take_actions();
			break;
		case 2:
			add();
			take_actions();
			break;
		case 3:
			System.out.println(decora1);
			System.out.println("Funciones de eliminar\n");
			eliminar();
			System.out.println(decora1);
			take_actions();
			break;
		case 4:
			System.out.println(decora1);
			editar();
			System.out.println(decora1);
			take_actions();
			break;
		case 5:
			save();
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
	public void save() {
		AcountDal ldd= new AcountDal();
		System.out.println(decora1);
		System.out.println("Porfavor indica la dircion del archivo: ");
		ldd.setFilePath(scan.nextLine());

		System.out.println(decora1);
		System.out.println("Porfavor indica el nombre del archivo: ");
		ldd.setFileName(scan.nextLine());
		System.out.println(decora1);
		
		ldd.setListCuentas(listCuentas);
		ldd.saveList();
		listCuentas=new ArrayList<Acount>();
	}
	public void open() {
		System.out.println(decora1);
		System.out.println("Indica la ruta del archvivo de la cuenta");
		System.out.println(decora1);
		String filePath = scan.next();
		AcountDal ldd = new AcountDal();
		ldd.setFilePath(filePath);
		listCuentas=ldd.openList();
		System.out.println(decora1);
		AcountForm lss= new AcountForm(listCuentas);
		lss.verUsuarios();
		
	}
	
	public void add() {
		AcountForm ldd=new AcountForm(scan);
		listCuentas.add(ldd.crearCuenta());
		
	}
	
	public void eliminar() {
		int num=0;
		for(Acount i : listCuentas) {
			System.out.println(num+"). "+i.getNumberAcount()+" "+i.getTitular());
			num++;
			}
		System.out.println("\nDigite el numero de cuenta de la cuenta que desea eliminar:\n");
		int numelim=scan.nextInt();
		try {
			listCuentas.remove(numelim);
		}
		catch(Exception e) {
			System.out.println("numero fuera de rango\n");
		}
			
		}
	
	public void editar() {
		int num=0;
		int numelim=0;
		String opc;
		for(Acount i : listCuentas) {
			System.out.println(num+"). "+i.getNumberAcount()+" "+i.getTitular());
			num++;
			}
		System.out.println("\nDigite la cuenta que desea:\n");
		opc=scan.next();
		try {
			numelim=val.validarInt(opc);
			scan.nextLine();
		}
		catch(Exception e){
			editar();
		}
		try {
			
			System.out.println("Porfavor Digite Su primer nombre: ");
			listCuentas.get(numelim).setFirstName(scan.nextLine());
			System.out.println("Porfavor Digite Su Segundo nombre: ");
			listCuentas.get(numelim).setMidleName(scan.nextLine());
			System.out.println("Porfavor Digite Su primer apellido: ");
			listCuentas.get(numelim).setFirstSourName(scan.nextLine());
			System.out.println("Porfavor Digite Su Segundo apellido: ");
			listCuentas.get(numelim).setSecondSurName(scan.nextLine());
			listCuentas.get(numelim).setTitular();
		}
		catch(Exception e) {
			System.out.println("numero fuera de rango\n");
		}
		
		}
	
	
	
}
