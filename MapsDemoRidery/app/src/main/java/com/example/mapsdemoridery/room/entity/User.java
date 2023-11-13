package com.example.mapsdemoridery.room.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import org.json.JSONException;
import org.json.JSONObject;

@Entity(tableName = "tb_user")
public class User {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private long id;

    @ColumnInfo(name = "username")
    private String userUuid;

    @ColumnInfo(name = "password")
    private String password;


    @ColumnInfo(name = "added_on")
    private String addedOn;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddedOn() {
        return addedOn;
    }

    public void setAddedOn(String addedOn) {
        this.addedOn = addedOn;
    }

    public User(long id, String userUuid, String password, String addedOn) {

        this.id = id;
        this.userUuid = userUuid;
        this.password = password;
        this.addedOn = addedOn;
    }

    @Ignore
    public User( ) {
        this.userUuid = "";
        this.password = "";
        this.addedOn = "";
    }

    public JSONObject toJson() throws JSONException
     {
         JSONObject jsonObject = new JSONObject();
         jsonObject.put("user_uuid", userUuid);
         jsonObject.put("password", password);
         jsonObject.put("added_on", addedOn);

         return jsonObject;
    }
}
