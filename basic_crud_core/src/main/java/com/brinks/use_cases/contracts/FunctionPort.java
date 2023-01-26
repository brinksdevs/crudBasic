package com.brinks.use_cases.contracts;

public interface FunctionPort <I, O> {

    O execute(I input);

}
