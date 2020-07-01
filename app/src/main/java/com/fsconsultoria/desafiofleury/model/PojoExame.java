package com.fsconsultoria.desafiofleury.model;

import com.google.gson.annotations.SerializedName;

public class PojoExame {

    @SerializedName("id")
    private String name;

    public PojoExame(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
