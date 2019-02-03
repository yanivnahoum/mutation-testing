package com.att.training.demo.mutations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class Calculator {

    private static final Logger log = LoggerFactory.getLogger(Calculator.class);

    /**
     * MATH_MUTATOR: x - y
     * RETURN_VALS_MUTATOR: result == 0 ? 1 : 0
     */
    int add(int x, int y) {
        return x + y;
    }

    /**
     * NEGATE_CONDITIONALS_MUTATOR: value < 0 -> value > 0
     * CONDITIONALS_BOUNDARY_MUTATOR: value <= 0 (makes no difference, and mutation survives)
     * INVERT_NEGS_MUTATOR: -value -> value
     * RETURN_VALS_MUTATOR: result == 0 ? 1 : 0
     */
    int abs(int value) {
        if (value < 0) {
            return -value;
        }
        return value;
    }

    /**
     * INCREMENTS_MUTATOR: ++x -> --x
     * RETURN_VALS_MUTATOR: result == 0 ? 1 : 0
     */
    int increment(int x) {
        return ++x;
    }

    /**
     * INCREMENTS_MUTATOR: --x -> ++x
     * RETURN_VALS_MUTATOR: result == 0 ? 1 : 0
     */
    int decrement(int x) {
        return --x;
    }

    /**
     * MATH_MUTATOR: x - y
     * VOID_METHOD_CALL_MUTATOR: removed call to service.setResult()
     * RETURN_VALS_MUTATOR: result == 0 ? 1 : 0
     */
    int addAndSet(int x, int y, Service service) {
        int result = x + y;
        service.setResult(result);
        return result;
    }
}

