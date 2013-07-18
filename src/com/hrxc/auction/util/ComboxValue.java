package com.hrxc.auction.util;

/**
 * 记录combox中值与显示信息
 * @author user
 */
public class ComboxValue {
    public ComboxValue(){
        
    }
    
    public ComboxValue(String name,String value){
        this.name = name;
        this.value = value;
    }

    private String value;
    private String name;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
