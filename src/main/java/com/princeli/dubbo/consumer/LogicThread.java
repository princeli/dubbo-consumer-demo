package com.princeli.dubbo.consumer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

import com.princeli.dubbo.provider.DemoService;
import com.princeli.dubbo.util.SpringBeanHelper;

public class LogicThread implements Runnable{

	private static AtomicInteger ai = new AtomicInteger(1);
	
	@Override
	public void run() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		DemoService demoService = (DemoService) SpringBeanHelper.getBean("demoService");
		String hello = demoService.sayHello("world");


		System.out.println(sdf.format(new Date()) + " = " + ai.getAndIncrement() + " : " + hello);
	}

}
