package com.kimjieun99.ch01.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//import lombok.Getter;
//import lombok.Setter;
import lombok.ToString;

//@Setter
//@Getter
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Member {

  private String id;
  private String name;
  private String addr;
}
