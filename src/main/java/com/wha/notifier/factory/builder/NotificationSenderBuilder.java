package com.wha.notifier.factory.builder;

import com.wha.notifier.NotificationSender;
import com.wha.notifier.decorator.EmailNotificationDecorator;
import com.wha.notifier.decorator.PhoneNotificationDecorator;
import com.wha.notifier.decorator.SocialMediaNotificationDecorator;
import com.wha.notifier.model.BaseNotification;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class NotificationSenderBuilder {

  private BaseNotification baseNotification;

  public static NotificationSenderBuilder builder(String username) {
    return new NotificationSenderBuilder(new BaseNotification(username));
  }

  public NotificationSenderBuilder withPhone(Integer phoneNumber) {
    baseNotification = new PhoneNotificationDecorator(baseNotification, phoneNumber);
    return this;
  }

  public NotificationSenderBuilder withEmail(String email) {
    baseNotification = new EmailNotificationDecorator(baseNotification, email);
    return this;
  }

  public NotificationSenderBuilder withSocialMedia(String socialMediaUsername) {
    baseNotification = new SocialMediaNotificationDecorator(baseNotification, socialMediaUsername);
    return this;
  }

  public NotificationSender build() {
    return baseNotification;
  }
}
