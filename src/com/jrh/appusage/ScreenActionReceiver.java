package com.jrh.appusage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class ScreenActionReceiver extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		String action = intent.getAction();
		if (action.equals(Intent.ACTION_SCREEN_ON)) {
			//������ط���...
		} else if (action.equals(Intent.ACTION_SCREEN_OFF)) {
			//�رռ�ط���...
		}
	}
}