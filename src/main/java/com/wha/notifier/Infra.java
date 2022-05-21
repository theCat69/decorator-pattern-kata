package com.wha.notifier;

import com.wha.notifier.model.EmailNotification;
import com.wha.notifier.model.PhoneNotification;
import com.wha.notifier.model.SocialMediaNotification;

import java.util.ArrayList;
import java.util.List;

public class Infra {
  public static List<EmailNotification> emailQueue = new ArrayList<>();
  public static List<PhoneNotification> phoneQueue = new ArrayList<>();
  public static List<SocialMediaNotification> socialMediaQueue = new ArrayList<>();

  public static void reset() {
    emailQueue = new ArrayList<>();
    phoneQueue = new ArrayList<>();
    socialMediaQueue = new ArrayList<>();
  }
}
