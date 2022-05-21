package com.wha.notifier.model;

import com.wha.notifier.Infra;
import lombok.Getter;

import java.io.IOException;
import java.util.List;

@Getter
public class EmailNotification extends BaseNotification {

  private final String email;

  public EmailNotification(String username, String email) {
    super(username, List.of("email sent to : ", username));
    this.email = email;
  }

  @Override
  public void sendNotification() throws IOException {
    Infra.emailQueue.add(this);
  }
}
