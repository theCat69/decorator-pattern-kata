package com.wha.notifier.model;

import com.wha.notifier.Infra;
import lombok.Getter;

import java.io.IOException;
import java.util.List;

@Getter
public class SocialMediaNotification extends BaseNotification {

  private final String socialMediaUsername;

  public SocialMediaNotification(String username, String socialMediaUsername) {
    super(username, List.of("social media notification sent to : ", username));
    this.socialMediaUsername = socialMediaUsername;
  }

  @Override
  public void sendNotification() throws IOException {
    Infra.socialMediaQueue.add(this);
  }
}
