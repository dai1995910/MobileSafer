package com.example.mobilesafer;

import java.util.List;
import java.util.Random;

import android.test.AndroidTestCase;

import com.example.mobilesafer.bean.AppInfo;
import com.example.mobilesafer.bean.BlackNumberInfo;
import com.example.mobilesafer.db.dao.BlackNumberDao;
import com.example.mobilesafer.engine.AppInfos;

public class Test extends AndroidTestCase {

//	public void testAdd() {
//		Random random = new Random();
//		long number = 1517885;
//		for(int i = 0; i < 200; i++) {
//			number = number + i;
//			BlackNumberDao dao = new BlackNumberDao(getContext());
//			int mode = random.nextInt(3) + 1;
//			dao.add(number + "", mode + "");
//		}
//	}
//	
//	public void testDelete() {
//		BlackNumberDao dao = new BlackNumberDao(getContext());
//		if(dao.delete("1517885")) {
//			System.out.println("success");
//			
//		} else {
//			System.out.println("failed");
//		}
//	}
//	
//	public void testChange() {
//		BlackNumberDao dao = new BlackNumberDao(getContext());
//		if(dao.changeNumberMode("1517886", 1+"") ) {
//			System.out.println("success");
//		}
//	}
//	
//	public void testFindMode() {
//		BlackNumberDao dao = new BlackNumberDao(getContext());
//		String i = dao.findMode("1517886");
//		System.out.println(i);
//	}
//	
//	
//	public void testFindAll() {
//		BlackNumberDao dao = new BlackNumberDao(getContext());
//		List<BlackNumberInfo> list = dao.findAll();
//		for(BlackNumberInfo b : list) {
//			System.out.println(b.getNumber() + " : " + b.getMode());
//		}
//	}
	
	public void testAppInfo() {
		List<AppInfo> appInfos = AppInfos.getAppInfos(getContext());
		System.out.println("1");
		for(AppInfo info : appInfos) {
			System.out.println("程序名:" + info.getApkName());
			System.out.println("程序大小:" + info.getApkSize());
			System.out.println("程序包名:" + info.getApkPackageName());
			System.out.println("用户应用::" + info.isUserApp());
			System.out.println("在rom：" + info.isInRom());
			System.out.println("----------------------------------");
		}
	}
}
