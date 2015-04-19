package com.data;

import java.util.List;

/**
 * Created by karthik on 3/11/15.
 */
public class AnnotationDataModel {

    private String top;
    private String left;
    private String width;
    private String height;
    private String text;
    private String id;
    private String editable;
    private String imageId;

    public String getEditable() {
        return editable;
    }

    public void setEditable(String editable) {
        this.editable = "true";
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getTop() {
        return top;
    }

    public void setTop(String top) {
        this.top = top;
    }

    public String getLeft() {
        return left;
    }

    public void setLeft(String left) {
        this.left = left;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
