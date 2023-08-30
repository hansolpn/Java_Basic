package oop.this_super;

public class Mage extends Player {

	int mana;
	
	Mage(String name) {
		super(name);
		mana = 100;
	}
	
	@Override
	void characterInfo() {
		super.characterInfo();
		System.out.println("# 정신력: " + mana);
	}
}
