package com.devendra.crazymind;

import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.JobParametersValidator;

public class ParemetersValidator implements JobParametersValidator{

	@Override
	public void validate(JobParameters parameters) throws JobParametersInvalidException {

		System.out.println("Validation of Parameter will be done here.");
		JobParameter age = parameters.getParameters().get("age");
		
		if(Integer.parseInt((String) age.getValue()) > 15) {
			
			System.out.println("Age is greate than 15. Job can be performed.");
		}else{
			
			System.out.println("Age is less than 15. Job can not be performed.");
		}
	}		
}
