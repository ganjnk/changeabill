/**
 * 
 */
package com.adp.changeabill.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author ganjinav
 *
 */
@Data
@Builder
public class CalculateChange {

	private long bill;
	
	private int coinType;
	
	private long result;
}