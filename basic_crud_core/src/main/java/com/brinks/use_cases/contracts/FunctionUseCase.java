package com.brinks.use_cases.contracts;

public interface FunctionUseCase <I, O> {

    O execute(I input);

}
