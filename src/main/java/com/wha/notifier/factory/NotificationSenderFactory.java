package com.wha.notifier.factory;

import com.wha.notifier.NotificationSender;
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
    return () -> {};
  }

  public static NotificationSender newEmailAndSocialMediaNotification(String username,String email, String socialMediaUsername) {
    return () -> {};
  }

  public static NotificationSender newEmailAndSocialMediaAndPhoneNotification(String username, String email, String socialMediaUsername, Integer phoneNumber) {
    return () -> {};
  }
}
