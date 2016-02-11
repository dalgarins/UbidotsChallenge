package com.mycompany.challenge;

import com.google.gson.Gson;
import java.util.LinkedList;
import static spark.Spark.*;

/**
 * Api que calcula la sumatoria de un cubo
 * @author Darwin Algarin
 */
public class Main {
    
    public static void main(String[] args) {
        
        Gson gson = new Gson();
        
        post("/calculate", (request, response) -> {
            
            Parameter cubeOperations = gson.fromJson(request.queryParams("operations"), Parameter.class);
            
            LinkedList<Cube> listCube = null;
            LinkedList<String> listResponse = new LinkedList<>();
            
            for (int i = 0; i < cubeOperations.getOperations().length; i++) {
                if (cubeOperations.getOperations()[i].split(" ").length == 2) {
                    listCube = new LinkedList<>();//reinicia la lista de cubos
                } else if (cubeOperations.getOperations()[i].split(" ").length == 5) { //comprueba que sea un update
                    doUpdate(listCube, cubeOperations.getOperations()[i]);
                } else if (cubeOperations.getOperations()[i].split(" ").length == 7) { //comprueba que sea un query
                    doQuery(listCube, listResponse, cubeOperations.getOperations()[i]);
                }
            }
            
            return gson.toJson(listResponse);
        });
    }
    
    /**
     * Actualiza el paramatreo w de un cubo
     * @param cubes
     * @param line 
     */
    public static void doUpdate(LinkedList<Cube> cubes, String line) {
        String[] array = line.split(" ");
        int x = Integer.parseInt(array[1]);
        int y = Integer.parseInt(array[2]);
        int z = Integer.parseInt(array[3]);
        int w = Integer.parseInt(array[4]);
        if (cubes.size() == 0) {
            
            cubes.add(new Cube(x, y, z, w));
        } else {
            for (int i = 0; i < cubes.size(); i++) {
                Cube cube = cubes.get(i);
                if (cube.getX() == x && cube.getY() == y && cube.getZ() == z) {
                    cube.setW(w);
                } else {
                    cubes.add(new Cube(x, y, z, w));
                }
            }
        }
    }
    
    /**
     * Realiza la sumatoria exitente entre un rango dado de cubos
     * @param cubes
     * @param listResponse
     * @param line 
     */
    public static void doQuery(LinkedList<Cube> cubes, LinkedList<String> listResponse, String line) {
        int summation = 0;
        String[] array = line.split(" ");
        int x1 = Integer.parseInt(array[1]);
        int y1 = Integer.parseInt(array[2]);
        int z1 = Integer.parseInt(array[3]);
        
        int x2 = Integer.parseInt(array[4]);
        int y2 = Integer.parseInt(array[5]);
        int z2 = Integer.parseInt(array[6]);
        
        for (int i = 0; i < cubes.size(); i++) {
            Cube cube = cubes.get(i);
            if ((cube.getX() >= x1 && cube.getX() <= x2) 
                    && (cube.getY()>= y1 && cube.getY()<= y2)
                    && (cube.getZ()>= z1 && cube.getZ()<= z2)) {
                summation += cube.getW();
            }
        }
        listResponse.add(String.valueOf(summation));
    }
    
}
