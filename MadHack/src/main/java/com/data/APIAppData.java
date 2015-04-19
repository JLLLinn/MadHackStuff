package com.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by karthik on 4/18/15.
 */
public class APIAppData {

    public static List<APIDataModel> getAPIData() {

        List<APIDataModel> apiDataModelsList = new ArrayList<APIDataModel>();

        try
        {
            DatabaseHelper databaseHelper = new DatabaseHelper();

            Connection connection = databaseHelper.initConnectionPool();
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM apicrawldata");

            while (resultSet.next()) {
                APIDataModel apiDataModel = new APIDataModel();
                apiDataModel.setId(resultSet.getString("id"));
                apiDataModel.setApiname(resultSet.getString("apiname"));
                apiDataModel.setDescription(resultSet.getString("description"));
                apiDataModel.setCategory(resultSet.getString("category"));
                apiDataModel.setUpdatedDate(resultSet.getString("updateddate"));

                apiDataModelsList.add(apiDataModel);
            }

        }catch (SQLException exception) {
            exception.printStackTrace();
            System.out.println("Exception in RetrieveAnnotationData");
        }
        return apiDataModelsList;
    }

    public static List<APIDataModel> getAPIDataFromCategory(String category) {


        List<APIDataModel> apiDataModelsList = new ArrayList<APIDataModel>();

        try
        {
            DatabaseHelper databaseHelper = new DatabaseHelper();

            Connection connection = databaseHelper.initConnectionPool();
            Statement statement = connection.createStatement();
            String query = "select * from apicrawldata where category = " +"'"+ category+"'";

            System.out.println("query is "+query);

            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                APIDataModel apiDataModel = new APIDataModel();
                apiDataModel.setId(resultSet.getString("id"));
                apiDataModel.setApiname(resultSet.getString("apiname"));
                apiDataModel.setDescription(resultSet.getString("description"));
                apiDataModel.setCategory(resultSet.getString("category"));
                apiDataModel.setUpdatedDate(resultSet.getString("updateddate"));

                apiDataModelsList.add(apiDataModel);
            }

        }catch (SQLException exception) {
            exception.printStackTrace();
            System.out.println("Exception in RetrieveAnnotationData");
        }
        return apiDataModelsList;
    }

    public static List<APIDataModel> getAllCategories () {


        List<APIDataModel> apiDataModelsList = new ArrayList<APIDataModel>();

        try
        {
            DatabaseHelper databaseHelper = new DatabaseHelper();

            Connection connection = databaseHelper.initConnectionPool();
            Statement statement = connection.createStatement();
            String query = "SELECT category FROM apicrawldata group by category";

            System.out.println("query is "+query);

            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                APIDataModel apiDataModel = new APIDataModel();
                apiDataModel.setCategory(resultSet.getString("category"));

                apiDataModelsList.add(apiDataModel);
            }

        }catch (SQLException exception) {
            exception.printStackTrace();
            System.out.println("Exception in RetrieveAnnotationData");
        }
        return apiDataModelsList;
    }



}
