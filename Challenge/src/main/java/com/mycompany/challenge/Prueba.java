package com.mycompany.challenge;

import com.google.gson.Gson;

/**
 * Prueba de un objeto tipo parametro en formato json
 * @author Darwin Algarin
 */
public class Prueba {

    public static void main(String[] args) {
        
        String[] str = new String[11];
        str[0] = "4 5";
        str[1] = "UPDATE 2 2 2 4";
        str[2] = "QUERY 1 1 1 3 3 3";
        str[3] = "UPDATE 1 1 1 23";
        str[4] = "QUERY 2 2 2 4 4 4";
        str[5] = "QUERY 1 1 1 3 3 3";
        str[6] = "2 4";
        str[7] = "UPDATE 2 2 2 1";
        str[8] = "QUERY 1 1 1 1 1 1";
        str[9] = "QUERY 1 1 1 2 2 2";
        str[10] = "QUERY 2 2 2 2 2 2";
        
        Parameter p = new Parameter(2, str);
        System.out.println(new Gson().toJson(p));
        
    }
    
}
