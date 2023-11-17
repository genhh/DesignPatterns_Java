package create.abstract_factory;

import java.io.IOException;
import java.nio.file.Path;

public interface HttpDocument {
    String toHtml();
    void save(Path path) throws IOException;
}
