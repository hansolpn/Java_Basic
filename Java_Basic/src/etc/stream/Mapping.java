package etc.stream;

import java.util.List;
import java.util.stream.Collectors;

import static etc.stream.Menu.menuList;

public class Mapping {
    // 이름과 타입만 가진 클래스 설계
    private static class DishNameType {
        private String name;
        private Dish.Type type;

        public DishNameType(Dish dish) {
            this.name = dish.getName();
            this.type = dish.getType();
        }

        @Override
        public String toString() {
            return "DishNameType{" +
                    "name='" + name + '\'' +
                    ", type=" + type +
                    '}';
        }
    }
    // 이름과 칼로리만 가진 클래스를 설계
    private static class simpleDish {
        private String name;
        private int calrories;

        public simpleDish(String name, int calrories) {
            this.name = name;
            this.calrories = calrories;
        }

        public simpleDish(Dish dish) {
            this.name = dish.getName();
            this.calrories = dish.getCalories();
        }

        @Override
        public String toString() {
            return "simpleDish{" +
                    "name='" + name + '\'' +
                    ", calrories=" + calrories +
                    '}';
        }
    }
    public static void main(String[] args) {
        // stream의 map: 컬렉션 (리스트, 셋, 맵...)에서
        // 원하는 정보만 추출하여 새로운 컬렉션으로 반환해 줌
        List<String> nameList = menuList.stream()
                .map(dish -> dish.getName())
                .collect(Collectors.toList());

        System.out.println("nameList = " + nameList);
        
        /*
        요리 목록에서 매뉴 이름과 칼로리를 추출하고 싶다
         */
        menuList.stream()
                .map(dish -> new simpleDish(dish))
                .collect(Collectors.toList())
                .forEach(d-> System.out.println(d));

        System.out.println("=============================================");
        /*
            메뉴 목록에서 칼로리가 500칼로리보다 큰
            음식들을 필터링한 다음에 음식의 이름과 타입만 추출해서
            출력해 주세요
         */
        menuList.stream()
                .filter(dish -> dish.getCalories() > 500)
                .map(dish -> new DishNameType(dish))
                .collect(Collectors.toList())
                .forEach(ds -> System.out.println("ds = " + ds));
    }
}
