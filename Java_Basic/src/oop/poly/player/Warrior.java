package oop.poly.player;

public class Warrior extends Player {

	int rage;

	Warrior(String name) {
		super(name);
		rage = 60;
	}

	/*
    - 전사의 고유 기능인 rush 메서드를 작성합니다.

    - rush의 대상은 모든 직업(단일타겟)들 입니다.

    - 만약 rush의 대상이 전사라면 10의 피해를 받고,
     마법사라면 20의 피해를 받고, 사냥꾼이라면 15의 피해를 받습니다.

    - 서로 다른 데미지를 instanceof를 사용하여 구분해서 적용해 주세요.

    - 남은 체력도 출력해 주세요.

    - main에서 객체를 생성한 후 호출하셔서 잘 적용됐는지 확인해 주세요.
	 */
	public void rush(Player target) {
		if (this == target) {
			System.out.println("스스로는 때릴수 없습니다");
		}

		System.out.println(this.name + "님의 돌진!!!");

		int damage = 0;
		if (target instanceof Warrior) {
			damage = 10;
		}
		else if (target instanceof Mage) {
			damage = 20;
		}
		else if (target instanceof Hunter) {
			damage = 15;
		}

		target.hp -= damage;
		System.out.printf("%s님이 %d의 피해를 입었습니다. (남은 체력: %d)\n",
				target.name, damage, target.hp);
	}

	@Override
	void characterInfo() {
		super.characterInfo();
		System.out.println("# 분노: " + rage);
	}

}
