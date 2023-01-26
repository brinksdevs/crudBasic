package com.brinks.use_cases.contracts;

public interface ConsumerPort <I>{

    void execute(I input);

}
