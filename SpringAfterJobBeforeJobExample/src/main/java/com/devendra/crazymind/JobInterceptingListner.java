package com.devendra.crazymind;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class JobInterceptingListner implements JobExecutionListener{

	@Override
	public void beforeJob(JobExecution jobExecution) {
		
		System.out.println("Process Data Before Start Executing Job");
		System.out.println("Job ID: "+jobExecution.getJobId());
		System.out.println("Job Name: "+jobExecution.getJobInstance().getJobName());
		System.out.println("Job Parameter: "+jobExecution.getJobParameters().getParameters());
        System.out.println("#############################################################"); 
	}

	@Override
	public void afterJob(JobExecution jobExecution) {

	    System.out.println("***************************************************************"); 
		System.out.println("Batch Execution result:");
		
		if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
			
			System.out.println("Batch Executed Succesfully");
		}
		if(jobExecution.getStatus() == BatchStatus.FAILED) {
			
			System.out.println("Batch Executecution Failed");
		}
		
	}

	
	
}
