package com.wf.rules.domain;

import java.util.ArrayList;
import lombok.Data;

@Data
public class TransactionStatus {

	private Boolean statusOnHold;
	private ArrayList<String> onHoldReasonsList;

	public TransactionStatus() {
		super();
		this.onHoldReasonsList = new ArrayList<>();
		this.statusOnHold = false;
	}

	public void addOnHoldReason(String reason) {
		this.onHoldReasonsList.add(reason);
	}
}
