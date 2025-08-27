package fruitshop.service.writer;

import java.io.IOException;

interface FileWriter {
    void write(String data, String fileName) throws IOException;
}
