package etc.lambda;

import java.util.ArrayList;
import java.util.List;

// 사과를 여러가지 방법으로 필터링 할 수 있게 도와주는 클래스
public class FilterApple {
    /**
     * @solution - try1: 사과 바구니에서 녹색 사과들만 필터링 해보자
     * @problem - 만약에 다른 색깔의 사과를 필터링해야 한다면???
     *            새로운 매서드를 만들어야 함...
     * @param1 basket - 전체 사과가 들어있는 바구니
     * @return - 녹색 사과만 필터링 된 바구니
     */
    public static List<Apple> filterGreenApples(List<Apple> basket) {
        // 녹색 사과만 담을 바구니
        List<Apple> greenBasket = new ArrayList<>();

        for (Apple apple : basket) {
            if (apple.getColor() == Color.GREEN) {
                greenBasket.add(apple);
            }
        }

        return greenBasket;
    }

    /**
     * @solution - try2: 색상을 파라미터화 한다!
     * @problem - 만약에 필터 기준이 색상이 아니라 무게라면???
     * 
     */
    public static List<Apple> filterApplesByColor(List<Apple> basket, Color color) {
        // 필터링 된 사과만 담을 바구니
        List<Apple> filteredBasket = new ArrayList<>();

        for (Apple apple : basket) {
            if (apple.getColor() == color) {
                filteredBasket.add(apple);
            }
        }

        return filteredBasket;
    }

    /**
     * @solution - try3: 동작을 파라미터화 하면 해결된다!
     *                   - 함수를 전달 받을 수 있다면?
     *                   - 자바는 함수를 전달할 수 있는가?
     *                   -> 불가능하다. 자바의 함수는 일급 객체가 아닙니다
     *                   -> 함수 개념이 아니라 객체에 소속된 메서드 개념.
     *                   - 그런데 전달되는 함수가 고정되어 있는가?
     *                   -> 필터 조건에 따라 함수 내용이 달라야 한다.
     *                   -> 그러면 어떻게 함수 이름이 통일 되면서
     *                      다른 내용을 전달 할 수 있을까?
     *                      -> 오버라이딩 (상속, 인터페이스)
     * @problem - 사과만 필터링할 수 있음...
     *            다른 과일이나 전자제품 같은 것들은 필터링 불가능
     */
    public static List<Apple> filterApple(List<Apple> basket, IApplePredicate predicate) {
        List<Apple> filteredBasket = new ArrayList<>();

        for (Apple apple : basket) {
            if (predicate.test(apple)) {
                filteredBasket.add(apple);
            }
        }

        return filteredBasket;
    }

    /**
     * @solution - try4: 제너릭 필터 메서드 생성
     *
     */
    public static <T> List<T> filter(List<T> basket, IGenericPredicate<T> predicate) {
        List<T> filteredBasket = new ArrayList<>();

        for (T t : basket) {
            if (predicate.test(t)) {
                filteredBasket.add(t);
            }
        }

        return filteredBasket;
    }
}
