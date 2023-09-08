package new_animal_farm;

public class Chicken extends Animal{

	String type = "Chicken";
	
	public Chicken(int age, String gender) {
		super(age, gender);
	}
	
	@Override
	void obtainProduct() {
		System.out.println("Tavuk ürün üretti.");
		//currentAnimal listesindeki hayvanlara uygulanacak.
		//yemi azaltıp parayı arttıracak.
		//button'a bağlı olacak.
	}

	@Override
	int getProductTime() {
		// TODO Auto-generated method stub
		return 3000;
	}
	@Override
	String getType() {
		// TODO Auto-generated method stub
		return type;
	}
}

