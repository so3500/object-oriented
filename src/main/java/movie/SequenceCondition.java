package movie;

import lombok.AllArgsConstructor;

/**
 * 순번 조건
 * */
@AllArgsConstructor
public class SequenceCondition implements DiscountCondition {
    private int sequence;

    // 파라미터로 전달된 screening 의 상영순번과 일치할 경우 할인 가능 true
    @Override
    public boolean isSatisfiedBy(Screening screening) {
        return screening.isSequence(sequence);
    }
}
