package com.att.training.demo.mutations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void add_returnSum() {
        int result = calculator.add(2, 3);
        assertThat(result).isEqualTo(5);
    }

    @ParameterizedTest
    @CsvSource({
            "7, 7",
            "0, 0",
            "-7, 7"
    })
    void givenX_absReturnsY(int input, int expected) {
        int actual = calculator.abs(input);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void incrementAddsOne() {
        int result = calculator.increment(10);
        assertThat(result).isEqualTo(11);
    }

    @Test
    void decrementSubtractsOne() {
        int result = calculator.decrement(10);
        assertThat(result).isEqualTo(9);
    }

    @Test
    void addAndSet(@Mock Service service) {
        int result = calculator.addAndSet(2, 3, service);
        assertThat(result).isEqualTo(5);
        verify(service).setResult(result);
    }
}