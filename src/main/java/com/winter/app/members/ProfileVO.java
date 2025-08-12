package com.winter.app.members;

import com.winter.app.commons.FileVO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ProfileVO extends FileVO {

	private String username;
}
