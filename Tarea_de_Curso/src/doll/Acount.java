package doll;

public class Acount {
	private String numberAcount;
	private String firstName;
	private String midleName;
	private String firstSourName;
	private String SecondSurName;
	private String titular;
	private double saldo;
	public Acount() {
		super();
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
	public void setTitular() {
		titular =firstName+" "+midleName+" "+firstSourName+" "+SecondSurName;
	}
	public String getNumberAcount() {
		return numberAcount;
	}
	public void setNumberAcount() {
		//Inplementar metodos para generar numeros aleatorios e implenentar comparar para que no se repitan
		int number= (int) Math.floor(Math.random()*100000000);
		numberAcount=String.valueOf(number);
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMidleName() {
		return midleName;
	}
	public void setMidleName(String midleName) {
		this.midleName = midleName;
	}
	public String getFirstSourName() {
		return firstSourName;
	}
	public void setFirstSourName(String firstSourName) {
		this.firstSourName = firstSourName;
	}
	public String getSecondSurName() {
		return SecondSurName;
	}
	public void setSecondSurName(String secondSurName) {
		SecondSurName = secondSurName;
	}
	
	
}