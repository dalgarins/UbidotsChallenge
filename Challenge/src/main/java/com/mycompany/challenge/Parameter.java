package com.mycompany.challenge;

/**
 * Esta clase contiene la estructura de los parametros de la peticion que son el numero de casos y las operaciones a realizar
 * @author Darwin Algarin
 */
public class Parameter {
    
    private int numberTestCase;    
    private String[] operations;

    public Parameter(int numberTestCase, String[] operations) {
        this.numberTestCase = numberTestCase;        
        this.operations = operations;
    }

    public int getNumberTestCase() {
        return numberTestCase;
    }

    public void setNumberTestCase(int numberTestCase) {
        this.numberTestCase = numberTestCase;
    }

    public String[] getOperations() {
        return operations;
    }

    public void setOperations(String[] operations) {
        this.operations = operations;
    }
}
