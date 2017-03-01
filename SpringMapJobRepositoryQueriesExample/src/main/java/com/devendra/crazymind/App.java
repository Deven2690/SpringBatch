package com.devendra.crazymind;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

@Controller
public class App {

	public static void main(String[] args) {
		
		App app = new App();
		app.run();
	}

	private void run() {

		String[] springConfig = { "spring/batch/jobs/job-extract-users.xml" };

		ApplicationContext context = new ClassPathXmlApplicationContext(springConfig);

		JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
		Job job = (Job) context.getBean("testJob");

		JobExplorer jobExplorer = (JobExplorer) context.getBean("jobExplore");
		
		try {

			JobParameters param = new JobParametersBuilder().addString("age", "17").toJobParameters();
			//JobParameters param = new JobParametersBuilder().addString("name", "user_c").toJobParameters();
			
			JobExecution execution = jobLauncher.run(job, param);
			System.out.println("Exit Status : " + execution.getStatus());
			System.out.println("Exit Status : " + execution.getAllFailureExceptions());

		} catch (Exception e) {
			e.printStackTrace();

		}

		System.out.println("Job Information by making query: Gte Job Names Stored in DB: "+jobExplorer.getJobNames());
		
		System.out.println("Done");
	}

}
