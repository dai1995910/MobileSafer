package com.example.mobilesafer.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mobilesafer.R;

public class AToolsActivity extends Activity {

	
	/**
	 * �߼�����ҳ��
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_atools);
	}
	
	public void queryPhoneNum(View v) {
		Intent i = new Intent(this , AddressActivity.class);
		startActivity(i);
	}
}
