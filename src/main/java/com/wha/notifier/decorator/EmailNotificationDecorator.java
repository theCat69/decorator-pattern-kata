package com.wha.notifier.decorator;

import com.wha.notifier.Infra;
import com.wha.notifier.model.BaseNotification;
import com.wha.notifier.model.EmailNotification;

import java.io.IOException;

public class EmailNotificationDecorator extends EmailNotification {

  private final BaseNotification baseNotification;

  public EmailNotificationDecorator(BaseNotification baseNotification, String email) {
    super(baseNotification.getUsername(), email);
    if(baseNotification instanceof EmailNotification) {
      throw new IllegalArgumentException();
    }
    this.baseNotification = baseNotification;
  }

  @Override
  public void sendNotification() throws IOException {
    baseNotification.sendNotification();
    Infra.emailQueue.add(this);
  }

}
