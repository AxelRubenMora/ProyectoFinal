package doll;

import java.io.Serializable;

public class Acount extends Person implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1599521801223493122L;
	private int numberAcount;
	private String titular;
	private double saldo;
	public Acount() {
		super();
	}
	public Acount(String firstName, String midleName, String firstSourName, String secondSurName) {
		super(firstName,midleName,firstSourName,secondSurName);
		
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
	
	public int getNumberAcount() {
		return numberAcount;
	}
	public void setNumberAcount() {
		int number= (int) Math.floor(Math.random()*100000000);
		this.numberAcount=number;
	}
	
}
