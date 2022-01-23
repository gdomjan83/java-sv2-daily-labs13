package day05;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class TransferAggregator {
    private Map<String, TransferPerClient> transfers = new TreeMap<>();

    public Map<String, TransferPerClient> getTransfers() {
        return new TreeMap<>(transfers);
    }

    public List<TransferPerClient> readTransfers(Path path) {
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            while ((line = br.readLine()) != null) {
                Transaction transaction = recordTransaction(line);
                creditAccount(transaction);
                debitAccount(transaction);
            }
            return new ArrayList<>(transfers.values());
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Can not read file.", ioe);
        }
    }

    public void writeToConsole(List<TransferPerClient> input) {
        for (TransferPerClient actual : input) {
            System.out.println(actual);
        }
    }

    private Transaction recordTransaction(String line) {
        String sender = line.split(",")[0];
        String receiver = line.split(",")[1];
        int amount = Integer.parseInt(line.split(",")[2]);
        return new Transaction(sender, receiver, amount);
    }

    private void debitAccount(Transaction transaction) {
        if (!transfers.containsKey(transaction.receiver)) {
            transfers.put(transaction.receiver, new TransferPerClient(transaction.receiver));
        }
        transfers.get(transaction.receiver).debit(transaction.amount);
    }

    private void creditAccount(Transaction transaction) {
        if (!transfers.containsKey(transaction.sender)) {
            transfers.put(transaction.sender, new TransferPerClient(transaction.sender));
        }
        transfers.get(transaction.sender).credit(transaction.amount);
    }

    public class Transaction {
        private String sender;
        private String receiver;
        private int amount;

        public Transaction(String sender, String receiver, int amount) {
            this.sender = sender;
            this.receiver = receiver;
            this.amount = amount;
        }
    }
}
