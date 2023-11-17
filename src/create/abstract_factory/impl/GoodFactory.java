package create.abstract_factory.impl;

import create.abstract_factory.AbstractFactory;
import create.abstract_factory.HttpDocument;
import create.abstract_factory.WordDocument;

//good 和fast是两种不同的品牌，每个品牌都有html和word两种产品
public class GoodFactory implements AbstractFactory {
    @Override
    public HttpDocument createHtml(String md) {
        return null;
    }

    @Override
    public WordDocument createWord(String md) {
        return null;
    }
}
