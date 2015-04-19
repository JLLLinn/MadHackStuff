package com.data;


import java.util.List;
/**
 * Created by karthik on 1/28/15.
 */

    public class ImageDataModel {

    private int indexID;
    private List<Integer> imgPageIdList;
    private List<String> articleTitleList;
    private List<String> textDataList;
    private List<String> imgJPGList;

    private List<String> figCaptionList;

    private AnnotationDataModel annotationDataModel;

    public List<String> getFigCaptionList() {
        return figCaptionList;
    }

    public void setFigCaptionList(List<String> figCaptionList) {
        this.figCaptionList = figCaptionList;
    }

    public AnnotationDataModel getAnnotationDataModel() {
        return annotationDataModel;
    }

    public void setAnnotationDataModel(AnnotationDataModel annotationDataModel) {
        this.annotationDataModel = annotationDataModel;
    }

    public int getIndexID() {
        return indexID;
    }

    public void setIndexID(int indexID) {
        this.indexID = indexID;
    }

    public List<String> getImgJPGList() {
        return imgJPGList;
    }

    public void setImgJPGList(List<String> imgJPGList) {
        this.imgJPGList = imgJPGList;
    }

    public List<String> getTextDataList() {
        return textDataList;
    }

    public void setTextDataList(List<String> textDataList) {
        this.textDataList = textDataList;
    }

    public List<String> getArticleTitleList() {
        return articleTitleList;
    }

    public void setArticleTitleList(List<String> articleTitleList) {
        this.articleTitleList = articleTitleList;
    }

    public List<Integer> getImgPageIdList() {
        return imgPageIdList;
    }

    public void setImgPageIdList(List<Integer> imgPageIdList) {
        this.imgPageIdList = imgPageIdList;
    }

    }
