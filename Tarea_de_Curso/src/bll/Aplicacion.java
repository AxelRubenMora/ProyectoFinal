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
	private String dataB;
	public Aplicacion() {
		scan= new Scanner(System.in);
		listCuentas =new ArrayList<Acount>();
		val=new Validaciones();
	}
	private String decora="********************************";
	
	private String decora1="================================";
	
	public void mostrarOpciones() {
		//Con esta funcion mostramos las opciones que dispone el usuario
		System.out.println("Porfavor Digite: ");
		System.out.println(decora);
		System.out.println("1. Abrir Base de datos ");
		System.out.println("2. Crear Nueva Base de datos");
		System.out.println("3. Salir");
		System.out.println(decora);
	}
	public void mostrarOpciones2() {
		System.out.println();
		System.out.println("1. Agregar nueva cuenta");
		System.out.println("2. Eliminar Cuenta");
		System.out.println("3. Editar Titular");
		System.out.println("4. Guardar Base de Datos");
		System.out.println("5. Regresar");
	}
	public void take_actions() {
		int numericOpc=0;
		mostrarOpciones();
		
		numericOpc=val.validarInt();
		switch (numericOpc) {
		case 1:
			System.out.println(decora1);
			open();
			System.out.println(decora1);
			takeActions2();
			break;
		case 2:
			listCuentas =new ArrayList<Acount>();
			AcountDal ldd= new AcountDal();
			System.out.println(decora1);
			System.out.println("Porfavor indica el nombre de la nueva base de Datos ");
			dataB=scan.nextLine();
			ldd.setFileName(dataB);
			add();
			ldd.setListCuentas(listCuentas);
			ldd.saveList();
			System.out.println(decora1);
			
			takeActions2();
			break;
		case 3:
			System.exit(0);
		default:
			System.out.println("Opcion invalida\nPorfavor ingrese una opcion valida\n");
			take_actions();
			break;
		}
	}
	
	
	public void takeActions2() {
		int numericOpc=0;
		System.out.printf("que opcion desea realizar en la base de datos: %s",dataB);
		mostrarOpciones2();
		
		numericOpc=val.validarInt();
		switch (numericOpc) {
		case 1:
			add();
			takeActions2();
			break;
		case 2:
			System.out.println(decora1);
			System.out.println("Funciones de eliminar\n");
			eliminar();
			System.out.println(decora1);
			takeActions2();
			break;
		case 3:
			System.out.println(decora1);
			editar();
			System.out.println(decora1);
			takeActions2();
			break;
		case 4:
			save();
			take_actions();
			break;
		case 5:
			take_actions();
			break;
		default:
			System.out.println("Numero fuera de rango");
			takeActions2();
		}
	}
	
	public void save() {
		if(listCuentas==null) {
			System.out.println("Porfavor primero cree o acceda a una base de datos");
		}
		else {
			AcountDal ldd= new AcountDal();
			ldd.setFileName(dataB);
			ldd.setListCuentas(listCuentas);
			ldd.saveList();
			listCuentas=new ArrayList<Acount>();
			System.out.println("Base de datos Guarda Exitosamente");
		}
	}
	public void open() {
		System.out.println(decora1);
		System.out.println("Indica el nombre de la BaseDeDatos");
		System.out.println(decora1);
		AcountDal ldd = new AcountDal();
		String ddataB=scan.nextLine();
		ldd.setFileName(ddataB);
		listCuentas=ldd.openList();
		if(listCuentas!=null) {
			dataB=ddataB;
		}
		System.out.println(decora1);
		AcountForm lss= new AcountForm(listCuentas);
		lss.verUsuarios();
		
		
	}
	
	public void add() {
			if(listCuentas==null ) {
				System.out.println("Pofavor primero abra o cree una base de datos");
			}
			else {
				AcountForm ldd=new AcountForm(scan);
				listCuentas.add(ldd.crearCuenta());
				System.out.println("Cuenta a??adida exitosamente");
			}
			
			
	}
	
	public void eliminar() {
		if(listCuentas==null ) {
			System.out.println("Pofavor primero abra o cree una base de datos");
		}
		else {
			if(listCuentas.size()==0) {
				System.out.println("No hay usuarios a eliminar");
			}
			else {
				AcountForm lss= new AcountForm(listCuentas);
				lss.verUsuarios();
				System.out.println("\nDigite el numero de cuenta de la cuenta que desea eliminar:\n");
				int numelim=val.validarInt();
				try {
					
					//listCuentas.remove(numelim-1);
					for(int i=0;i<listCuentas.size();i++) {
						if(listCuentas.get(i).getNumberAcount()==numelim) {
							listCuentas.remove(i);
						}
						else {
							System.out.println("Dicha Cuenta No existe");
						}
					}
					System.out.println("Cuenta Eliminada");
				}
				catch(Exception e) {
					System.out.println("numero fuera de rango\n");
				}
			}
			
		}
			
		}
	
	public void editar() {
		if(listCuentas==null ) {
			System.out.println("Pofavor primero abra o cree una base de datos");
		}
		else {
			if(listCuentas.size()==0) {
				System.out.println("No hay usuarios a eliminar");
			}
			else {
				int numelim=0;
				AcountForm lss= new AcountForm(listCuentas);
				lss.verUsuarios();
				System.out.println("\nDigite la cuenta que desea:\n");
				numelim=val.validarInt();
				for (int i=0; i<listCuentas.size();i++) {
					if(listCuentas.get(i).getNumberAcount()==numelim) {
						System.out.println("Digite que desea realizar");
						System.out.println("1....editar titular");
						System.out.println("2.....Hacer Deposito");
						System.out.println("3......Hacer retiro");
						int op=val.validarInt();
						
						switch(op) {
						case 1:
							try {
								System.out.println("Digite el primer nombre");
								listCuentas.get(i).setFirstName(scan.next());
								System.out.println("Digite su segundo nombre");
								listCuentas.get(i).setMidleName(scan.next());
								System.out.println("Digite el primer apellido");
								listCuentas.get(i).setFirstSourName(scan.next());
								System.out.println("Digite su segundo apellido");
								listCuentas.get(i).setSecondSurName(scan.next());
								listCuentas.get(i).setTitular();
								
							}
							catch(Exception e) {
								
							}
							break;
						case 2:
							System.out.println("Digite la cantidad a depositar");
							double cant=val.validarDou();
							break;
						case 3:
							break;
						default:
							break;
						}
					}
					else {
						System.out.println("numero fuera de rango\n");
					}
				}
				
			}
		}
		}
	
	
	
}
