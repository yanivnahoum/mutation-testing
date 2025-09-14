package com.att.training.demo.mutations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class Calculator {
    private static final Logger log = LoggerFactory.getLogger(Calculator.class);

    /**
     * MATH_MUTATOR: x - y <br>
     * RETURN_VALS_MUTATOR: result == 0 ? 1 : 0
     */
    public int add(int x, int y) {
        return x + y;
    }

    /**
     * NEGATE_CONDITIONALS_MUTATOR: value < 0 -> value > 0 <br>
     * CONDITIONALS_BOUNDARY_MUTATOR: value <= 0 (makes no difference, and mutation survives) <br>
     * INVERT_NEGS_MUTATOR: -value -> value <br>
     * RETURN_VALS_MUTATOR: result == 0 ? 1 : 0
     */
    public int abs(int value) {
        if (value < 0) {
            return -value;
        }
        return value;
    }

    /**
     * INCREMENTS_MUTATOR: ++x -> --x <br>
     * RETURN_VALS_MUTATOR: result == 0 ? 1 : 0
     */
    public int increment(int x) {
        return ++x;
    }

    /**
     * INCREMENTS_MUTATOR: --x -> ++x <br>
     * RETURN_VALS_MUTATOR: result == 0 ? 1 : 0
     */
    public int decrement(int x) {
        return --x;
    }

    /**
     * MATH_MUTATOR: x - y <br>
     * VOID_METHOD_CALL_MUTATOR: removed call to service.setResult() <br>
     * RETURN_VALS_MUTATOR: result == 0 ? 1 : 0
     */
    public int addAndSet(int x, int y, Service service) {
        int result = x + y;
        service.setResult(result);
        log.info("#addAndSet - got {}", result);
        return result;
    }
}

