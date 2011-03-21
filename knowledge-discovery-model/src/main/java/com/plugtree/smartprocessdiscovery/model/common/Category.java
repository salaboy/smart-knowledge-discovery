package com.plugtree.smartprocessdiscovery.model.common;

import com.google.gwt.user.client.rpc.IsSerializable;

public class Category implements IsSerializable {
    private Long id;
    private String name;
    private int rank;

    public Category() {
    }

    public Category(String name){
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
