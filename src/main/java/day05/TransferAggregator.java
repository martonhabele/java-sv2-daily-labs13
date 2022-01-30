package day05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TransferAggregator {

    private List<String> readLines(Path path) {
        try {
            return Files.readAllLines(path);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

    public List<TransferPerClient> readTransfers(Path path) {
        List<String> lines = readLines(path);
        return summarize(lines);
    }

    private List<TransferPerClient> summarize(List<String> lines) {
        Map<String, TransferPerClient> transfers = new TreeMap<>();
        for (String line: lines) {
            String[] parts = line.split(",");
            String sourceClientId = parts[0];
            String targetClientId = parts[1];
            int amount = Integer.parseInt(parts[2]);

            TransferPerClient source = transfers.computeIfAbsent(sourceClientId,
                    k -> new TransferPerClient(sourceClientId));
            source.moving(-amount);

            TransferPerClient target = transfers.computeIfAbsent(targetClientId,
                    k -> new TransferPerClient(targetClientId));
            target.moving(amount);
        }
        return new ArrayList<>(transfers.values());
    }

    public static void main(String[] args) {
        TransferAggregator ta = new TransferAggregator();
        List<TransferPerClient> trs = ta.readTransfers(Paths.get("src/main/resources/transfers.csv"));

        for (TransferPerClient tr : trs) {
            System.out.printf("%s %,12d %5d\n", tr.getClientId(), tr.getSum(), tr.getNumberOfTransactions());
        }
    }
}