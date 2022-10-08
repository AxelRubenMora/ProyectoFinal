package dal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import doll.Acount;

public class AcountDal {
	private Acount cuenta;
	private List<Acount>ListCuentas;
	private String filePath;
	private String fileName;
	public AcountDal() {
		super();
	}
	public Acount getCuenta() {
		return cuenta;
	}
	public void setCuenta(Acount cuenta) {
		this.cuenta = cuenta;
	}
	
	public List<Acount> getListCuentas() {
		return ListCuentas;
	}
	public void setListCuentas(List<Acount> ListCuentas) {
		this.ListCuentas = ListCuentas;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
	public void saveList() {
		File file =new File(filePath+"\\"+fileName);
		try {
			ObjectOutputStream os= new ObjectOutputStream(new FileOutputStream(file));
			os.writeObject(ListCuentas);
			os.flush();
			os.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
public List<Acount> openList() {
		
		try {
			File file = new File(filePath);
			ObjectInputStream ois= new ObjectInputStream( new FileInputStream(file));
			List<Acount> ListCuentas = (List<Acount>)ois.readObject();
			ois.close();
			return ListCuentas;
			
		} catch (FileNotFoundException e) {
			System.out.println("Lamentamos informar que dicha cuenta no existe");
			
		} catch (IOException e) {
			System.out.println("error");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("error2");
		}
		return null;
	}
}
