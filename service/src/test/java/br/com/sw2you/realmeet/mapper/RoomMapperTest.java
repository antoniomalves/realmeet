package br.com.sw2you.realmeet.mapper;

import static br.com.sw2you.realmeet.utils.MapperUtils.roomMapper;
import static br.com.sw2you.realmeet.utils.TestDataCreator.newRoomBuilder;
import static org.junit.jupiter.api.Assertions.assertEquals;

import br.com.sw2you.realmeet.api.model.RoomDTO;
import br.com.sw2you.realmeet.core.BasicUnitTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

class RoomMapperTest extends BasicUnitTest {

    private RoomMapper roomMapper;

    @BeforeEach
    void setUp(){
        roomMapper = roomMapper();
    }

    @Test
    void fromEntityToDTO() {
        var room = newRoomBuilder().id(1l).build();

        RoomDTO roomDTO = roomMapper.fromEntityToDTO(room);

        assertEquals(room.getId(), roomDTO.getId());
        assertEquals(room.getName(), roomDTO.getName());
        assertEquals(room.getSeats(), roomDTO.getSeats());
    }


}