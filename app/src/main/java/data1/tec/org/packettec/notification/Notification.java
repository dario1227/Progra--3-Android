package data1.tec.org.packettec.notification;
import android.support.v4.app.NotificationCompat;
import datos1.tec.org.packettec.R;
public class Notification {

	private void presentNotification(int visibility, int icon, String title, String text) {
		Notification notification = new NotificationCompat.Builder(this)
				.setCategory(Notification.CATEGORY_MESSAGE)
				.setContentTitle(title)
				.setContentText(text)
				.setSmallIcon(icon)
				.setAutoCancel(true)
				.setVisibility(visibility).build();
		NotificationManager notificationManager =
				(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		notificationManager.notify(notification_id, notification);
	}

	private void presentHeadsUpNotification(int visibility, int icon, String title, String text) {
		Intent notificationIntent = new Intent(Intent.ACTION_VIEW);
		notificationIntent.setData(Uri.parse("http://www.wgn.com"));
		PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);

		Notification notification = new NotificationCompat.Builder(this)
				.setCategory(Notification.CATEGORY_PROMO)
				.setContentTitle(title)
				.setContentText(text)
				.setSmallIcon(icon)
				.setAutoCancel(true)
				.setVisibility(visibility)
				.addAction(android.R.drawable.ic_menu_view, getString(R.string.view_details), contentIntent)
				.setContentIntent(contentIntent)
				.setPriority(Notification.PRIORITY_HIGH)
				.setVibrate(new long[]{1000, 1000, 1000, 1000, 1000}).build();
		NotificationManager notificationManager =
				(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		notificationManager.notify(notification_id, notification);
	}
}