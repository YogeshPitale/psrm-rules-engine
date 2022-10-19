package com.wf.rules.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class TransactionDetails {
	private String nm;
	private String pmtRail;
	private Boolean throttleValue;
	private Integer dynamicAmount;
	private float throttleMaxAvailable;
	private double debitAmt;
	private double cap;
}
