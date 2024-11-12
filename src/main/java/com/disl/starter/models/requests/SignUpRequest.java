package com.disl.starter.models.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SignUpRequest {
  private String email;
  private String password;
  private String name;
}
