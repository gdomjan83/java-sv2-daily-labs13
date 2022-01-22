package day05;

import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class TransfersTest {

    @Test
    void testReadFileException() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> new Transfers().importData(Paths.get("src/test/resources/transfe111rs.csv")));
        assertEquals("Can not read file.", iae.getMessage());
    }

    @Test
    void testReadFile() {
        Transfers transfers = new Transfers();
        transfers.importData(Paths.get("src/test/resources/transfers.csv"));
        System.out.println(transfers.getClientAccounts());
    }
}