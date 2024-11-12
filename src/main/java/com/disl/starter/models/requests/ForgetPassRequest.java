package com.disl.starter.models.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ForgetPassRequest {
  String pass1;
  String pass2;
  String token;
}
