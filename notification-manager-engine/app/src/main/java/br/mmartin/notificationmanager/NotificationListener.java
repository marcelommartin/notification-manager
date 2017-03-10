package br.mmartin.notificationmanager;

import android.app.Notification;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Vibrator;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.util.Log;

/**
 * Created by marcelo on 12/01/17.
 */

public class NotificationListener extends NotificationListenerService {

    @Override
    public IBinder onBind(Intent intent) {
        Log.i("onBind", "Listener bound to notification service");
        return super.onBind(intent);
    }

    @Override
    public void onListenerConnected() {
        requestListenerHints(HINT_HOST_DISABLE_EFFECTS);
        Log.i("onListenerConnected", "Notification effects disabled");
    }

    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {
        if (isEffectAllowed(sbn.getNotification())) {
            requestListenerHints(0);
            Log.d("onNotificationPosted", "Notification effects enabled");
        } else {
            Log.d("onNotificationPosted", "Notification effects suppressed");
        }
    }

    private boolean isEffectAllowed(Notification notification) {
        String numberOrigin = null;

        if (notification.category != null) {//CATEGORY_SOCIAL CATEGORY_EMAIL CATEGORY_ALARM
            if (notification.category.equals(Notification.CATEGORY_CALL)
                    || notification.category.equals(Notification.CATEGORY_MESSAGE)) {
                if (notification.extras != null) {
                    String[] peoples = notification.extras.getStringArray(Notification.EXTRA_PEOPLE);
                    for (String people : peoples) {
                        if (people.equals("991341592")) {
                            return true;
                        }
                    }
                }
            } else {

            }
        }
        return false;
    }

    @Override
    public void onListenerHintsChanged(int hints) {
        if (hints == 0) {
            requestListenerHints(HINT_HOST_DISABLE_EFFECTS);
            Log.i("onListenerHintsChanged", "Notification effects disabled");
        }
    }

    private String getCallingNumber(String people){
        String[] parts = people.split(":");
        return parts.length > 1 ? parts[1] : "";
    }
}
