package com.raspberrypi.homeAutomation;

import com.mongodb.DBCursor;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by ACER on 8/26/2015.
 */
@Path("HomeAutomation")
@Produces(MediaType.APPLICATION_JSON)
public class LightStatus {

    //MongoDbHandler mgdb;
    @GET
    @Path("/GetStatus")
    public String getStatus(){
        String statusString="";
        /*try {
            mgdb = new MongoDbHandler();
            mgdb.initialize();
            DBCursor cursor = mgdb.table.find();
            try {
                while(cursor.hasNext()) {
                    System.out.println(cursor.next());
                }
            } finally {
                cursor.close();
            }

            for(int s : status){
                statusString+=s;
        }
        }catch (Exception e)
        {
            System.out.println("ITS NOT WORKING:"+e);
        }*/
        for(int i:FirstService.status)
        {
            statusString+=i+" ";
        }
        return statusString;
    }

    @GET
    @Path("/light{lightNo}")
    public String updateStatus(@PathParam("lightNo") int lightNo)
    {
        try
        {
            FirstService.status[lightNo-1]=FirstService.status[lightNo-1]==1?0:1;
            return "Success";
        }
        catch (Exception e)
        {
            return "error"+e.toString();
        }
    }
}
