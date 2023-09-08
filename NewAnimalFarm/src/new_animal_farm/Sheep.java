package new_animal_farm;

public class Sheep extends Animal{

	String type = "sheep";
	
	public Sheep(int age, String gender) {
		super(age, gender);
	}
	
	@Override
	void obtainProduct() {
		System.out.println("Kuzu ürün üretti.");
		//currentAnimal listesindeki hayvanlara uygulanacak.
		//yemi azaltıp parayı arttıracak.
		//button'a bağlı olacak.
	}

	@Override
	int getProductTime() {
		// TODO Auto-generated method stub
		return 5000;
	}

	@Override
	String getType() {
		// TODO Auto-generated method stub
		return type;
	}

}
