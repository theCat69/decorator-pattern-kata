package com.wha.notifier.model;

import com.wha.notifier.NotificationSender;
import lombok.*;

import java.io.IOException;
import java.util.List;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
public class BaseNotification implements NotificationSender {
  protected final String username;
  protected List<String> content;

  @Override
  public void sendNotification() throws IOException {
  }
}
