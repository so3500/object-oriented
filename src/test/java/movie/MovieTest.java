package movie;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;

import org.junit.BeforeClass;
import org.junit.Test;

public class MovieTest {
    private static Movie avatar;
    private static Movie titanic;
    private static Movie starWars;

    @BeforeClass
    public static void createMovie() {
        // 아바타, 고정금액(800원) 할인 정책
        avatar = new Movie(
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
        titanic = new Movie(
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

        // 스타워즈, No 할인정책
        starWars = new Movie(
                "스타워즈",
                Duration.ofMinutes(210),
                Money.wons(10000),
                new NoneDiscountPolicy()
        );
    }

    @Test
    public void run() {
        assertThat(avatar).isNotNull();
        assertThat(titanic).isNotNull();
        assertThat(starWars).isNotNull();
    }
}
