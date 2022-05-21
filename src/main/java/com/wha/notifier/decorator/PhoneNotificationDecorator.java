package com.wha.notifier.decorator;

import com.wha.notifier.Infra;
import com.wha.notifier.model.BaseNotification;
import com.wha.notifier.model.PhoneNotification;

import java.io.IOException;

public class PhoneNotificationDecorator extends PhoneNotification {

  private final BaseNotification baseNotification;

  public PhoneNotificationDecorator(BaseNotification baseNotification, Integer phoneNumber) {
    super(baseNotification.getUsername(), phoneNumber);
    if(baseNotification instanceof PhoneNotification) {
      throw new IllegalArgumentException();
    }
    this.baseNotification = baseNotification;
  }

  @Override
  public void sendNotification() throws IOException {
    baseNotification.sendNotification();
    Infra.phoneQueue.add(this);
  }
}
