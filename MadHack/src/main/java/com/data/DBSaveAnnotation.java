package com.data;

import java.sql.*;
import java.util.UUID;

/**
 * Created by karthik on 3/9/15.
 */
public class DBSaveAnnotation {

    public static String saveAnnotationToDatabase(AnnotationDataModel annotationDataModel){

        Statement statement = null;
        boolean inserted = true;
        try {

            DatabaseHelper databaseHelper = new DatabaseHelper();
            Connection connection = databaseHelper.initConnectionPool();

            UUID randomId = UUID.randomUUID();
            if(annotationDataModel.getId().equals("new")){
                annotationDataModel.setId(String.valueOf(randomId));

                String insertQuery = "insert into imageintegration.imageannotations (annotext,height,width,top,annoleft,id,imageid) values (?,?,?,?,?,?,?); ";

                PreparedStatement preparedStmt = connection.prepareStatement(insertQuery);

                preparedStmt.setString(1, annotationDataModel.getText());
                preparedStmt.setString(2, annotationDataModel.getHeight());
                preparedStmt.setString(3, annotationDataModel.getWidth());
                preparedStmt.setString(4, annotationDataModel.getTop());
                preparedStmt.setString(5, annotationDataModel.getLeft());
                preparedStmt.setString(6, annotationDataModel.getId());
                preparedStmt.setString(7, annotationDataModel.getImageId());

                preparedStmt.execute();
                System.out.println("ANNOTATION INSERTED");


            }else {

                String updateQuery = "update imageintegration.imageannotations set annotext = ?, height = ?,width = ?,top = ?,annoleft = ?,imageid = ? where imageintegration.imageannotations.id = '"+annotationDataModel.getId()+"'; ";

                System.out.println("updatequery is "+updateQuery);
                PreparedStatement preparedStmt = connection.prepareStatement(updateQuery);

                preparedStmt.setString(1, annotationDataModel.getText());
                preparedStmt.setString(2, annotationDataModel.getHeight());
                preparedStmt.setString(3, annotationDataModel.getWidth());
                preparedStmt.setString(4, annotationDataModel.getTop());
                preparedStmt.setString(5, annotationDataModel.getLeft());
                preparedStmt.setString(6, annotationDataModel.getImageId());

                preparedStmt.executeUpdate();
                System.out.println("ANNOTATION UPDATED");

            }

        }catch(SQLException ex){
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
