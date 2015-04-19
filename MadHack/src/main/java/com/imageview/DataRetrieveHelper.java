package com.imageview;

import com.data.ImageDataDAO;
import com.data.ImageDataModel;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by karthik on 3/1/15.
 */
public class DataRetrieveHelper {

    public static ImageDataModel getDataFromDatabase (int index) {

        ImageDataDAO dataDAO = new ImageDataDAO();
        ImageDataModel datModel = dataDAO.getImageData(index);

        //For Table size 1 i.e., one record
        int pageID = datModel.getImgPageIdList().get(0);
        File filePath = new File("src/main/webapp/images/"+pageID+"/");

       // final String FILE_DIR = "src/main/webapp/images/"+pageID+"";

        if(filePath.isDirectory()==false){
            System.out.println("Directory does not exists : ");
            return null;
        }
        System.out.println("files in the path are "+filePath.listFiles());

        String [] fileList = filePath.list();
        String path = "";
        List list = new ArrayList();
        for (String file : fileList) {
            System.out.println("file is "+file.toString());
            list.add(file.toString());
            datModel.setImgJPGList(list);
        }
        return datModel;
    }


    public static ImageDataModel getPageIndex (int index) {

        ImageDataDAO dataDAO = new ImageDataDAO();
        //ImageDataModel datModel = new ImageDataModel();
        ImageDataModel datModel = dataDAO.getImageData(index);

        //int tableSize = datModel.getImgPageIdList().size();


        //For Table size 1 i.e., one record
        int pageID = datModel.getImgPageIdList().get(0);
        File filePath = new File("src/main/webapp/images/"+pageID+"/");

        if(filePath.isDirectory()==false){
            System.out.println("Directory does not exists : ");
            return null;
        }
        System.out.println("files in the path are "+filePath.listFiles());

        String [] fileList = filePath.list();
        String path = "";
        List list = new ArrayList();
        for (String file : fileList) {
            System.out.println("file is "+file.toString());
            list.add(file.toString());
            datModel.setImgJPGList(list);
        }
        return datModel;
    }

}
