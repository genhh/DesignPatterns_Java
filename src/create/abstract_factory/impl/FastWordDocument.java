package create.abstract_factory.impl;

import create.abstract_factory.WordDocument;

import java.io.IOException;
import java.nio.file.Path;

public class FastWordDocument implements WordDocument {
    private String md;
    FastWordDocument(String md){
        this.md = md;
    }
    @Override
    public void save(Path path) throws IOException {
        System.out.println(md);
    }
}
