package com.disl.starter.models.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ForgetPasswordRequest {
  private String token;
  private String newPassword;
}
