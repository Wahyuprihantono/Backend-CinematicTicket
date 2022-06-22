package com.bioskop.config;

import com.bioskop.scheduler.AnyJob;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.*;

    @Configuration
    public class QuartzScheduler {

        private final ApplicationContext applicationContext;

        @Autowired
        public QuartzScheduler(ApplicationContext applicationContext) {
            this.applicationContext = applicationContext;
        }

        @Bean
        public SpringBeanJobFactory springBeanJobFactory() {
            SpringBeanJobFactory jobFactory = new SpringBeanJobFactory();
            jobFactory.setApplicationContext(this.applicationContext);
            return jobFactory;
        }

        @Bean
        public SchedulerFactoryBean scheduler() {
            SchedulerFactoryBean schedulerFactory = new SchedulerFactoryBean();
            schedulerFactory.setJobFactory(springBeanJobFactory());
            JobDetail[] jobs = {
                    anyJobDetail().getObject()
            };
            Trigger[] triggers = {
                    anyJobTrigger().getObject()
            };
            schedulerFactory.setJobDetails(jobs);
            schedulerFactory.setTriggers(triggers);
            return schedulerFactory;
        }

        @Bean
        public JobDetailFactoryBean anyJobDetail() {
            JobDetailFactoryBean jobDetail = new JobDetailFactoryBean();
            jobDetail.setJobClass(AnyJob.class);
            jobDetail.setName("HandsonScheduleJob");
            jobDetail.setDescription("Job Hands on for quartz scheduler");
            jobDetail.setDurability(true);
            return jobDetail;
        }

        @Bean
        public CronTriggerFactoryBean anyJobTrigger() {
            CronTriggerFactoryBean cronTrigger = new CronTriggerFactoryBean();
            cronTrigger.setJobDetail(anyJobDetail().getObject());
            cronTrigger.setName("HandsonScheduleTrigger");
            // 0 0 11,13,15,17 * * MON-FRI
            cronTrigger.setCronExpression("0/10 * * ? * * *");
            return cronTrigger;
        }
    }
