package com.example.mapsdemoridery.room.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.mapsdemoridery.room.entity.User;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM tb_user ORDER BY added_on DESC, id DESC")
    List<User> selectAll();

    @Query("SELECT * FROM tb_user  WHERE username = :userUuid ORDER BY added_on DESC, id DESC")
    List<User> selectAllByUserUuid(String userUuid);

    @Query("SELECT * FROM tb_user WHERE username = :userUuid")
    User getUserByUsername(String userUuid);

    @Insert
    void insert(User user);

    @Update
    void updateUser(User user);

    @Query("UPDATE tb_user SET username = :newUsername, password = :newPassword WHERE id = :id")
    void updateUserCredentials(int id, String newUsername, String newPassword);

    @Query("DELETE FROM tb_user")
    void removeAll();

}
