package day05;

public class TransferPerClient {
    private String clientId;
    private int sum;
    private int numberOfTransactions;

    public TransferPerClient(String id) {
        this.clientId = id;
    }

    public String getClientId() {
        return clientId;
    }

    public int getSum() {
        return sum;
    }

    public int getNumberOfTransactions() {
        return numberOfTransactions;
    }

    public void debit(int amountReceived) {
        sum += amountReceived;
        numberOfTransactions++;
    }
    public void credit(int amountSent) {
        sum -= amountSent;
        numberOfTransactions++;
    }

    @Override
    public String toString() {
        return clientId + "," + sum + "," + numberOfTransactions;
    }
}
