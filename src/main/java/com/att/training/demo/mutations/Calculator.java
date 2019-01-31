package com.att.training.demo.mutations;

class Calculator {

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
}
