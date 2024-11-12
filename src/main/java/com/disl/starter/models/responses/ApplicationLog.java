package com.disl.starter.models.responses;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class ApplicationLog {
  private String fileName;
  private Date lastModified;
  private String fileSize;
}
