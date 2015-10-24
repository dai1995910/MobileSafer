package com.example.mobilesafer.activity;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.mobilesafer.R;
import com.example.mobilesafer.receiver.LockScreenDeviceAdminReceive;

/**
 * ҳ��һ
 * 
 * @author admin
 *
 */
public class Setup1Activity extends BaseSettingActivity {

	private ComponentName mDeviceAdminSample;
	private DevicePolicyManager mDPM;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_setup1);

		mDeviceAdminSample = new ComponentName(this,
				LockScreenDeviceAdminReceive.class);
		mDPM = (DevicePolicyManager) getSystemService(Context.DEVICE_POLICY_SERVICE);

	}



	@Override
	public void showPreviousPage() {
	}

	@Override
	public void showNextPage() {
		System.out.println("0");
		// �ж��Ƿ񼤻�
		if (mDPM.isAdminActive(mDeviceAdminSample)) {
			startActivity(new Intent(this, Setup2Activity.class));
			finish();
			overridePendingTransition(R.anim.tran_in, R.anim.tran_out);
		} else {
			actionAdmin();
		}
	}

	/*
	 * ����
	 */
	private void actionAdmin() {
		// ����һ����ͼ�����ڴ���������ע�����
		Intent intent = new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
		// ָ����Ҫ����һ���豸������
		intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN,
				mDeviceAdminSample);
		// ��ӽ�����Ϣ
		intent.putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION, "ע��һ������");
		// �����豸������ע��
		startActivity(intent);
	}

}
