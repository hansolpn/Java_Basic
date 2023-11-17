package etc.stream.quiz;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = List.of(
                new Transaction(brian, 2021, 300),
                new Transaction(raoul, 2022, 1000),
                new Transaction(raoul, 2021, 400),
                new Transaction(mario, 2021, 710),
                new Transaction(mario, 2022, 700),
                new Transaction(alan, 2022, 950)
        );

        // 연습 1: 2021년에 발생한 모든 거래를 찾아 거래액 오름차 정렬(작은 값에서 큰 값).
        System.out.println("p1 = ");
        transactions.stream()
                .filter(t -> t.getYear() == 2021)
                .sorted(Comparator.comparing(t -> t.getValue()))
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("===================================");
        System.out.println("p2 = ");
        // 연습 2: 거래자가 근무하는 모든 도시 이름을 중복 없이 나열하시오.
        transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("===================================");
        // 연습 3: Cambridge에 근무하는 모든 거래자를 찾아 거래자 리스트로 이름순으로 오름차 정렬.
        List<Trader> p3 = transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .map(t -> t.getTrader())
                .distinct()
                .sorted(Comparator.comparing(t -> t.getName()))
                .collect(Collectors.toList());
        System.out.println("p3 = " + p3);
        p3.forEach(System.out::println);


        System.out.println("===================================");
        // 연습 4: 모든 거래자의 이름을 리스트에 모아서 알파벳순으로 오름차 정렬하여 반환
        List<String> p4 = transactions.stream()
                .map(t -> t.getTrader().getName())
                .distinct()
                .sorted() // 문자나 숫자는 Comparator를 사용하지 않아도 됩니다.
                .collect(Collectors.toList());
        System.out.println("p4 = " + p4);

        System.out.println("===================================");
        // 연습 5: Milan에 거주하는 거래자가 한명이라도 있는지 여부 확인?
        boolean p5 = transactions.stream()
                .anyMatch(t -> t.getTrader().getCity().equalsIgnoreCase("Milan"));

        System.out.println("p5 = " + p5);

        System.out.println("===================================");
        // 연습 6: Cambridge에 사는 거래자의 모든 거래액의 총합 출력.
        int p6 = transactions.stream()
                .filter(t -> t.getTrader().getCity().equalsIgnoreCase("Cambridge"))
                .mapToInt(t -> t.getValue())
                .sum();
        System.out.println("p6 = " + p6);

        AtomicInteger total = new AtomicInteger();
        transactions.stream()
                .filter(t -> t.getTrader().getCity().equalsIgnoreCase("Cambridge"))
                .map(t -> t.getValue())
                .forEach(i -> total.addAndGet(i));
        System.out.println("p6_2 = " + total);

        System.out.println("===================================");
        // 연습 7: 모든 거래에서 최고 거래액은 얼마인가?
        transactions.stream()
                    .max(Comparator.comparing(t -> t.getValue()))
                    .ifPresent(t -> System.out.println("p7 = " + t.getValue()));

        int p7_2 = transactions.stream()
                .mapToInt(t -> t.getValue())
                .max()
                .getAsInt();

        System.out.println("p7_2 = " + p7_2);

        System.out.println("===================================");
        // 연습 8. 가장 작은 거래액을 가진 거래정보 탐색
        transactions.stream()
                .min(Comparator.comparing(t -> t.getValue()))
                .ifPresent(t -> System.out.println("p8 = " + t));
    }
}
