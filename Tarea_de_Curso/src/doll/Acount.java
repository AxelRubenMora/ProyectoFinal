package doll;

import java.io.Serializable;

public class Acount extends Person implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1599521801223493122L;
	private String numberAcount;
	private String titular;
	private double saldo;
	public Acount() {
		super();
	}
	
	public void setTitular() {
		this.titular=this.firstName+" "+this.midleName+" "+this.firstSourName+" "+this.SecondSurName;
	}
	public String getTitular() {
		return titular;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public String getNumberAcount() {
		return numberAcount;
	}
	public void setNumberAcount() {
		//Inplementar metodos para generar numeros aleatorios e implenentar comparar para que no se repitan
		int number= (int) Math.floor(Math.random()*100000000);
		numberAcount=String.valueOf(number);
	}
	
}
