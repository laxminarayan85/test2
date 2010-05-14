package com.efi.printsmith.scheduler;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.jobs.ee.ejb.EJBInvokerJob;

public class QuartzServlet extends GenericServlet {

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
//		System.out.println("Scheduling Job ..");
//		JobDetail jd = new JobDetail("Test Quartz", "My Test Job",
//				EJBInvokerJob.class);
//		jd.getJobDataMap().put("ejb", "java:comp/env/ejb/TestEJB");
//		jd.getJobDataMap().put("method", "yourMethod");
//		Object[] jdArgs = new Object[0];
//		jd.getJobDataMap().put("args", jdArgs);
//		CronTrigger cronTrigger = new CronTrigger("Test Quartz", "Test Quartz");
//
//		try {
//			String cronExpr = null;
//			// Get the cron Expression as an Init parameter
//			cronExpr = getInitParameter("cronExpr");
//			System.out.println(cronExpr);
//			cronTrigger.setCronExpression(cronExpr);
//			Scheduler sched = StdSchedulerFactory.getDefaultScheduler();
//			sched.scheduleJob(jd, cronTrigger);
//			System.out.println("Job scheduled now ..");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
	}

	public String getServletInfo() {
		return null;
	}
}
