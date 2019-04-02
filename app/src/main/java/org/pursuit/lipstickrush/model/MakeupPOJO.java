package org.pursuit.lipstickrush.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MakeupPOJO implements Serializable {
    private int id;
    private String brand;
    private String name;
    private String price;
    private String price_sign;
    private String currency;
    private String image_link;
    private String product_link;
    private String website_link;

    public void setId(int id) {
        this.id = id;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setPrice_sign(String price_sign) {
        this.price_sign = price_sign;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setImage_link(String image_link) {
        this.image_link = image_link;
    }

    public void setProduct_link(String product_link) {
        this.product_link = product_link;
    }

    public void setWebsite_link(String website_link) {
        this.website_link = website_link;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }

    public void setTag_list(String[] tag_list) {
        this.tag_list = tag_list;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public void setProduct_api_url(String product_api_url) {
        this.product_api_url = product_api_url;
    }

    public void setApi_featured_image(String api_featured_image) {
        this.api_featured_image = api_featured_image;
    }

    public void setProduct_colors(List<ProductsColors> product_colors) {
        this.product_colors = product_colors;
    }

    private String description;
    private String rating;
    private String category;
    private String product_type;
    private String[]tag_list;
    private String created_at;
    private String updated_at;
    private String product_api_url;
    private String api_featured_image;
    private List<ProductsColors>product_colors;

//    public MakeupPOJO(int id, String brand, String name,
//                      String price, String price_sign, String currency,
//                      String image_link, String product_link,
//                      String website_link, String description,
//                      String rating, String category, String product_type,
//                      String[]tag_list, String created_at, String updated_at,
//                      String product_api_url, String api_featured_image,
//                      List<ProductsColors> product_colors) {
//        this.id = id;
//        this.brand = brand;
//        this.name = name;
//        this.price = price;
//        this.price_sign = price_sign;
//        this.currency = currency;
//        this.image_link = image_link;
//        this.product_link = product_link;
//        this.website_link = website_link;
//        this.description = description;
//        this.rating = rating;
//        this.category = category;
//        this.product_type = product_type;
//        this.tag_list = tag_list;
//        this.created_at = created_at;
//        this.updated_at = updated_at;
//        this.product_api_url = product_api_url;
//        this.api_featured_image = api_featured_image;
//        this.product_colors = product_colors;
//    }


    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getPrice_sign() {
        return price_sign;
    }

    public String getCurrency() {
        return currency;
    }

    public String getImage_link() {
        return image_link;
    }

    public String getProduct_link() {
        return product_link;
    }

    public String getWebsite_link() {
        return website_link;
    }

    public String getDescription() {
        return description;
    }

    public String getRating() {
        return rating;
    }

    public String getCategory() {
        return category;
    }

    public String getProduct_type() {
        return product_type;
    }

    public String[] getTag_list() {
        return tag_list;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public String getProduct_api_url() {
        return product_api_url;
    }

    public String getApi_featured_image() {
        return api_featured_image;
    }

    public List<ProductsColors> getProduct_colors() {
        return product_colors;
    }



}
