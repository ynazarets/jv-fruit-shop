package fruitshop.service.report;

import fruitshop.storage.Storage;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    public static final String KOMA = ",";

    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder("fruit,quantity\n");
        for (Map.Entry<String, Integer> entry : Storage.getFruitStorage().entrySet()) {
            report.append(entry.getKey())
                    .append(KOMA)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
