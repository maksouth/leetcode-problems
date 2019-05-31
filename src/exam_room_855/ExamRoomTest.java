package exam_room_855;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExamRoomTest {

    private ExamRoom examRoom;

    @Test
    public void test1() {
        examRoom = new ExamRoom(10);
        assertEquals(0, examRoom.seat());
        assertEquals(9, examRoom.seat());
        assertEquals(4, examRoom.seat());
        assertEquals(2, examRoom.seat());
        examRoom.leave(4);
        assertEquals(5, examRoom.seat());
    }

    @Test
    public void test2() {
        examRoom = new ExamRoom(10);
        assertEquals(0, examRoom.seat());
        assertEquals(9, examRoom.seat());
        assertEquals(4, examRoom.seat());
        examRoom.leave(0);
        examRoom.leave(4);
    }

    @Test
    public void test3() {
        examRoom = new ExamRoom(4);
        assertEquals(0, examRoom.seat());
        assertEquals(3, examRoom.seat());
        assertEquals(1, examRoom.seat());
        assertEquals(2, examRoom.seat());
        examRoom.leave(1);
        examRoom.leave(3);
        assertEquals(1, examRoom.seat());
    }
}