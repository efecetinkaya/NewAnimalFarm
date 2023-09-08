package new_animal_farm;

public abstract class Animal {
	
	String type;
	int age;
	String gender;

	public Animal(int age, String gender) {
		this.age = age;
		this.gender = gender;
	}
	
	 abstract String getType();
	

	// int productTime;
	// ya direkt variable'ı ya metodu

	abstract int getProductTime();
	// get methodu kaldırılıp doğrudan değere ulaşılabilir.
	// product time'ın obtainProduce'un bağlantısı yok.

	abstract void obtainProduct();

}
