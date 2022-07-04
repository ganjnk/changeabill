/**
 * 
 */
package com.adp.changeabill.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.adp.changeabill.dto.CalculateChange;
import com.adp.changeabill.dto.ChangeResponse;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ganjinav
 *
 */
@Service
@Slf4j
public class BillService {

	@Value("${change.quarter}")
	private int quarter;

	@Value("${change.dime}")
	private int dime;

	@Value("${change.nickel}")
	private int nickel;

	@Value("${change.penny}")
	private int penny;

	public ChangeResponse getChange(long bill) {
		
		log.info("Entering getChange method in Bill Service.");

		ChangeResponse change = ChangeResponse.builder().build();

		if (bill > Math.round(0.01 * penny + 0.05 * nickel + 0.10 * dime + 0.25 * quarter)) {

			change.setNoChange("Sorry no change available at this moment for the given bill.");

			return change;
		}

		while (bill > 0) {

			if (quarter > 0) {

				log.info("Quarter");

				CalculateChange calculateChange = configureChange(bill, quarter, 0.25);

				bill = calculateChange.getBill();
				quarter = calculateChange.getCoinType();
				change.setQuarters(calculateChange.getResult());

			} else if (dime > 0) {

				log.info("Dime");

				CalculateChange calculateChange = configureChange(bill, dime, 0.10);

				bill = calculateChange.getBill();
				dime = calculateChange.getCoinType();
				change.setDimes(calculateChange.getResult());

			} else if (nickel > 0) {

				log.info("Nickel");

				CalculateChange calculateChange = configureChange(bill, nickel, 0.05);

				bill = calculateChange.getBill();
				nickel = calculateChange.getCoinType();
				change.setNickels(calculateChange.getResult());

			} else if (penny > 0) {

				log.info("Penny");

				CalculateChange calculateChange = configureChange(bill, penny, 0.01);

				bill = calculateChange.getBill();
				penny = calculateChange.getCoinType();
				change.setPennies(calculateChange.getResult());
			}
		}
		
		log.info("Exiting getChange method in Bill Service.");

		return change;
	}

	private CalculateChange configureChange(long bill, int coinType, double amount) {
		
		log.info("Entering configureChange method in Bill Service.");

		log.info("CoinType: {}", coinType);

		CalculateChange calculateChange = CalculateChange.builder().build();

		double enoughQuarters = coinType * amount;

		if (enoughQuarters > bill) {

			calculateChange.setResult(Math.round(bill / amount));

			calculateChange.setCoinType((int) (coinType - Math.round(bill / amount)));

			calculateChange.setBill(0);

		} else {

			calculateChange.setBill((int) (bill - enoughQuarters));

			calculateChange.setResult(coinType);

			calculateChange.setCoinType(0);

		}
		
		log.info("Exiting configureChange method in Bill Service.");

		return calculateChange;
	}

	public void resetChange() {
		
		log.info("Entering resetChange method in Bill Service.");
		
		this.quarter = 100;
		this.dime = 100;
		this.nickel = 100;
		this.penny = 100;
		
		log.info("Exiting resetChange method in Bill Service.");
	}
}