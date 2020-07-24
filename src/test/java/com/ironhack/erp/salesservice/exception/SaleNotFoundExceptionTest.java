package com.ironhack.erp.salesservice.exception;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SaleNotFoundExceptionTest {
    @Test
    void assertThrows() {
        new SaleNotFoundException(null);
    }
}