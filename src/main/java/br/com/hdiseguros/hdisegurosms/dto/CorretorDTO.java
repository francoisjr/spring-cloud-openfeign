package br.com.hdiseguros.hdisegurosms.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CorretorDTO {
	private String name;
	private String document;
	private String code;
	private String createDate;
	private String active;
	private String commissionRate;

}
