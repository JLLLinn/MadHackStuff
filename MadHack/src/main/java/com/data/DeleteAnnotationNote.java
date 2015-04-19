package com.data;

import java.sql.*;
import java.sql.SQLException;

/**
* Created by karthik on 3/18/15.
*/
public class DeleteAnnotationNote {

    public static String deleteImage(String annotationId){

        boolean inserted = true;
        String annotID = ""+annotationId+"";

        try {

            DatabaseHelper databaseHelper = new DatabaseHelper();
            Connection connection = databaseHelper.initConnectionPool();
            Statement statement = connection.createStatement();

            String query = "SELECT ImageIntegration.imageannotations.index FROM ImageIntegration.imageannotations where ImageIntegration.imageannotations.id = '" + annotID + "' ";

            System.out.println("QUery is "+query);

            ResultSet resultSet = statement.executeQuery(query);

            System.out.println("Resultset is "+resultSet);

            int indexid = 0;
            while(resultSet.next()){
            indexid = resultSet.getInt("index");
            }

            System.out.println("indexid is "+indexid);

            String deleteSql = "delete from imageintegration.imageannotations where imageintegration.imageannotations.index =" +indexid;
            statement.executeUpdate(deleteSql);

        }catch (SQLException ex){
            inserted = false;
            ex.printStackTrace();
        }

        if(inserted) {
            return "success";
        }else
        {
            return "fail";
        }
    }
}
