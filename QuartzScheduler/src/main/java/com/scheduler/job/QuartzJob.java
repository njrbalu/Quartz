package com.scheduler.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;


import com.scheduler.process.SynchronizeBean;


public class QuartzJob extends QuartzJobBean {
	
	private SynchronizeBean synchronizeBean;

	@Override
	protected void executeInternal(JobExecutionContext arg0)
			throws JobExecutionException {
		
		synchronizeBean.synchronize();

	}

	public void setSynchronizeBean(SynchronizeBean synchronizeBean) {
		this.synchronizeBean = synchronizeBean;
	}

}
