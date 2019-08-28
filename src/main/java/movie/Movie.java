package movie;

import java.time.Duration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Movie {
    private String title;
    private Duration runningTime;
    @Getter
    private Money fee;
    private DiscountPolicy discountPolicy;

    public Money calculateMovieFee(Screening screening) {
        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }
}
