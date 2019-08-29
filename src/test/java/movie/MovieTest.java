package movie;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;

import org.junit.BeforeClass;

public class MovieTest {
    @BeforeClass
    public static void createMovie() {
        // 아바타, 고정금액(800원) 할인 정책
        Movie avatar = new Movie(
                "아바타",
                Duration.ofMinutes(120),
                Money.wons(10000),
                new AmountDiscountPolicy(
                        Money.wons(800),
                        new SequenceCondition(1),
                        new SequenceCondition(10),
                        new PeriodCondition(
                                DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 59)
                        ),
                        new PeriodCondition(
                                DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(20, 59)
                        )
                )
        );

        // 타이타닉, 비율금액(10%) 할인 정책
        Movie titanic = new Movie(
                "타이타닉",
                Duration.ofMinutes(180),
                Money.wons(11000),
                new PercentDiscountPolicy(
                        0.1,
                        new SequenceCondition(2),
                        new PeriodCondition(
                                DayOfWeek.TUESDAY, LocalTime.of(14, 0), LocalTime.of(16, 59)
                        ),
                        new PeriodCondition(
                                DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(13, 59)
                        )
                )
        );
    }
}
