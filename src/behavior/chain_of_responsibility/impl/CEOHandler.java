package behavior.chain_of_responsibility.impl;

import behavior.chain_of_responsibility.Handler;
import behavior.chain_of_responsibility.Request;

import java.math.BigDecimal;

public class CEOHandler implements Handler {
    @Override
    public Boolean process(Request request) {
        // 如果超过1000元，处理不了，交下一个处理:
        if (request.getAmount().compareTo(BigDecimal.valueOf(10000000)) > 0) {
            return null;
        }
        // 对Bob有偏见:
        return !request.getName().equalsIgnoreCase("bob");
    }
}
