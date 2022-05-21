package com.wha.notifier;

import com.wha.notifier.factory.NotificationSenderFactory;
import com.wha.notifier.model.EmailNotification;
import com.wha.notifier.model.PhoneNotification;
import com.wha.notifier.model.SocialMediaNotification;
import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class NotifierTest {

  Notifier notifier = new Notifier();

  @BeforeEach
  @SneakyThrows
  void setUp() {
    Infra.reset();
  }

  @AfterEach
  @SneakyThrows
  void tearDown() {
    Infra.reset();
  }

  @Test
  @SneakyThrows
  void emailNotification() {
    //given
    String username = "pablo";
    String email = "pablo@mail.com";
    NotificationSender notification = NotificationSenderFactory.newEmailNotification(username, email);
    //when
    notifier.sendNotification(notification);
    //then
    assertThat(Infra.emailQueue).hasSize(1)
      .element(0)
      .returns(username, EmailNotification::getUsername)
      .returns(email, EmailNotification::getEmail)
      .extracting(EmailNotification::getContent)
      .matches(strings -> assertContent(strings, List.of("email sent to : ", username)));

    assertThat(Infra.phoneQueue).isEmpty();
    assertThat(Infra.socialMediaQueue).isEmpty();
  }

  @Test
  @SneakyThrows
  void phoneNotification() {
    //given
    String username = "pablo";
    Integer phoneNumber = 613938746;
    NotificationSender notification = NotificationSenderFactory.newPhoneNotification(username, phoneNumber);
    //when
    notifier.sendNotification(notification);
    //then
    assertThat(Infra.phoneQueue).hasSize(1)
      .element(0)
      .returns(username, PhoneNotification::getUsername)
      .returns(phoneNumber, PhoneNotification::getPhoneNumber)
      .extracting(PhoneNotification::getContent)
      .matches(strings -> assertContent(strings, List.of("sms sent to : ", username)));

    assertThat(Infra.emailQueue).isEmpty();
    assertThat(Infra.socialMediaQueue).isEmpty();
  }

  @Test
  @SneakyThrows
  void socialMediaNotification() {
    //given
    String username = "pablo";
    String socialMediaUsername = "diabloXXX";
    NotificationSender notification = NotificationSenderFactory.newSocialMediaNotification(username, socialMediaUsername);
    //when
    notifier.sendNotification(notification);
    //then
    assertThat(Infra.socialMediaQueue).hasSize(1)
      .element(0)
      .returns(username, SocialMediaNotification::getUsername)
      .returns(socialMediaUsername, SocialMediaNotification::getSocialMediaUsername)
      .extracting(SocialMediaNotification::getContent)
      .matches(strings -> assertContent(strings, List.of("social media notification sent to : ", username)));

    assertThat(Infra.emailQueue).isEmpty();
    assertThat(Infra.phoneQueue).isEmpty();
  }

  @Test
  @SneakyThrows
  void emailAndPhoneNotification() {
    //given
    String username = "pablo";
    String email = "pablo@mail.com";
    Integer phoneNumber = 613938746;
    NotificationSender notification = NotificationSenderFactory.newEmailAndPhoneNotification(username, email, phoneNumber);
    //when
    notifier.sendNotification(notification);
    //then
    //then
    assertThat(Infra.phoneQueue).hasSize(1)
      .element(0)
      .returns(username, PhoneNotification::getUsername)
      .returns(phoneNumber, PhoneNotification::getPhoneNumber)
      .extracting(PhoneNotification::getContent)
      .matches(strings -> assertContent(strings, List.of("sms sent to : ", username)));
    assertThat(Infra.emailQueue).hasSize(1)
      .element(0)
      .returns(username, EmailNotification::getUsername)
      .returns(email, EmailNotification::getEmail)
      .extracting(EmailNotification::getContent)
      .matches(strings -> assertContent(strings, List.of("email sent to : ", username)));
    assertThat(Infra.socialMediaQueue).isEmpty();
  }

  @Test
  @SneakyThrows
  void emailAndSocialMediaNotification() {
    //given
    String username = "pablo";
    String email = "pablo@mail.com";
    String socialMediaUsername = "diabloXXX";
    NotificationSender notification = NotificationSenderFactory.newEmailAndSocialMediaNotification(username, email, socialMediaUsername);
    //when
    notifier.sendNotification(notification);
    //then
    assertThat(Infra.emailQueue).hasSize(1)
      .element(0)
      .returns(username, EmailNotification::getUsername)
      .returns(email, EmailNotification::getEmail)
      .extracting(EmailNotification::getContent)
      .matches(strings -> assertContent(strings, List.of("email sent to : ", username)));
    assertThat(Infra.socialMediaQueue).hasSize(1)
      .element(0)
      .returns(username, SocialMediaNotification::getUsername)
      .returns(socialMediaUsername, SocialMediaNotification::getSocialMediaUsername)
      .extracting(SocialMediaNotification::getContent)
      .matches(strings -> assertContent(strings, List.of("social media notification sent to : ", username)));
    assertThat(Infra.phoneQueue).isEmpty();
  }

  @Test
  @SneakyThrows
  void emailAndSocialMediaAndPhoneNotification() {
    //given
    String username = "pablo";
    String email = "pablo@mail.com";
    String socialMediaUsername = "diabloXXX";
    Integer phoneNumber = 613938746;
    NotificationSender notification = NotificationSenderFactory.newEmailAndSocialMediaAndPhoneNotification(username, email, socialMediaUsername, phoneNumber);
    //when
    notifier.sendNotification(notification);
    //then
    assertThat(Infra.emailQueue).hasSize(1)
      .element(0)
      .returns(username, EmailNotification::getUsername)
      .returns(email, EmailNotification::getEmail)
      .extracting(EmailNotification::getContent)
      .matches(strings -> assertContent(strings, List.of("email sent to : ", username)));
    assertThat(Infra.socialMediaQueue).hasSize(1)
      .element(0)
      .returns(username, SocialMediaNotification::getUsername)
      .returns(socialMediaUsername, SocialMediaNotification::getSocialMediaUsername)
      .extracting(SocialMediaNotification::getContent)
      .matches(strings -> assertContent(strings, List.of("social media notification sent to : ", username)));
    assertThat(Infra.phoneQueue).hasSize(1)
      .element(0)
      .returns(username, PhoneNotification::getUsername)
      .returns(phoneNumber, PhoneNotification::getPhoneNumber)
      .extracting(PhoneNotification::getContent)
      .matches(strings -> assertContent(strings, List.of("sms sent to : ", username)));

  }

  private Boolean assertContent(List<String> list1, List<String> list2) {
    if (list1.size() != list2.size()) {
      return false;
    }

    for (var i = 0; i < list1.size(); i++) {
      String str1 = list1.get(i);
      String str2 = list2.get(i);
      if (!str1.equals(str2)) {
        return false;
      }
    }
    return true;
  }

}