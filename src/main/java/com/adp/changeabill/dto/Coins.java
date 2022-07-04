/**
 * 
 */
package com.adp.changeabill.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.adp.changeabill.service.YamlPropertySourceFactory;

/**
 * @author ganjinav
 *
 */
@Configuration
@ConfigurationProperties(prefix = "change")
@PropertySource(value = "classpath:application.yml", factory = YamlPropertySourceFactory.class)
public class Coins {

	private int quarter;
	
	private int dime;
	
	private int nickel;
	
	private int penny;

	/**
	 * @return the quarter
	 */
	public int getQuarter() {
		return quarter;
	}

	/**
	 * @param quarter the quarter to set
	 */
	public void setQuarter(int quarter) {
		this.quarter = quarter;
	}

	/**
	 * @return the dime
	 */
	public int getDime() {
		return dime;
	}

	/**
	 * @param dime the dime to set
	 */
	public void setDime(int dime) {
		this.dime = dime;
	}

	/**
	 * @return the nickel
	 */
	public int getNickel() {
		return nickel;
	}

	/**
	 * @param nickel the nickel to set
	 */
	public void setNickel(int nickel) {
		this.nickel = nickel;
	}

	/**
	 * @return the penny
	 */
	public int getPenny() {
		return penny;
	}

	/**
	 * @param penny the penny to set
	 */
	public void setPenny(int penny) {
		this.penny = penny;
	}
	
	
}
