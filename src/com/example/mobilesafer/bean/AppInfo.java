package com.example.mobilesafer.bean;

import android.graphics.drawable.Drawable;

public class AppInfo {
	private String apkName;
	private long apkSize;
	/*
	 * ͼ��
	 */
	private Drawable icon;
	/*
	 * �ǲ����û�����
	 */
	private boolean userApp;
	/*
	 * ���λ��
	 */
	private boolean inRom;
	/*
	 * ����
	 */
	private String apkPackageName;
	public String getApkName() {
		return apkName;
	}
	public void setApkName(String apkName) {
		this.apkName = apkName;
	}
	public long getApkSize() {
		return apkSize;
	}
	public void setApkSize(long apkSize) {
		this.apkSize = apkSize;
	}
	public Drawable getIcon() {
		return icon;
	}
	public void setIcon(Drawable icon) {
		this.icon = icon;
	}
	public boolean isUserApp() {
		return userApp;
	}
	public void setUserApp(boolean userApp) {
		this.userApp = userApp;
	}
	public boolean isInRom() {
		return inRom;
	}
	public void setInRom(boolean inRom) {
		this.inRom = inRom;
	}
	public String getApkPackageName() {
		return apkPackageName;
	}
	public void setApkPackageName(String apkPackageName) {
		this.apkPackageName = apkPackageName;
	}
	@Override
	public String toString() {
		return "AppInfo [apkName=" + apkName + ", apkSize=" + apkSize
				+ ", icon=" + icon + ", userApp=" + userApp + ", inRom="
				+ inRom + ", apkPackageName=" + apkPackageName + "]";
	}
	
	
}