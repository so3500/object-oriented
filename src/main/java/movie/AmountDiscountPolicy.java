package movie;

public class AmountDiscountPolicy extends DiscountPolicy {
    private Money discountAmount;

    public AmountDiscountPolicy(Money discountAmount, DiscountCondition... conditions) {
        super(conditions);
        this.discountAmount = discountAmount;
    }

    // 고정 금액 할인
    @Override
    protected Money getDiscountAmount(Screening screening) {
        return discountAmount;
    }
}
