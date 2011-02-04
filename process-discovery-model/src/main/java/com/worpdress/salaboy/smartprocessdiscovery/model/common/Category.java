package com.worpdress.salaboy.smartprocessdiscovery.model.common;

/**
 * Created by IntelliJ IDEA.
 * User: salaboy
 * Date: 2/4/11
 * Time: 1:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class Category {
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
