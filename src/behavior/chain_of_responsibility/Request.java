package behavior.chain_of_responsibility;

import java.math.BigDecimal;

//责任链模式:
//1 按顺序传递，职责范围逐步扩大的模式
//2 手动调用handler传递需求
//3 每个handler都要处理一部分需求(拦截器)
public class Request {
    private String name;
    private BigDecimal amount;

    public Request(String name, BigDecimal amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
