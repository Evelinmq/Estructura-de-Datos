package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //getters and setters
@AllArgsConstructor //constructior parametrizado
@NoArgsConstructor //constructor sin parámetros
public class CustomRequest {

    String data;

    //public String getData() {
    //    return data;
    //}

    //public void setData(String data) {
    //    this.data = data;
    //}

    //public CustomRequest() {
    //}

    

}
