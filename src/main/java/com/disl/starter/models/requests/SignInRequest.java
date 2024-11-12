package com.disl.starter.models.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SignInRequest {
	@NotBlank
	private String email;
	@NotBlank
	private String password;

}
