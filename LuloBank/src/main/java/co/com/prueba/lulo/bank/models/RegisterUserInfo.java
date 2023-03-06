package co.com.prueba.lulo.bank.models;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserInfo {
    private String name;
    private double salary;
    private int age;
    private int id;
	public void setName(String i) {
		// TODO Auto-generated method stub
		name=i;
	}
	public void setSalary(int i) {
		// TODO Auto-generated method stub
		salary=i;
	}
	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}
	public void setAge(int i) {
		// TODO Auto-generated method stub
		age=i;
		
	}
}
