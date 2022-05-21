package com.wha.notifier.decorator;

import com.wha.notifier.Infra;
import com.wha.notifier.model.BaseNotification;
import com.wha.notifier.model.SocialMediaNotification;

import java.io.IOException;

public class SocialMediaNotificationDecorator extends SocialMediaNotification {
  private final BaseNotification baseNotification;

  public SocialMediaNotificationDecorator(BaseNotification baseNotification, String socialMediaUsername) {
    super(baseNotification.getUsername(), socialMediaUsername);
    if(baseNotification instanceof SocialMediaNotification) {
      throw new IllegalArgumentException();
    }
    this.baseNotification = baseNotification;
  }

  @Override
  public void sendNotification() throws IOException {
    baseNotification.sendNotification();
    Infra.socialMediaQueue.add(this);
  }
}
