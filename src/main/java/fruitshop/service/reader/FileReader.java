package fruitshop.service.reader;

import java.io.IOException;
import java.util.List;

interface FileReader {
    List<String> read(String fileName) throws IOException;
}
