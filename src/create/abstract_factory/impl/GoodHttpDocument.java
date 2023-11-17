package create.abstract_factory.impl;

import create.abstract_factory.HttpDocument;
import org.w3c.dom.html.HTMLDocument;

import java.io.IOException;
import java.nio.file.Path;

public class GoodHttpDocument implements HttpDocument {
    @Override
    public String toHtml() {
        return null;
    }

    @Override
    public void save(Path path) throws IOException {

    }
}
