package com.imageview;

import com.data.APIAppData;
import com.data.APIDataModel;
import com.data.AnnotationDataModel;
import com.data.RetrieveAnnotationData;
import com.google.gson.Gson;
import com.sun.jersey.api.view.Viewable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import java.util.List;

/**
 * Created by karthik on 4/18/15.
 */
@Path("/APIApp")
public class APIApp  {

    @GET
    @Path("/home")
    public Viewable index(
            @Context HttpServletRequest request,
            @Context HttpServletResponse response) throws Exception
    {
        request.setAttribute("key", "value");
        return new Viewable("/jsps/APIAppView.html", null);
    }



    @GET
    @Path("/getapijsondata")
    @Produces("application/json")
    public String getALLApiData() throws Exception
    {
        String title = null;
        List<APIDataModel> apiListDataModel = APIAppData.getAPIData();

        Gson gson = new Gson();
        title = gson.toJson(apiListDataModel);
        return title;
    }

    @GET
    @Path("{category}/getApiFromCategory")
    @Produces("application/json")
    public String getCategory(@PathParam("category") String category) throws Exception
    {
        String title = null;
        List<APIDataModel> annotationListDataModel = APIAppData.getAPIDataFromCategory(category);
        Gson gson = new Gson();
        title = gson.toJson(annotationListDataModel);
        return title;
    }

    @GET
    @Path("/getAllCategories")
    @Produces("application/json")
    public String getAllCategories() throws Exception
    {
        String title = null;
        List<APIDataModel> apiListDataModel = APIAppData.getAllCategories();

        Gson gson = new Gson();
        title = gson.toJson(apiListDataModel);
        return title;
    }

}
