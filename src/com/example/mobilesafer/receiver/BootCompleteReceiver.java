package com.example.mobilesafer.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

public class BootCompleteReceiver extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		//��ȡ���洢��sim,ע�ⶼ�Ǵ�context�л�ȡ
		SharedPreferences sp = context.getSharedPreferences("config", context.MODE_PRIVATE);
		boolean isChecked = sp.getBoolean("protect", false);
		if(!isChecked) {
			return;
		}
		String sim = sp.getString("sim", null);
		
		
		if(!TextUtils.isEmpty(sim)) {
			TelephonyManager te  = (TelephonyManager) context.getSystemService(context.TELEPHONY_SERVICE);
			String currentSim = te.getSimSerialNumber();
			if(currentSim.equals(sim)) {
				System.out.println("��û�б�");
			} else {
				
				System.out.println("sim�Ѿ����л������ͱ�������~");
			}
		}
	}

}
