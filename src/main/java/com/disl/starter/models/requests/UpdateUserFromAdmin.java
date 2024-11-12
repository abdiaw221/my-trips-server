package com.disl.starter.models.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateUserFromAdmin {
  private String name;
  private Long userId;
}
