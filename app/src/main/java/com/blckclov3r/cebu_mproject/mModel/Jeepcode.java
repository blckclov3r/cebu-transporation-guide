package com.blckclov3r.cebu_mproject.mModel;

/**
 * Created by Abrenica, Aljun
 */

public class Jeepcode {
    private int _id;
    private String code = "";
    private String desc = "";
    private String togo = "";

    public Jeepcode(){}

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

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
