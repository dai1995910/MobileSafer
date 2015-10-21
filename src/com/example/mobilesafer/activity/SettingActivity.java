package com.example.mobilesafer.activity;

import com.example.mobilesafer.R;
import com.example.mobilesafer.view.SettingItemView;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class SettingActivity extends Activity {

	private SettingItemView sivUpdate;
//	private SharedPreferences sp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.setting_layout);

		final SharedPreferences sp = getSharedPreferences("config", MODE_PRIVATE);
		
		
		//�����Զ�����
		sivUpdate = (SettingItemView) findViewById(R.id.siv_update);
//		sivUpdate.setTitle("�Զ���������");
//		sivUpdate.setDesc("�Զ������ѹر�");
		sivUpdate.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(sivUpdate.isChecked()) {
					sivUpdate.setChecked(false);
//					sivUpdate.setDesc("�Զ������ѹر�");
					//ע��commit
					sp.edit().putBoolean("auto_update", false).commit();
					
				} else {
					sivUpdate.setChecked(true);
//					sivUpdate.setDesc("�Զ������ѿ���");
					sp.edit().putBoolean("auto_update", true).commit();
				}
			}
		});
		
		//��ȡ�������Ϣ
		Boolean autoUpdate = sp.getBoolean("auto_update", true);
		if(autoUpdate) {
			sivUpdate.setChecked(true);
//			sivUpdate.setDesc("�Զ������ѿ���");
		} else {
			sivUpdate.setChecked(false);
//			sivUpdate.setDesc("�Զ������ѹر�");
		}
	}
}
