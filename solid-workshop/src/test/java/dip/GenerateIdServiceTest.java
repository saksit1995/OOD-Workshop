package dip;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.Assert.*;
class Random7 extends Random {
    @Override
    public int nextInt(int bound) {
        return 7;
    }

}

public class GenerateIdServiceTest {

    @Test
    @DisplayName("ต้องได้ id=XYZ7")
    public void case01() {
        GenerateIdService service = new GenerateIdService();
        service.setRandom(new Random7());
        String id = service.getId();
        assertEquals("XYZ7", id);
    }

}