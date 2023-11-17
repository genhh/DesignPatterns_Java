package create.abstract_factory.impl;

import create.abstract_factory.AbstractFactory;
import create.abstract_factory.HttpDocument;
import create.abstract_factory.WordDocument;

public class FastFactory implements AbstractFactory {
    @Override
    public HttpDocument createHtml(String md) {
        return new FastHttpDocument(md);
    }

    @Override
    public WordDocument createWord(String md) {
        return new FastWordDocument(md);
    }
}
