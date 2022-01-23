package day05;

import org.junit.jupiter.api.Test;

import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TransferAggregatorTest {

    @Test
    void testReadFileException() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> new TransferAggregator().readTransfers(Paths.get("src/test/resources/transfe111rs.csv")));
        assertEquals("Can not read file.", iae.getMessage());
    }

    @Test
    void testReadFile() {
        TransferAggregator transferAggregator = new TransferAggregator();
        List<TransferPerClient> result = transferAggregator.readTransfers(Paths.get("src/test/resources/transfers.csv"));
        transferAggregator.writeToConsole(result);
    }
}