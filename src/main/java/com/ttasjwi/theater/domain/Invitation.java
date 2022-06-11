package com.ttasjwi.theater.domain;

import java.time.LocalDateTime;

public class Invitation {

    /**
     * 초대 일자
     */
    private LocalDateTime when;

    public Invitation(LocalDateTime when) {
        this.when = when;
    }
}
