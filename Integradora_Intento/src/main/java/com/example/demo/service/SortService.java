package com.example.demo.service;

import java.util.Arrays;

import org.springframework.stereotype.Service;

@Service
public class SortService {

     public int[] sort(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            int minIndex = i;  //seleccionamos el primero como el menor
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;  //indice del menor dentro de la parte no ordenada
                } 
            }
            //hacemos el cambio de poscion (pasael menor a la posicion inidcada de la parte ordenada)
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }


}
