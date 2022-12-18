package com.ttasjwi.movie.step02.factory;

import com.ttasjwi.money.Money;
import com.ttasjwi.movie.step02.Movie;

public class Client {

    private Factory factory;

    public Client(Factory factory) {
        this.factory = factory;
    }

    public Money getAvatarFee() {
        Movie avatar = factory.createAvatarMovie();
        return avatar.getFee();
    }
}
