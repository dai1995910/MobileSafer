package com.example.mobilesafer.activity;

import com.example.mobilesafer.R;
import com.example.mobilesafer.utils.UIUtils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;



public class EnterPwdActivity extends Activity implements OnClickListener {

	private EditText et_pwd;
	private Button bt_0;
	private Button bt_1;
	private Button bt_2;
	private Button bt_3;
	private Button bt_4;
	private Button bt_5;
	private Button bt_6;
	private Button bt_7;
	private Button bt_8;
	private Button bt_9;
	private Button bt_clean_all;
	private Button bt_delete;
	private Button bt_ok;
	private String packageName;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_set_pwd);
		initUI();
	}

	private void initUI() {

		Intent intent = getIntent();

		if (intent != null) {
			packageName = intent.getStringExtra("packageName");
		}

		et_pwd = (EditText) findViewById(R.id.et_pwd);

		// 隐藏当前的键盘
		et_pwd.setInputType(InputType.TYPE_NULL);

		bt_0 = (Button) findViewById(R.id.bt_0);
		bt_1 = (Button) findViewById(R.id.bt_1);
		bt_2 = (Button) findViewById(R.id.bt_2);
		bt_3 = (Button) findViewById(R.id.bt_3);
		bt_4 = (Button) findViewById(R.id.bt_4);
		bt_5 = (Button) findViewById(R.id.bt_5);
		bt_6 = (Button) findViewById(R.id.bt_6);
		bt_7 = (Button) findViewById(R.id.bt_7);
		bt_8 = (Button) findViewById(R.id.bt_8);
		bt_9 = (Button) findViewById(R.id.bt_9);

		bt_ok = (Button) findViewById(R.id.bt_ok);

		bt_ok.setOnClickListener(this);

		bt_clean_all = (Button) findViewById(R.id.bt_clean_all);

		bt_delete = (Button) findViewById(R.id.bt_delete);
		// 清空
		bt_clean_all.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				et_pwd.setText("");
			}
		});
		// 删除
		bt_delete.setOnClickListener(new OnClickListener() {

			private String str;

			@Override
			public void onClick(View v) {

				str = et_pwd.getText().toString();

				if (str.length() == 0) {
					return;
				}

				et_pwd.setText(str.substring(0, str.length() - 1));

			}
		});

		bt_0.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String str = et_pwd.getText().toString();
				et_pwd.setText(str + bt_0.getText().toString());
			}
		});
		bt_1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String str = et_pwd.getText().toString();
				et_pwd.setText(str + bt_1.getText().toString());
			}
		});
		bt_2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String str = et_pwd.getText().toString();
				et_pwd.setText(str + bt_2.getText().toString());
			}
		});
		bt_3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String str = et_pwd.getText().toString();
				et_pwd.setText(str + bt_3.getText().toString());
			}
		});
		bt_4.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String str = et_pwd.getText().toString();
				et_pwd.setText(str + bt_4.getText().toString());
			}
		});
		bt_5.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String str = et_pwd.getText().toString();
				et_pwd.setText(str + bt_5.getText().toString());
			}
		});
		bt_6.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String str = et_pwd.getText().toString();
				et_pwd.setText(str + bt_6.getText().toString());
			}
		});
		bt_7.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String str = et_pwd.getText().toString();
				et_pwd.setText(str + bt_7.getText().toString());
			}
		});
		bt_8.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String str = et_pwd.getText().toString();
				et_pwd.setText(str + bt_8.getText().toString());
			}
		});
		bt_9.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String str = et_pwd.getText().toString();
				et_pwd.setText(str + bt_9.getText().toString());
			}
		});
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bt_ok:
			String result = et_pwd.getText().toString();
			if ("123".equals(result)) {
				// 如果密码正确。说明是自己人
				/**
				 * 是自己家人。不要拦截他
				 */
				System.out.println("密码输入正确");

				Intent intent = new Intent();
				// 发送广播。停止保护
				intent.setAction("com.itheima.mobileguard.stopprotect");
				// 跟狗说。现在停止保护短信
				intent.putExtra("packageName", packageName);

				sendBroadcast(intent);

				finish();

			} else {
				UIUtils.showToast(EnterPwdActivity.this, "密码错误");
			}

			break;

		}

	}

	// 监听当前页面的后退健
	// <intent-filter>
	// <action android:name="android.intent.action.MAIN" />
	// <category android:name="android.intent.category.HOME" />
	// <category android:name="android.intent.category.DEFAULT" />
	// <category android:name="android.intent.category.MONKEY"/>
	// </intent-filter>
	@Override
	public void onBackPressed() {
		// 当用户输入后退健 的时候。我们进入到桌面
		Intent intent = new Intent();
		intent.setAction("android.intent.action.MAIN");
		intent.addCategory("android.intent.category.HOME");
		intent.addCategory("android.intent.category.DEFAULT");
		intent.addCategory("android.intent.category.MONKEY");
		startActivity(intent);
	}
}
