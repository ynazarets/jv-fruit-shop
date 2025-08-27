package basesyntax.service.report;

import basesyntax.storage.Storage;
import java.util.Map;
import java.util.TreeMap;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String REPORT_HEADER = "fruit,quantity";

    @Override
    public String getReport() {
        Map<String, Integer> fruitStocks = new TreeMap<>(Storage.getFruits());
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append(REPORT_HEADER).append("\n");
        for (Map.Entry<String, Integer> entry : fruitStocks.entrySet()) {
            reportBuilder.append(entry.getKey()).append(",")
                    .append(entry.getValue()).append("\n");
        }
        return reportBuilder.toString();
    }
}
