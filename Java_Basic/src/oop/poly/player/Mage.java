package oop.poly.player;

public class Mage extends Player {

	int mana;
	
	Mage(String name) {
		super(name);
		mana = 100;
	}
	
	public void blizzard(Player[] targets) {

		System.out.println(this.name + "님이 눈보라 시전!!!");
		this.mana -= 30;
		System.out.println("30의 마나가 소모됩니다. 남은 정신력: " + this.mana);
		System.out.println("--------------------");
		for (Player target : targets) {
			if (this == target) {
				System.out.println("스스로는 때릴수 없습니다");
				continue;
			}
			int damage = (int)(Math.random() * 6) + 10;
			target.hp -= damage;
			System.out.printf("%s님이 %d의 피해를 입었습니다. (남은 체력: %d)\n",
					target.name, damage, target.hp);
		}
		
	}
	
	@Override
	void characterInfo() {
		super.characterInfo();
		System.out.println("# 정신력: " + mana);
	}
}
