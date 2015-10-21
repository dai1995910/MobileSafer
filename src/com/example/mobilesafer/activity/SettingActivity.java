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
		
		
		//设置自动更新
		sivUpdate = (SettingItemView) findViewById(R.id.siv_update);
//		sivUpdate.setTitle("自动更新设置");
//		sivUpdate.setDesc("自动更新已关闭");
		sivUpdate.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(sivUpdate.isChecked()) {
					sivUpdate.setChecked(false);
//					sivUpdate.setDesc("自动更新已关闭");
					//注意commit
					sp.edit().putBoolean("auto_update", false).commit();
					
				} else {
					sivUpdate.setChecked(true);
//					sivUpdate.setDesc("自动更新已开启");
					sp.edit().putBoolean("auto_update", true).commit();
				}
			}
		});
		
		//获取保存的信息
		Boolean autoUpdate = sp.getBoolean("auto_update", true);
		if(autoUpdate) {
			sivUpdate.setChecked(true);
//			sivUpdate.setDesc("自动更新已开启");
		} else {
			sivUpdate.setChecked(false);
//			sivUpdate.setDesc("自动更新已关闭");
		}
	}
}
