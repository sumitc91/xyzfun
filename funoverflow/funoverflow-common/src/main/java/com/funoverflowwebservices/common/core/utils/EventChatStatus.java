package com.funoverflowwebservices.common.core.utils;

public enum EventChatStatus {

    USER_ENTRY(1),
    USER_EXIT(2),
    USER_IN_USE(3),
    MSG_PERSISTED(4),
    MSG_DELETED(5);

    private final int value;

    private EventChatStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
