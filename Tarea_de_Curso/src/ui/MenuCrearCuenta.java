package ui;

import doll.Acount;
import java.util.Scanner;
public class MenuCrearCuenta {
	
	Scanner scan= new Scanner(System.in);
	
	public void crear(int pos, Acount[] losp) {
		
		Acount na= new Acount();
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
		System.out.println(na.getNumberAcount());
		System.out.println(na.getTitular());
		losp[pos]=na;
	}
	public void verUsuarios(int tam,Acount []losp) {
		for(int i=0;i>tam;i++) {
			System.out.print(losp[i].getNumberAcount()+""+losp[i].getTitular());
		}
	}

}
