package com.wha.notifier;

import java.io.IOException;

public class Notifier {
  public void sendNotification(NotificationSender notificationSender) throws IOException {
    notificationSender.sendNotification();
  }
}
