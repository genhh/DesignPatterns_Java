package create.factory.impl;

import create.factory.NumberFactory;

import java.math.BigDecimal;

public class NumberFactoryImpl implements NumberFactory {

    @Override
    public Number parse(String s) {
        return new BigDecimal(s);
    }
}
