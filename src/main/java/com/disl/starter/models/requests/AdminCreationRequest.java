package com.disl.starter.models.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AdminCreationRequest {

  @NotBlank private String name;

  @NotBlank private String email;

  @NotBlank private String password;

  @NotBlank private Long roleId;
}
