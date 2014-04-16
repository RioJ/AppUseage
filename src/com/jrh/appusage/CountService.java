package com.jrh.appusage;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.widget.Toast;

public class CountService extends Service{
	private Handler handler = new Handler();
	private Timer timer;
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		if (timer == null) {
			timer = new Timer();
			timer.scheduleAtFixedRate(new RefreshTask(), 0, 1000);
		}
		return super.onStartCommand(intent, flags, startId);
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		// Service����ֹ��ͬʱҲֹͣ��ʱ����������
		timer.cancel();
		timer = null;
	}
	
	class RefreshTask extends TimerTask {
		String curPkgName;
		@Override
		public void run() {
			handler.post(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					AppInfoService appInfoService = new AppInfoService(getApplicationContext());
					AppInfo appInfo = CountManager.getTopActivity(getApplicationContext());
					
					//CountManager.curPkgName = appInfo.getPkgname();
					
					if(!appInfo.getPkgname().equals(curPkgName)){
						//System.out.println("�ı���");
						curPkgName = appInfo.getPkgname();
						//���������ݿ����
						appInfoService.dealWithIt(appInfo);
						appInfoService.closeDB();
					}
				}
			});
		}
	}
	
}