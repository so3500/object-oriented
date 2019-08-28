package movie;

import java.time.DayOfWeek;
import java.time.LocalTime;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PeriodCondition implements DiscountCondition {
    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;

    // 상영 요일이 같으며, 상영 시간이 startTime 과 endTime 사이에 있을 경우
    @Override
    public boolean isSatisfiedBy(Screening screening) {
        return screening.getWhenScreened().getDayOfWeek() == dayOfWeek &&
               startTime.compareTo(screening.getWhenScreened().toLocalTime()) <= 0 &&
               endTime.compareTo(screening.getWhenScreened().toLocalTime()) >= 0;
    }
}
