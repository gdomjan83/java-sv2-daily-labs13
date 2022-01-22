package day05;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class Transfers {
    private Map<String, Integer> clientAccounts = new HashMap<>();

    public Map<String, Integer> getClientAccounts() {
        return new HashMap<>(clientAccounts);
    }

    public void importData(Path path) {
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            while ((line = br.readLine()) != null) {
                Transaction transaction = recordTransaction(line);
                creditAccount(transaction);
                debitAccount(transaction);
            }
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Can not read file.", ioe);
        }
    }

    private Transaction recordTransaction(String line) {
        String sender = line.split(",")[0];
        String receiver = line.split(",")[1];
        int amount = Integer.parseInt(line.split(",")[2]);
        return new Transaction(sender, receiver, amount);
    }

    private void debitAccount(Transaction transaction) {
        if (!clientAccounts.containsKey(transaction.receiver)) {
            clientAccounts.put(transaction.receiver, transaction.amount);
        } else {
            clientAccounts.put(transaction.receiver, clientAccounts.get(transaction.receiver) + transaction.amount);
        }
    }

    private void creditAccount(Transaction transaction) {
        if (!clientAccounts.containsKey(transaction.sender)) {
            clientAccounts.put(transaction.sender, 0 - transaction.amount);
        } else {
            clientAccounts.put(transaction.sender, clientAccounts.get(transaction.sender) - transaction.amount);
        }
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
