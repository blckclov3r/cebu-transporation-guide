package com.blckclov3r.cebu_mproject.mModel;

/**
 * Created by Abrenica, Aljun on 8/15/2018.
 */

public class Jeepcode {
    private int _id;
    private String code = "";
    private String desc = "";
    private String togo = "";

    public String getTogo() {
        return togo;
    }

    public void setTogo(String togo) {
        this.togo = togo;
    }

    public Jeepcode(String code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public Jeepcode(String code, String desc, String togo) {
        this.code = code;
        this.desc = desc;
        this.togo = togo;
    }

    public String getCode(){
        return code;
    }

    public String getDesc(){
        return desc;
    }
}
