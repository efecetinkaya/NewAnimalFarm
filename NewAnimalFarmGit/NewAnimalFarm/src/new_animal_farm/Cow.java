package new_animal_farm;

public class Cow extends Animal{

	String type = "Cow";
	
	public Cow(int age, String gender) {
		super(age, gender);
	}
	
	@Override
	void obtainProduct() {
		System.out.println("İnek ürün üretti.");
		//currentAnimal listesindeki hayvanlara uygulanacak.
		//yemi azaltıp parayı arttıracak.
		//button'a bağlı olacak.
	}

	@Override
	int getProductTime() {
		// TODO Auto-generated method stub
		return 7000;
	}
	@Override
	String getType() {
		// TODO Auto-generated method stub
		return type;
	}
}
