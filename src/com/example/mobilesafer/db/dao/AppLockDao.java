package com.example.mobilesafer.db.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class AppLockDao {

	private Context context;

	public AppLockDao(Context context) {
		this.context = context;
	}

	/**
	 * ��Ӽ���Ӧ��
	 * 
	 * @param packageName
	 *            ������APP����
	 * @return �����-1��ʾû������ӳɹ�
	 */
	public boolean addLockApp(String packageName) {
		AppLockOpenHelper dao = new AppLockOpenHelper(context);
		SQLiteDatabase db = dao.getWritableDatabase();

		// �ж��Ƿ��Ѿ�����
		boolean flag = query(packageName);
		if (flag) {
			return false;
		}

		ContentValues values = new ContentValues();
		values.put("packagename", packageName);
		long insert = db.insert("addedappinfo", null, values);

		db.close();
		dao.close();

		if (insert == -1) {
			return false;
		}
		return true;
	}

	/**
	 * ɾ�����ݿ��е�����
	 * 
	 * @param packageName
	 * @return
	 */
	public boolean delete(String packageName) {
		AppLockOpenHelper dao = new AppLockOpenHelper(context);
		SQLiteDatabase db = dao.getWritableDatabase();

		int delete = db.delete("addedappinfo", "packagename = ?",
				new String[] { packageName });

		db.close();
		dao.close();

		if (delete == 0) {
			return false;
		}
		return true;
	}

	/**
	 * ��ѯ��ǰ�����Ƿ��Ѿ�����
	 * 
	 * @param packageName
	 * @return
	 */
	public boolean query(String packageName) {
		AppLockOpenHelper dao = new AppLockOpenHelper(context);
		SQLiteDatabase db = dao.getWritableDatabase();

		Cursor cursor = db.rawQuery(
				"select packagename from addedappinfo where packagename = ?",
				new String[] { packageName });
		boolean flag = cursor.moveToNext();

		cursor.close();
		db.close();
		dao.close();
		if (flag) {
			return true;
		} else {
			return false;
		}
	}
}
