package main;

import bll.Aplicacion;

public class Main {
	public static void main(String[] args) {
		Aplicacion nenus= new Aplicacion();
		System.out.print("Bienvenido al Banco Java una invencion de:\nAxel y Angel\nPorfavor Digite la opereacion que desee efectuar\n");
		nenus.take_actions();
	}

}
