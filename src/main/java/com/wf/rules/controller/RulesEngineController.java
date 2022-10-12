package com.wf.rules.controller;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wf.rules.domain.CustomRules;
import com.wf.rules.domain.RulesList;

@RestController
public class RulesEngineController {
	@Autowired
	private KieContainer kieContainer;

	@PostMapping("/v1/getTransactionStatus")
	public ResponseEntity<RulesList> getRulesList(@RequestBody CustomRules cRules) {
		RulesList rulesList = new RulesList();
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.setGlobal("rulesList", rulesList);
		kieSession.insert(cRules);
		kieSession.fireAllRules();
		kieSession.dispose();
		return ResponseEntity.status(HttpStatus.OK).body(rulesList);
	}

}
