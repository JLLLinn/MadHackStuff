package com.imageview;

import com.data.*;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sun.jersey.api.view.Viewable;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import java.util.List;
import java.util.UUID;

/**
 * Radiology Case Reports Controller Class!
 *
 */
@Path("/hello")
public class App 
{
//    @GET
//    @Path("{name}")
//    public String sayHello(@PathParam("name") String name){
//        StringBuilder stringBuilder = new StringBuilder("This is karthik | Hello ");
//        stringBuilder.append(name).append("!");
//        getDataForDisplay();
//        return stringBuilder.toString();
//    }

    @GET
    @Path("/index")
    public Viewable index(
            @Context HttpServletRequest request,
            @Context HttpServletResponse response) throws Exception
    {
        request.setAttribute("key", "value");
        return new Viewable("/jsps/HelloWorld.html", null);
    }

    @GET
    @Path("{imageId}/saveData")
    public Viewable saveData(@PathParam("imageId") String imageId, @QueryParam("text") String text,@QueryParam("height") String height,@QueryParam("width") String width,@QueryParam("top") String top,@QueryParam("left") String left,@QueryParam("id") String id ) throws Exception
    {

        AnnotationDataModel annotationDataModel = new AnnotationDataModel();
        annotationDataModel.setText(text);
        annotationDataModel.setHeight(height);
        annotationDataModel.setWidth(width);
        annotationDataModel.setTop(top);
        annotationDataModel.setLeft(left);
        annotationDataModel.setId(id);
        annotationDataModel.setImageId(imageId);

        //DatabaseCall and persist
        String result = DBSaveAnnotation.saveAnnotationToDatabase(annotationDataModel);
        if(result.equals("success")){
            System.out.println("Annotation Inserted Successfully");
        }else{
            System.out.println("Error Occured during Annotation Insertion");
        }

        return new Viewable("/jsps/HelloWorld.html", null);
    }

    @GET
    @Path("{imageId}/getAnnotationData")
    @Produces("application/json")
    public String getAnnotationData(@PathParam("imageId") String imageId) throws Exception
    {
        String title = null;
        List<AnnotationDataModel> annotationListDataModel = RetrieveAnnotationData.getAnnotatedText(imageId);
        Gson gson = new Gson();
        title = gson.toJson(annotationListDataModel);
        return title;
    }

    @GET
    @Path("{imageId}/deleteData")
    public Viewable deleteData(@PathParam("imageId") String imageId,@QueryParam("id") String noteid) throws Exception
    {
        System.out.println("$$$$$imageid passed is "+imageId);
        System.out.println("$$$$$ noteid passed is "+noteid);

       String result = DeleteAnnotationNote.deleteImage(noteid);
        if(result.equals("success")){
            System.out.println("Annotation Deleted Successfully");
        }else{
            System.out.println("Error Occured during Annotation Deletion");
        }

        return new Viewable("/jsps/HelloWorld.html", null);
    }

    @POST
    @Path("/pagination")
    public String paginationCall(String incomingData) {

        String stringData = null;
        JsonObject jsonObject = (JsonObject)new JsonParser().parse(incomingData);

        System.out.println("curindex "+jsonObject.get("x"));
        System.out.println("next or prev is "+jsonObject.get("y"));

        ImageDataModel datModel = new ImageDataModel();

        //Next Value
        if(jsonObject.get("y").toString().equals(String.valueOf(1))){
            datModel = DataRetrieveHelper.getDataFromDatabase(Integer.valueOf(jsonObject.get("x").toString())+1);
        }
        //Prev Value
        if(jsonObject.get("y").toString().equals(String.valueOf(0))){
            datModel = DataRetrieveHelper.getDataFromDatabase(Integer.valueOf(jsonObject.get("x").toString())-1);
        }

        Gson gson = new Gson();
        stringData = gson.toJson(datModel);
        return stringData;
    }


    @POST
    @Path("/pageIndex")
    public String goToPageIndex(String incomingData) {

        String stringData = null;
        JsonObject jsonObject = (JsonObject)new JsonParser().parse(incomingData);

        System.out.println("pageId "+jsonObject.get("x"));


        //Page Value
        ImageDataModel datModel = DataRetrieveHelper.getPageIndex(jsonObject.get("x").getAsInt());


        Gson gson = new Gson();
        stringData = gson.toJson(datModel);
        return stringData;
    }


    @GET
    @Path("/title")
    @Produces("application/json")
    public String getDataForDisplay() {

        String title = null;

        //First time login show first page index values
        int index = 1;
        ImageDataModel datModel = DataRetrieveHelper.getDataFromDatabase(index);

        Gson gson = new Gson();

        title = gson.toJson(datModel);

        return title;
    }
}
