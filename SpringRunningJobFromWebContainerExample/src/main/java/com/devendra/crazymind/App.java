package com.devendra.crazymind;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/batch")
public class App {

	@Autowired
	JobLauncher jobLauncher;
	
	@Autowired
	Job job;
	
	@RequestMapping(value="/execute", method = RequestMethod.GET)
	private String run(ModelMap modelMap,HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

		JobExecution execution = null;
		try {

			JobParameters param = new JobParametersBuilder().addString("age", "17").toJobParameters();
		
			execution = jobLauncher.run(job, param);
			System.out.println("Exit Status : " + execution.getStatus());
			System.out.println("Exit Status : " + execution.getAllFailureExceptions());

		} catch (Exception e) {
			e.printStackTrace();

		}

		System.out.println("Done");
		
		if(execution.getStatus() == BatchStatus.COMPLETED) {
			
			modelMap.put("msg", "Batch Execution done successfully");
		}else {
			
			modelMap.put("msg", "Batch Execution failed.");
		}
		
		return "batchMessage";
	}

}
