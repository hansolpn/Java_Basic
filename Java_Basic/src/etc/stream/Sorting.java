package etc.stream;

import java.util.Comparator;
import java.util.stream.Collectors;

import static etc.stream.Menu.menuList;

public class Sorting {
    public static void main(String[] args) {
        //음식목록 중 칼로리가 낮은 순으로 정렬 (오름차 정렬)
        menuList.stream()
                .sorted(Comparator.comparing(Dish::getCalories))
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("===================================");
        // 칼로리로 내림차 정렬 (높은 순)
        menuList.stream()
                .sorted(Comparator.comparing(Dish::getCalories).reversed())
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("===================================");
        // 500칼로리보다 작은 요리 중에 top3 필터링
        menuList.stream()
                .filter(dish -> dish.getCalories() < 500) // 칼로리가 500 미만 거르기
                .sorted(Comparator.comparing(Dish::getCalories).reversed()) // 걸린 요소 정렬 (높은순)
                .limit(3) // 정렬된 요소 중 3개만 가져오기
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }
}
