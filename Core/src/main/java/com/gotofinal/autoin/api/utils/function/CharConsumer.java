package com.gotofinal.autoin.api.utils.function;

import java.util.Objects;

/**
 * Represents an operation that accepts a single {@code char}-valued argument and
 * returns no result.  This is the primitive type specialization of
 * {@link java.util.function.Consumer} for {@code char}.  Unlike most other functional interfaces,
 * {@code CharConsumer} is expected to operate via side-effects.
 *
 * @see java.util.function.Consumer
 */
@FunctionalInterface
public interface CharConsumer
{

    /**
     * Performs this operation on the given argument.
     *
     * @param value the input argument
     */
    void accept(char value);

    /**
     * Returns a composed {@code CharConsumer} that performs, in sequence, this
     * operation followed by the {@code after} operation. If performing either
     * operation throws an exception, it is relayed to the caller of the
     * composed operation.  If performing this operation throws an exception,
     * the {@code after} operation will not be performed.
     *
     * @param after the operation to perform after this operation
     *
     * @return a composed {@code CharConsumer} that performs in sequence this
     * operation followed by the {@code after} operation
     *
     * @throws NullPointerException if {@code after} is null
     */
    default CharConsumer andThen(final CharConsumer after)
    {
        Objects.requireNonNull(after);
        return (char t) -> {
            this.accept(t);
            after.accept(t);
        };
    }
}