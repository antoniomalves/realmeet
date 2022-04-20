package br.com.sw2you.realmeet.service;

import static br.com.sw2you.realmeet.utils.MapperUtils.roomMapper;
import static br.com.sw2you.realmeet.utils.TestConstants.DEFAULT_ROOM_ID;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.when;

import br.com.sw2you.realmeet.core.BasicUnitTest;
import br.com.sw2you.realmeet.domain.repository.RoomRepository;
import br.com.sw2you.realmeet.utils.TestDataCreator;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class RoomServiceTest extends BasicUnitTest {

    private RoomService roomService;

    @Mock
    private RoomRepository roomRepository;

    @BeforeEach
    void setUp(){
        roomService = new RoomService(roomRepository, roomMapper());
    }

    @Test
    void getRoom(){
        var room = TestDataCreator.newRoomBuilder().id(DEFAULT_ROOM_ID).build();
        when(roomRepository.findById(anyLong())).thenReturn(Optional.of(room));
        var dto = roomService.getRoom(DEFAULT_ROOM_ID);

        assertEquals(room.getId(), dto.getId());
        assertEquals(room.getName(), dto.getName());
        assertEquals(room.getSeats(), dto.getSeats());
    }

}