package ui;

import doll.Acount;

import java.util.ArrayList;
import java.util.Scanner;
public class AcountForm {
	
	Scanner scan= new Scanner(System.in);
	
	public void crear(ArrayList<Acount>losp) {
		//crea un objeto de tipo acount
		Acount na= new Acount();
		//introducimos los datos de la cuenta
		System.out.println("Porfavor Digite Su primer nombre: ");
		na.setFirstName(scan.nextLine());
		System.out.println("Porfavor Digite Su Segundo nombre: ");
		na.setMidleName(scan.nextLine());
		System.out.println("Porfavor Digite Su primer apellido: ");
		na.setFirstSourName(scan.nextLine());
		System.out.println("Porfavor Digite Su Segundo apellido: ");
		na.setSecondSurName(scan.nextLine());
		na.setTitular();
		na.setNumberAcount();
		losp.add(na);
	}
	public void verUsuarios(ArrayList<Acount>losp) {
		//bucle for que recorre los elementos del arreglo
		for(Acount i : losp) {
			//imprime el numero de cuenta + el titular de la cuenta
			System.out.println("N° Cuenta: "+i.getNumberAcount()+"\nTitular: "+i.getTitular());
		}
	}

}