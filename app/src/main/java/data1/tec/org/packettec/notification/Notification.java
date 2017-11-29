package data1.tec.org.packettec.notification;

public class Notification {
	public static void Notify() {
	NotificationCompat.Builder mBuilder =new NotificationCompat.Builder(this);
		    mBuilder.setSmallIcon(R.drawable.notification_icon)
		    mBuilder.setContentTitle("My notification")
		    mBuilder.setContentText("NUEVO MENSAJE");
	int mNotificationId = 001;
	NotificationManager mNotifyMgr =(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
	mNotifyMgr.notify(mNotificationId, mBuilder.build());
	}
}
