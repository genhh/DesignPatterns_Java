package create.abstract_factory.impl;

import create.abstract_factory.HttpDocument;

import java.io.IOException;
import java.nio.file.Path;

public class FastHttpDocument implements HttpDocument {
    private String md;
    FastHttpDocument(String md){
        this.md = md;
    }
    @Override
    public String toHtml() {
        return md;
    }

    @Override
    public void save(Path path) throws IOException {
        System.out.println(md);
    }
}
