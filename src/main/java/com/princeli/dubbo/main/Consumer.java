package com.princeli.dubbo.main;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.princeli.dubbo.consumer.LogicThread;
import com.princeli.dubbo.util.SpringBeanHelper;


public class Consumer {

	// 初始延迟1秒
	private static long INIT_DELAY = 1;

	// 30秒周期
	private static long PERIOD = 5;

	// 初始化1个定时线程池
	private static ScheduledExecutorService service = Executors
			.newScheduledThreadPool(1);


	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "consumer.xml" });

		SpringBeanHelper.setApplicationContext(context);

		service.scheduleAtFixedRate(new LogicThread(), INIT_DELAY,
				PERIOD, TimeUnit.SECONDS);

		context.start();

	}
}
