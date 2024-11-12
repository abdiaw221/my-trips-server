package com.disl.starter.models.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ChangePasswordRequest {
  private String email;
  private String previousPassword;
  private String newPassword;
}
