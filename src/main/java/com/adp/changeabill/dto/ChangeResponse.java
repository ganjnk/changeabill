/**
 * 
 */
package com.adp.changeabill.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ganjinav
 *
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChangeResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3823162363405496691L;

	@JsonInclude(value = Include.NON_DEFAULT)
	@Builder.Default
	@JsonProperty("quarters")
	private long quarters = 0;
	
	@JsonInclude(value = Include.NON_DEFAULT)
	@Builder.Default
	@JsonProperty("dimes")
	private long dimes = 0;
	
	@JsonInclude(value = Include.NON_DEFAULT)
	@Builder.Default
	@JsonProperty("nickels")
	private long nickels = 0;
	
	@JsonInclude(value = Include.NON_DEFAULT)
	@Builder.Default
	@JsonProperty("pennies")
	private long pennies = 0;
	
	@JsonInclude(value = Include.NON_NULL)
	@JsonProperty("noChange")
	private String noChange;
	
}