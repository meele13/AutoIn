package com.gotofinal.autoin.api.utils.function.eval;

@FunctionalInterface
public interface ObjectEvaluator extends Evaluator<Object>
{
    @Override
    Object eval();
}
