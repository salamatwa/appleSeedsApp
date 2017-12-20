package com.example.salam.androidappappleseeds;


import java.io.Serializable;
/**
 * Created by salam on 12/20/2017.
 */

public class ListItem implements Serializable {

    private String name ;
    private String img;
    private String description;
    private String productUrl;

    public String getDescription() {
        return description;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }


    public String getProductUrl() {
        return productUrl;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
