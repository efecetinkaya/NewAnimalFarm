package new_animal_farm;

public class Goat extends Animal{

	String type = "goat";
	
	public Goat(int age, String gender) {
		super(age, gender);
	}
	
	
	
	@Override
	void obtainProduct() {
		System.out.println("Keçi ürün üretti.");
		//currentAnimal listesindeki hayvanlara uygulanacak.
		//yemi azaltıp parayı arttıracak.
		//button'a bağlı olacak.
	}

	@Override
	int getProductTime() {
		// TODO Auto-generated method stub
		return 10000;
	}
	@Override
	String getType() {
		// TODO Auto-generated method stub
		return type;
	}
}
