package com.ttasjwi.game;

public interface Collidable extends Displayable {

    boolean collideWith(Collidable other);
}
