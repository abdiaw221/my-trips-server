package com.disl.starter.models.requests;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateVerifyStatusRequest {

  @Schema(required = true)
  private long userId;

  @Schema(required = true)
  private boolean verify;
}
