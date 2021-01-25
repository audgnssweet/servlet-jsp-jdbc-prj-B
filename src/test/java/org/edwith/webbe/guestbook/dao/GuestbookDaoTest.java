package org.edwith.webbe.guestbook.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.edwith.webbe.guestbook.dto.Guestbook;
import org.junit.jupiter.api.Test;

class GuestbookDaoTest {

    GuestbookDao guestbookDao = new GuestbookDao();

    @Test
    void getGuestbooks() {
        List<Guestbook> guestbooks = guestbookDao.getGuestbooks();
        guestbooks.forEach(System.out::println);
    }

    @Test
    void addGuestbook() {
        guestbookDao.addGuestbook(new Guestbook("정명훈", "안녕하세요"));
    }
}