package behavior.strategy;

import java.math.BigDecimal;

//在一个计算方法中把容易变化的算法抽出来作为“策略”参数传进去
//而且为了遵循单一职责原则，策略之间最好不要有依赖关系
public interface DiscountStrategy {
    // 计算折扣额度:
    BigDecimal getDiscount(BigDecimal total);
}
