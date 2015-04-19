package com.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by karthik on 3/11/15.
 */
public class RetrieveAnnotationData {

    public static List<AnnotationDataModel> getAnnotatedText(String imageid) {


        List<AnnotationDataModel> annotationListDataModel = new ArrayList<AnnotationDataModel>();
        try {

            DatabaseHelper databaseHelper = new DatabaseHelper();

            Connection connection = databaseHelper.initConnectionPool();
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from ImageIntegration.imageannotations where imageid = " + imageid);

                while (resultSet.next()) {
                    AnnotationDataModel annotationDataModel = new AnnotationDataModel();
                    annotationDataModel.setTop(resultSet.getString("top"));
                    annotationDataModel.setLeft(resultSet.getString("annoleft"));
                    annotationDataModel.setWidth(resultSet.getString("width"));
                    annotationDataModel.setHeight(resultSet.getString("height"));
                    annotationDataModel.setText(resultSet.getString("annotext"));
                    annotationDataModel.setId(resultSet.getString("id"));
                    annotationDataModel.setEditable("true");
                    annotationListDataModel.add(annotationDataModel);
                }

        } catch (SQLException exception) {
            exception.printStackTrace();
            System.out.println("Exception in RetrieveAnnotationData");
        }
        return annotationListDataModel;
    }
}