package basesyntax.service.writer;

import java.io.IOException;

public interface FileWriter {
    void write(String data, String fileName) throws IOException;
}
