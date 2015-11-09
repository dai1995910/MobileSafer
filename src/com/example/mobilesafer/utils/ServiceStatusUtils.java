package com.example.mobilesafer.utils;

import java.util.List;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.Context;

public class ServiceStatusUtils {
	public static boolean isServiceRunning(Context context , String SN) {
		
		//��ȡ����
		ActivityManager manager = (ActivityManager) context.getSystemService(context.ACTIVITY_SERVICE);
		List<RunningServiceInfo> runningServices = manager.getRunningServices(100);
		
		System.out.println("���룺" + SN);
		
		for(RunningServiceInfo  runningServiceInfo :  runningServices) {
			String serviceName = runningServiceInfo.service.getClassName();
			System.out.println("�����ģ�" + serviceName);
			if(serviceName.equals(SN)) {
				System.out.println("����true");
				return true;
			}
		}
		System.out.println("����false");
		return false;
	}
}
