package th.co.maximus.batch;

import java.text.SimpleDateFormat;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.stereotype.Component;

import th.co.maximus.auth.config.ConfigureQuartz;
import th.co.maximus.bean.MasterDatasBean;
import th.co.maximus.constants.Constants;
import th.co.maximus.dao.MasterDatasDao;
import th.co.maximus.service.CallEpisOnlineService;

@Component
@DisallowConcurrentExecution
public class OfflineBatch implements Job {
	
	@Autowired
	private MasterDatasDao masterDatasDao;
	
	@Autowired
	CallEpisOnlineService callEpisOnlineService;
	
	SimpleDateFormat format = new SimpleDateFormat(Constants.DateTime.DATE_FORMAT.concat(" "+Constants.DateTime.DB_TIME_FORMAT), Constants.localeEN);
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println(context.getTrigger().getKey().getName());
		if(Constants.BATCH.JOB_1.equals(context.getTrigger().getKey().getName())) {
			System.out.println("JOB_1");
//			callEpisOnlineService.callOnlineSyncMasterData();
		}else if(Constants.BATCH.JOB_2.equals(context.getTrigger().getKey().getName())) {
			System.out.println("JOB_2");
//			callEpisOnlineService.callOnlineSyncMapGL();
		}else if(Constants.BATCH.JOB_3.equals(context.getTrigger().getKey().getName())) {
			System.out.println("JOB_3");
//			callEpisOnlineService.callOnlineSyncUser();
		}else if(Constants.BATCH.JOB_4.equals(context.getTrigger().getKey().getName())) {
			System.out.println("JOB_4");
		}
	}
	
	@Bean(name = "jobWithSimpleTriggerBean")
    public JobDetailFactoryBean sampleJob() {
        return ConfigureQuartz.createJobDetail(this.getClass());
    }

    @Bean(name = "jobWithSimpleTriggerBeanTrigger")
	public CronTriggerFactoryBean sampleJobTrigger(@Qualifier("jobWithSimpleTriggerBean") JobDetail jobDetail) throws Exception {
	MasterDatasBean masterDatas = masterDatasDao.findByGrop(Constants.MasterData.TRIGGER_GOUP, Constants.MasterData.KEYCODE.TRIGGER_M);
	System.out.println(111);
    	return ConfigureQuartz.createCronTrigger(jobDetail, masterDatas.getValue());
    }
    
    @Bean(name = "jobWithSimpleTriggerBeanTrigger2")
  	public CronTriggerFactoryBean sampleJobTrigger2(@Qualifier("jobWithSimpleTriggerBean") JobDetail jobDetail) throws Exception {
  	MasterDatasBean masterDatas = masterDatasDao.findByGrop(Constants.MasterData.TRIGGER_GOUP, Constants.MasterData.KEYCODE.TRIGGER_W);
  	System.out.println(222);
  		return ConfigureQuartz.createCronTrigger(jobDetail, masterDatas.getValue());
  }
    
    @Bean(name = "jobWithSimpleTriggerBeanTrigger3")
  	public CronTriggerFactoryBean sampleJobTrigger3(@Qualifier("jobWithSimpleTriggerBean") JobDetail jobDetail) throws Exception {
  	MasterDatasBean masterDatas = masterDatasDao.findByGrop(Constants.MasterData.TRIGGER_GOUP, Constants.MasterData.KEYCODE.TRIGGER_D);
  	System.out.println(333);
  		return ConfigureQuartz.createCronTrigger(jobDetail, masterDatas.getValue());
  }
    
    @Bean(name = "jobWithSimpleTriggerBeanTrigger4")
  	public CronTriggerFactoryBean sampleJobTrigger4(@Qualifier("jobWithSimpleTriggerBean") JobDetail jobDetail) throws Exception {
  	MasterDatasBean masterDatas = masterDatasDao.findByGrop(Constants.MasterData.TRIGGER_GOUP, Constants.MasterData.KEYCODE.TRIGGER_T);
  	System.out.println(444);
  		return ConfigureQuartz.createCronTrigger(jobDetail, masterDatas.getValue());
  }
    
//    @Scheduled(fixedRate = 5000)
//    public void reportCurrentTime() {
//        log.info("The time is now {}", dateFormat.format(new Date()));
//        
//        new java.util.Timer().schedule( 
//                new java.util.TimerTask() {
//                    @Override
//                    public void run() {
//                        System.out.println("xxx");
//                    }
//                }, 
//                x 
//        );
//        
//    }
    
//    public String formateCorn(Date date) {
//    	Calendar cal = Calendar.getInstance();
//    	cal.setTime(date);
//    	int year = cal.get(Calendar.YEAR);
//    	int month = cal.get(Calendar.MONTH);
//    	int day = cal.get(Calendar.DAY_OF_MONTH);
//    	
//    	String result = "";
//    	System.out.println(date.getSeconds());
//    	System.out.println(date.getMinutes());
//    	System.out.println(date.getHours());
//    	LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//    	System.out.println(localDate);
//    	return null;
//    }
    
    
}
