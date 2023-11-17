package create.factory;

import create.factory.impl.NumberFactoryImpl;

public interface NumberFactory {
    Number parse(String s);

    static NumberFactory getFactory(){
        return impl;
    }

    static NumberFactory impl = new NumberFactoryImpl();
}
