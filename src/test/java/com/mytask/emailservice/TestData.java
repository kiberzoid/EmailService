package com.mytask.emailservice;

import com.mytask.emailservice.model.Message;

import java.util.Set;

public class TestData {
    public static final Message MSG = new Message("from@mail.ru", Set.of("copy1@mail.ru", "copy2@mail.ru"),
            "test message", "this is message for test ");
    public static final Message BAD_MSG = new Message();
}
