
package com.example.xebianytimesdemo.mvList.entity;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

//    @SerializedName("url")
//    private String url;
//
//    @SerializedName("adx_keywords")
//    private String adxKeywords;
//
//    @SerializedName("column")
//    private String column;
//
//    @SerializedName("section")
//    private String section;

    @SerializedName("byline")
    private String byline;
//
//    @SerializedName("type")
//    private String type;

    @SerializedName("title")
    private String title;

//    @SerializedName("abstract")
//    private String _abstract;

    @SerializedName("published_date")
    private String publishedDate;

//    @SerializedName("source")
//    private String source;
//
//    @SerializedName("id")
//    private Integer id;
//
//    @SerializedName("asset_id")
//    private Integer assetId;
//
//    @SerializedName("views")
//    private Integer views;
//
//    @SerializedName("des_facet")
//    private List<String> desFacet = null;
//
//    @SerializedName("org_facet")
//    private List<String> orgFacet = null;
//
//    @SerializedName("per_facet")
//    private String perFacet;
//
//    @SerializedName("geo_facet")
//    private String geoFacet;
//
//    @SerializedName("media")
//    private List<Medium> media = null;
//
//    @SerializedName("uri")
//    private String uri;


    public String getByline() {
        return byline;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public String getTitle() {
        return title;
    }
}
