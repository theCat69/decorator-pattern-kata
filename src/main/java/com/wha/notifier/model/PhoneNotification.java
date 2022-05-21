package com.wha.notifier.model;

import com.wha.notifier.Infra;
import lombok.Getter;

import java.io.IOException;
import java.util.List;

@Getter
public class PhoneNotification extends BaseNotification {

  private final Integer phoneNumber;

  public PhoneNotification(String username, Integer phoneNumber) {
    super(username, List.of("sms sent to : ", username));
    this.phoneNumber = phoneNumber;
  }

  @Override
  public void sendNotification() throws IOException {
    Infra.phoneQueue.add(this);
  }

}
