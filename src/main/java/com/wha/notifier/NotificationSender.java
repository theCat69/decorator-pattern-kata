package com.wha.notifier;

import java.io.IOException;

public interface NotificationSender {
  void sendNotification() throws IOException;
}
