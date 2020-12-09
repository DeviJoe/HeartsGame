package com.sannikov.service;

import lombok.Getter;
import lombok.Setter;

public enum ChangeFazeEnum {

    CLOCKWISE(1),
    COUNTERCLOCKWISE(2),
    CROSSWISE(3),
    NONE(4);

    @Getter
    private final int phase;

    ChangeFazeEnum(int phase) {
        this.phase = phase;
    }

    public static ChangeFazeEnum getEnumFromRound(int round) {
        round = round % 4;

        return switch (round) {
            case 1 -> CLOCKWISE;
            case 2 -> COUNTERCLOCKWISE;
            case 3 -> CROSSWISE;
            default -> NONE;
        };
    }
}
