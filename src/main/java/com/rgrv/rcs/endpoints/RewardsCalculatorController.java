package com.rgrv.rcs.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rgrv.rcs.service.impl.RewardsCalculatorServiceImpl;
import com.rgrv.rcs.vo.CalculatedRewardsResponse;
import com.rgrv.rcs.vo.ResponseWrapper;

@RestController
@RequestMapping(path = "/rewardTotal")
public class RewardsCalculatorController {

	@Autowired
	private RewardsCalculatorServiceImpl rewardsCalculatorService;
	
	@GetMapping("/customer/{custId}/last3Months")
	public ResponseWrapper getLastThreeMonthsRewardsGiven(@PathVariable Integer custId) {
		ResponseWrapper response = new ResponseWrapper();
		CalculatedRewardsResponse crr = rewardsCalculatorService.getLastThreeMonthsRewardsGiven(custId);
		if(crr.getCustomerId()==null) {
			response.setError(true);
			response.setErrorMessage("Customer id provided is not found!");
		}else {
			response.setResult(crr);
		}
		return response;
	}
}
