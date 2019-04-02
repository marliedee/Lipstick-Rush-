package org.pursuit.lipstickrush.model;

import java.io.Serializable;

class TagList implements Serializable {

    public TagList(String[] tag_list) {
        this.tag_list = tag_list;
    }

    public String[] getTag_list() {
        return tag_list;
    }

    private String[] tag_list;
    }
