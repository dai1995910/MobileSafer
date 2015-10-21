package com.example.mobilesafer.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mobilesafer.R;

/**
 * 页面一
 * @author admin
 *
 */
public class Setup1Activity extends BaseSettingActivity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_setup1);
		
	}
	
	
	//跳转到下一个页面
	public void next(View v) {
		showNextPage();
	}


	@Override
	public void showPreviousPage() {}


	@Override
	public void showNextPage() {
		startActivity(new Intent(this , Setup2Activity.class));
		finish();
		overridePendingTransition(R.anim.tran_in, R.anim.tran_out);
	}

}
