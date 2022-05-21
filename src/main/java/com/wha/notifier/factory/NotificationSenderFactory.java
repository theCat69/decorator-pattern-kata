package com.wha.notifier.factory;

import com.wha.notifier.NotificationSender;
import com.wha.notifier.decorator.EmailNotificationDecorator;
import com.wha.notifier.decorator.PhoneNotificationDecorator;
import com.wha.notifier.decorator.SocialMediaNotificationDecorator;
import com.wha.notifier.model.BaseNotification;
import com.wha.notifier.model.EmailNotification;
import com.wha.notifier.model.PhoneNotification;
import com.wha.notifier.model.SocialMediaNotification;

public class NotificationSenderFactory {

  public static NotificationSender newEmailNotification(String username, String email) {
    return new EmailNotification(username, email);
  }

  public static NotificationSender newPhoneNotification(String username, Integer phoneNumber) {
    return new PhoneNotification(username, phoneNumber);
  }

  public static NotificationSender newSocialMediaNotification(String username, String socialMediaUsername) {
    return new SocialMediaNotification(username, socialMediaUsername);
  }

  public static NotificationSender newEmailAndPhoneNotification(String username, String email, Integer phoneNumber) {
    BaseNotification baseNotification = new BaseNotification(username);
    baseNotification = new EmailNotificationDecorator(baseNotification, email);
    return new PhoneNotificationDecorator(baseNotification, phoneNumber);
  }

  public static NotificationSender newEmailAndSocialMediaNotification(String username,String email, String socialMediaUsername) {
    BaseNotification baseNotification = new BaseNotification(username);
    baseNotification = new EmailNotificationDecorator(baseNotification, email);
    return new SocialMediaNotificationDecorator(baseNotification, socialMediaUsername);
  }

  public static NotificationSender newEmailAndSocialMediaAndPhoneNotification(String username,
                                                                              String email,
                                                                              String socialMediaUsername,
                                                                              Integer phoneNumber) {
    BaseNotification baseNotification = new BaseNotification(username);
    baseNotification = new EmailNotificationDecorator(baseNotification, email);
    baseNotification = new SocialMediaNotificationDecorator(baseNotification, socialMediaUsername);
    return new PhoneNotificationDecorator(baseNotification, phoneNumber);

  }
}
