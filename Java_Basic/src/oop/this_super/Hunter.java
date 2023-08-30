package oop.this_super;

public class Hunter extends Player {

	String pet;
	
	Hunter(String name) {
		super(name);
		pet = "멍멍이";
	}
	
	@Override
	void characterInfo() {
		super.characterInfo();
		System.out.println("# 펫 이름: " + pet);
	}

}
