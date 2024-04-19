package com.health.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.health.util.SequenceNumberGenerator;
@Component
public class Scheduler {
//	// 0 * * ? * *  for one minute.  * * * ? * *  for one second 
//	 @Scheduled(cron = "0 */2 * ? * *")
//	   public void cronJobSch() {
//	      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
//	      Date now = new Date();
//	      String strDate = sdf.format(now);
//	      System.out.println("Java cron job expression:: " + strDate);
//	      //System.out.println(" sequence Value :" + SequenceNumberGenerator.getNext());
//	   }
}
