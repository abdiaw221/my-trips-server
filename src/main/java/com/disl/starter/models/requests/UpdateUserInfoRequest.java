package com.disl.starter.models.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateUserInfoRequest {
  @NotBlank private String name;
}
