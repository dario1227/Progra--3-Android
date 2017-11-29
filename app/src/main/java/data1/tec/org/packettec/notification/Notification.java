package data1.tec.org.packettec.notification;
import android.support.v4.app.NotificationCompat;
import datos1.tec.org.packettec.R;
public class Notification {
	NotificationCompat.Builder mBuilder =new NotificationCompat.Builder(this);
		    mBuilder.setSmallIcon(R.drawable.newmessage);
		    mBuilder.setContentTitle("My notification");
		    mBuilder.setContentText("NUEVO MENSAJE");
	int mNotificationId = 001;
	NotificationManager mNotifyMgr =(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
	mNotifyMgr.notify(mNotificationId, mBuilder.build());
	}
}
