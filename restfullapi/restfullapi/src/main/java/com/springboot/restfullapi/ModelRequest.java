package com.springboot.restfullapi;

public class ModelRequest {
    private String DateTo;
    private String MappingCodeType;

    public String getDateTo(){return DateTo;}  
    public void setDateTo(String DateTo){this.DateTo = DateTo;}  

    public String getMappingCodeType(){return MappingCodeType;}  
    public void setMappingCodeType(String MappingCodeType){this.MappingCodeType = MappingCodeType;}
}
