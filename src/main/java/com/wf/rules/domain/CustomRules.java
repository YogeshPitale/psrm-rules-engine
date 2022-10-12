package com.wf.rules.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class CustomRules {
	private String nm;
	private String pmtRail;
	private Boolean throttleValue;
	private Integer dynamicAmount;
	private float throttleMaxAvailable;
	private double debitAmt;
	private double cap;
}
