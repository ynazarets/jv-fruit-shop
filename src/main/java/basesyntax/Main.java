package basesyntax;

import basesyntax.service.common.FruitTransaction;
import basesyntax.service.converter.DataConverter;
import basesyntax.service.converter.DataConverterImpl;
import basesyntax.service.handler.BalanceOperation;
import basesyntax.service.handler.OperationHandler;
import basesyntax.service.handler.PurchaseOperation;
import basesyntax.service.handler.ReturnOperation;
import basesyntax.service.handler.SupplyOperation;
import basesyntax.service.reader.FileReader;
import basesyntax.service.reader.FileReaderImpl;
import basesyntax.service.report.ReportGenerator;
import basesyntax.service.report.ReportGeneratorImpl;
import basesyntax.service.shop.OperationStrategy;
import basesyntax.service.shop.OperationStrategyImpl;
import basesyntax.service.shop.ShopService;
import basesyntax.service.shop.ShopServiceImpl;
import basesyntax.service.writer.FileWriter;
import basesyntax.service.writer.FileWriterImpl;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/data.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/report.csv";

    public static void main(String[] args) {
        FileReader fileReader = new FileReaderImpl();
        DataConverter dataConverter = new DataConverterImpl();

        Map<FruitTransaction.Operation, OperationHandler> handlerMap = new HashMap<>();
        handlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        handlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        handlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        handlerMap.put(FruitTransaction.Operation.RETURN, new ReturnOperation());

        OperationStrategy operationStrategy = new OperationStrategyImpl(handlerMap);
        ShopService shopService = new ShopServiceImpl(operationStrategy);
        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        FileWriter fileWriter = new FileWriterImpl();

        try {
            List<String> rawData = fileReader.read(INPUT_FILE_PATH);
            List<FruitTransaction> transactions = dataConverter.convertToTransaction(rawData);
            shopService.process(transactions);
            String report = reportGenerator.getReport();
            fileWriter.write(report, OUTPUT_FILE_PATH);
            System.out.println("The report is successfully generated into a file: "
                    + OUTPUT_FILE_PATH);
        } catch (RuntimeException | IOException e) {
            System.err.println("An error occurred while processing data: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
