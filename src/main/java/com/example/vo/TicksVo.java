package com.example.vo;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter @Setter
public class TicksVo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Timestamp tick;

}
