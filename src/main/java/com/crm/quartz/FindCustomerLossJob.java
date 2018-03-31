package com.crm.quartz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.crm.service.ICustomerLossService;

/**
 * 
 * 查找客户流失，定时任务
 */
@Component
public class FindCustomerLossJob {
	@Autowired
	private ICustomerLossService customerLossService;
	
	//每天凌晨两点
	//@Scheduled(cron="0 0 2 * *")
	@Scheduled(cron="0/60 * * * * ?")//每隔60秒触发
	public void work() {
		customerLossService.checkCustomerLoss();
	}
	
}
