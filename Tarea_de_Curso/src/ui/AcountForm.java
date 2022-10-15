package ui;

import doll.Acount;
import bll.Validaciones;
import java.util.List;
import java.util.Scanner;
public class AcountForm {
	private List<Acount>listaDeCuentas;
	private Scanner scan;
	private Acount cuenta;
	private Validaciones val=new Validaciones();
	public AcountForm(List<Acount> listaDeCuentas) {
		super();
		this.listaDeCuentas = listaDeCuentas;
	}
	public AcountForm(Scanner scan) {
		super();
		this.scan=scan;
	}
	public AcountForm(Acount cuenta) {
		super();
		this.cuenta=cuenta;
	}
	
	public Acount crearCuenta() {
		//crea un objeto de tipo acount
		Acount cuenta= new Acount();
		//introducimos los datos de la cuenta
		System.out.println("Porfavor Digite Su primer nombre: ");
		cuenta.setFirstName(scan.nextLine());
		System.out.println("Porfavor Digite Su Segundo nombre: ");
		cuenta.setMidleName(scan.nextLine());
		System.out.println("Porfavor Digite Su primer apellido: ");
		cuenta.setFirstSourName(scan.nextLine());
		System.out.println("Porfavor Digite Su Segundo apellido: ");
		cuenta.setSecondSurName(scan.nextLine());
		cuenta.setTitular();
		cuenta.setNumberAcount();
		return cuenta;
	}
	
	public void vercuenta() {
		System.out.printf("Titular: %s",this.cuenta.getTitular());
		System.out.printf("No. ceunta: %d",this.cuenta.getNumberAcount());
	}
	
	public void verUsuarios() {
		//bucle for que recorre los elementos del arreglo
		try {
			System.out.println("i|\ttitular\t\t|#Cuenta");
			for(int i=0;i<listaDeCuentas.size();i++) {
				//imprime el numero de cuenta + el titular de la cuenta
				System.out.printf("%d |%s |%d\n",i+1,listaDeCuentas.get(i).getTitular(),listaDeCuentas.get(i).getNumberAcount());
				System.out.println("\n");
			}
		}
		catch(Exception e) {
			
		}
	}
	 
	
	public void modificarSueldo() {
		System.out.println("Digite la cantidad que desea ingresar");
		double s=val.validarDou() ;
		
	}
	
}

