package chapter02.item7.listener;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.lang.ref.WeakReference;
import java.util.List;

class ChatRoomTest {

    @Test
    void chatRoom() throws InterruptedException {
        ChatRoom chatRoom = new ChatRoom();
        User user1 = new User();
        User user2 = new User();

        chatRoom.addUser(user1);
        chatRoom.addUser(user2);

        chatRoom.sendMessage("hello");

        user1 = null; // user1의 weak reference가 사라질까?

        System.gc();

        Thread.sleep(5000L);

        // List에 Weak Reference는 그대로 남아있다. 따라서 List에서 Weak Reference를 비워주는 커스텀 리스트를 만들어야 한다!
        List<WeakReference<User>> users = chatRoom.getUsers();
        assertFalse(users.size() == 1); // users.size() : 2
    }

}