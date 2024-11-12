package com.disl.starter.models.requests;

import com.disl.starter.enums.RoleType;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RoleUpdateRequest {

	private long id;
	private long[] previlegeId;
	private RoleType roleType;
	private String description;

	@NotBlank
	private String roleName;

}
