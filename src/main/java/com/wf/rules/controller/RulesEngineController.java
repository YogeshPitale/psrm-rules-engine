package com.wf.rules.controller;

import com.wf.rules.domain.TransactionDetails;
import com.wf.rules.domain.TransactionStatus;
import lombok.extern.slf4j.Slf4j;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class RulesEngineController {
	@Autowired
	private KieContainer kieContainer;

	@PostMapping("/v1/getTransactionStatus")
	public ResponseEntity<TransactionStatus> checkIfTransactionToBePutOnHold(@RequestBody TransactionDetails transactionDetails) {
		TransactionStatus transactionStatus = new TransactionStatus();
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.setGlobal("transactionStatus", transactionStatus);
		kieSession.insert(transactionDetails);
		kieSession.fireAllRules();
		kieSession.dispose();
		log.info("Transaction params: "+transactionDetails.toString());
		log.info("Transaction Hold status: "+ transactionStatus.getStatusOnHold());
		log.info(("-------------------------------------------------"));
		return ResponseEntity.status(HttpStatus.OK).body(transactionStatus);
	}

}
