package org.edwith.webbe.guestbook.dao;

import java.sql.SQLException;
import org.edwith.webbe.guestbook.dto.Guestbook;
import org.edwith.webbe.guestbook.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GuestbookDao {

    public List<Guestbook> getGuestbooks() {
        Connection conn = DBUtil.getConnection();
        List<Guestbook> list = new ArrayList<>();
        String sql = "SELECT * FROM guestbook";

        try (PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery()) {
            addGuestbookToList(list, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    private void addGuestbookToList(List<Guestbook> list, ResultSet rs) throws SQLException {
        while (rs.next()) {
            list.add(new Guestbook(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("content"),
                rs.getDate("regdate")
            ));
        }
    }

    public void addGuestbook(Guestbook guestbook) {
        Connection conn = DBUtil.getConnection();
        String sql = "INSERT INTO guestbook (`name`,`content`,`regdate`)"
            + "values(?,?,now())";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, guestbook.getName());
            pstmt.setString(2, guestbook.getContent());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
