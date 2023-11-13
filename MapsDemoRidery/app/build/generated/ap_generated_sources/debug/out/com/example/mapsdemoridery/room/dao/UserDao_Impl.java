package com.example.mapsdemoridery.room.dao;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.mapsdemoridery.room.entity.User;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class UserDao_Impl implements UserDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<User> __insertionAdapterOfUser;

  private final EntityDeletionOrUpdateAdapter<User> __updateAdapterOfUser;

  private final SharedSQLiteStatement __preparedStmtOfUpdateUserCredentials;

  private final SharedSQLiteStatement __preparedStmtOfRemoveAll;

  public UserDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUser = new EntityInsertionAdapter<User>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `tb_user` (`id`,`username`,`password`,`added_on`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement, final User entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getUserUuid() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getUserUuid());
        }
        if (entity.getPassword() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getPassword());
        }
        if (entity.getAddedOn() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getAddedOn());
        }
      }
    };
    this.__updateAdapterOfUser = new EntityDeletionOrUpdateAdapter<User>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `tb_user` SET `id` = ?,`username` = ?,`password` = ?,`added_on` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement, final User entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getUserUuid() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getUserUuid());
        }
        if (entity.getPassword() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getPassword());
        }
        if (entity.getAddedOn() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getAddedOn());
        }
        statement.bindLong(5, entity.getId());
      }
    };
    this.__preparedStmtOfUpdateUserCredentials = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE tb_user SET username = ?, password = ? WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfRemoveAll = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM tb_user";
        return _query;
      }
    };
  }

  @Override
  public void insert(final User user) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfUser.insert(user);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateUser(final User user) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfUser.handle(user);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateUserCredentials(final int id, final String newUsername,
      final String newPassword) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateUserCredentials.acquire();
    int _argIndex = 1;
    if (newUsername == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, newUsername);
    }
    _argIndex = 2;
    if (newPassword == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, newPassword);
    }
    _argIndex = 3;
    _stmt.bindLong(_argIndex, id);
    try {
      __db.beginTransaction();
      try {
        _stmt.executeUpdateDelete();
        __db.setTransactionSuccessful();
      } finally {
        __db.endTransaction();
      }
    } finally {
      __preparedStmtOfUpdateUserCredentials.release(_stmt);
    }
  }

  @Override
  public void removeAll() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfRemoveAll.acquire();
    try {
      __db.beginTransaction();
      try {
        _stmt.executeUpdateDelete();
        __db.setTransactionSuccessful();
      } finally {
        __db.endTransaction();
      }
    } finally {
      __preparedStmtOfRemoveAll.release(_stmt);
    }
  }

  @Override
  public List<User> selectAll() {
    final String _sql = "SELECT * FROM tb_user ORDER BY added_on DESC, id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfUserUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "username");
      final int _cursorIndexOfPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "password");
      final int _cursorIndexOfAddedOn = CursorUtil.getColumnIndexOrThrow(_cursor, "added_on");
      final List<User> _result = new ArrayList<User>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final User _item;
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
        final String _tmpUserUuid;
        if (_cursor.isNull(_cursorIndexOfUserUuid)) {
          _tmpUserUuid = null;
        } else {
          _tmpUserUuid = _cursor.getString(_cursorIndexOfUserUuid);
        }
        final String _tmpPassword;
        if (_cursor.isNull(_cursorIndexOfPassword)) {
          _tmpPassword = null;
        } else {
          _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
        }
        final String _tmpAddedOn;
        if (_cursor.isNull(_cursorIndexOfAddedOn)) {
          _tmpAddedOn = null;
        } else {
          _tmpAddedOn = _cursor.getString(_cursorIndexOfAddedOn);
        }
        _item = new User(_tmpId,_tmpUserUuid,_tmpPassword,_tmpAddedOn);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<User> selectAllByUserUuid(final String userUuid) {
    final String _sql = "SELECT * FROM tb_user  WHERE username = ? ORDER BY added_on DESC, id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (userUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userUuid);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfUserUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "username");
      final int _cursorIndexOfPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "password");
      final int _cursorIndexOfAddedOn = CursorUtil.getColumnIndexOrThrow(_cursor, "added_on");
      final List<User> _result = new ArrayList<User>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final User _item;
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
        final String _tmpUserUuid;
        if (_cursor.isNull(_cursorIndexOfUserUuid)) {
          _tmpUserUuid = null;
        } else {
          _tmpUserUuid = _cursor.getString(_cursorIndexOfUserUuid);
        }
        final String _tmpPassword;
        if (_cursor.isNull(_cursorIndexOfPassword)) {
          _tmpPassword = null;
        } else {
          _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
        }
        final String _tmpAddedOn;
        if (_cursor.isNull(_cursorIndexOfAddedOn)) {
          _tmpAddedOn = null;
        } else {
          _tmpAddedOn = _cursor.getString(_cursorIndexOfAddedOn);
        }
        _item = new User(_tmpId,_tmpUserUuid,_tmpPassword,_tmpAddedOn);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public User getUserByUsername(final String userUuid) {
    final String _sql = "SELECT * FROM tb_user WHERE username = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (userUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userUuid);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfUserUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "username");
      final int _cursorIndexOfPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "password");
      final int _cursorIndexOfAddedOn = CursorUtil.getColumnIndexOrThrow(_cursor, "added_on");
      final User _result;
      if (_cursor.moveToFirst()) {
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
        final String _tmpUserUuid;
        if (_cursor.isNull(_cursorIndexOfUserUuid)) {
          _tmpUserUuid = null;
        } else {
          _tmpUserUuid = _cursor.getString(_cursorIndexOfUserUuid);
        }
        final String _tmpPassword;
        if (_cursor.isNull(_cursorIndexOfPassword)) {
          _tmpPassword = null;
        } else {
          _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
        }
        final String _tmpAddedOn;
        if (_cursor.isNull(_cursorIndexOfAddedOn)) {
          _tmpAddedOn = null;
        } else {
          _tmpAddedOn = _cursor.getString(_cursorIndexOfAddedOn);
        }
        _result = new User(_tmpId,_tmpUserUuid,_tmpPassword,_tmpAddedOn);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
