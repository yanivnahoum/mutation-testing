package com.att.training.demo.mutations;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void add_returnSum() {
        int result = calculator.add(2, 3);
        assertThat(result).isEqualTo(5);
    }

    @Test
    public void givenPositiveNumber_abs_returnsAbsolute() {
        int result = calculator.abs(7);
        assertThat(result).isEqualTo(7);
    }

    @Test
    public void givenNegativeNumber_abs_returnsAbsolute() {
        int result = calculator.abs(-7);
        assertThat(result).isEqualTo(7);
    }

    @Test
    public void incrementAddsOne() {
        int result = calculator.increment(10);
        assertThat(result).isEqualTo(11);
    }

    @Test
    public void decrementSubtractsOne() {
        int result = calculator.decrement(10);
        assertThat(result).isEqualTo(9);
    }

    @Test
    public void addAndSet() {
        Service service = mock(Service.class);
        int result = calculator.addAndSet(2, 3, service);
        assertThat(result).isEqualTo(5);
        verify(service).setResult(result);
    }
}