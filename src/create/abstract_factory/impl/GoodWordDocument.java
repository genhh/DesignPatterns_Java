package create.abstract_factory.impl;

import create.abstract_factory.WordDocument;

import java.io.IOException;
import java.nio.file.Path;

public class GoodWordDocument implements WordDocument {
    @Override
    public void save(Path path) throws IOException {

    }
}
