package com.funoverflowwebservices.common.core.utils;

public enum EventChatMsgType {

    AUDIT(0),
    TEXT_MSG(1),
    EMOTICON(2),
    IMAGE(3),
    VIDEO(4),
    LOCATION(5),
    LINK(6);

    private final int value;

    private EventChatMsgType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
