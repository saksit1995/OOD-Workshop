package dip;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Random7 extends Random {
    @Override
    public int nextInt(int bound) {
        return 7;
    }
}

class SpyRandom extends Random {
    private boolean called = false;

    @Override
    public int nextInt(int bound) {
        this.called = true;
        return 100;
    }

    public boolean isCalled() {
        return this.called;
    }
}

public class GenerateIdServiceTest {
    //spy
    @Test
    public void called_nextInt_of_Random() {
        GenerateIdService service = new GenerateIdService();
        SpyRandom spy = new SpyRandom();
        service.setRandom(spy);
        service.getId();
        assertTrue(spy.isCalled());
    }

    @Test
    @DisplayName("ต้องได้ id=XYZ7")
    public void case01() {
        GenerateIdService service = new GenerateIdService();
        service.setRandom(new Random7());
        String id = service.getId();
        assertEquals("XYZ7", id);
    }
}