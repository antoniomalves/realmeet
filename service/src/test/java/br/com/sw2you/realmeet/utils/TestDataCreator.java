package br.com.sw2you.realmeet.utils;

import static br.com.sw2you.realmeet.utils.TestConstants.*;

import br.com.sw2you.realmeet.domain.entity.Room;

public final class TestDataCreator {

    public static Room.Builder newRoomBuilder(){
        return Room.newBuilder()
                .name(DEFAULT_ROOM_NAME)
                .seats(DEFAULT_ROOM_SEATS);
    }

    private TestDataCreator(){}


}
