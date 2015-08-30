package com.raspberrypi.homeAutomation;


import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

/**
 * Created by ACER on 8/20/2015.
 */
public class FirstService extends Service<HomeAutomationConfiguration> {

    public static int status[]=new int[5];
    public static void main(String[] args) throws Exception {
        new FirstService().run(args);
    }

    @Override
    public void initialize(Bootstrap<HomeAutomationConfiguration> bootstrap) {
        for(int i:status)
        {
            i=0;
        }

    }

    @Override
    public void run(HomeAutomationConfiguration homeAutomationConfiguration, Environment environment) throws Exception {
        environment.addResource(new LightStatus());
    }
}
