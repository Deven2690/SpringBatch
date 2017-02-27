package com.devendra.crazymind;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;

public class StepInterceptingListner implements StepExecutionListener{

	@Override
	public void beforeStep(StepExecution stepExecution) {

		System.out.println("######## Step Start ###########");
		System.out.println("Things to do before Step Execution");
		System.out.println("Step Name: "+stepExecution.getStepName());
		System.out.println("Step Start Time: "+stepExecution.getStartTime());
		

	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		
		System.out.println("************ Step End ************");
		System.out.println("Things to do after Step Execution");
		System.out.println("Step End Time: "+stepExecution.getEndTime()+" With Status "+stepExecution.getStatus());
		return stepExecution.getExitStatus();
	}

	
}
