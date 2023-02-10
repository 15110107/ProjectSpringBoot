package com.springboot.restfullapi;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.web.bind.annotation.GetMapping;  
import org.springframework.web.bind.annotation.RestController;  
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

@RestController 
public class Controller {
    @Autowired  
    private JdbcTemplate jdbcTemplate; 
    @GetMapping("/CongNo_KhachHang_Duong")  
    public ResponseEntity<List<ModelResponse>> getModelResponse(@RequestBody ModelRequest ModelRequest) {
        try {
            String mDateto = ""; 
            String mMappingCodeType = "";
            if (ModelRequest.getDateTo() == "" || ModelRequest.getDateTo() == null) {
                mDateto = "NULL";
            } else  {
                mDateto = ModelRequest.getDateTo();
            }
            if (ModelRequest.getMappingCodeType() == "" || ModelRequest.getMappingCodeType() == null) {
                mMappingCodeType = "NULL";
            } else  {
                mMappingCodeType = ModelRequest.getMappingCodeType();
            }
            String sql = "EXEC sp_GETTBL_ForAndroid_ByCodeMap_CongNo_KhachHang_Duong '"+mDateto+"','"+mMappingCodeType+"'";
            List<ModelResponse> ModelResponses = jdbcTemplate.query(sql,BeanPropertyRowMapper.newInstance(ModelResponse.class));
            ModelResponses.forEach(System.out :: println);

            if (ModelResponses.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(ModelResponses, HttpStatus.OK);
        } catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
}
