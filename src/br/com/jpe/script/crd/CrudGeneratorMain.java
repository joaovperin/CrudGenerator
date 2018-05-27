/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jpe.script.crd;

import br.com.jpe.script.crd.core.FontGenerator;

/**
 * Main class
 *
 * @author joaovperin
 */
public class CrudGeneratorMain {

    /**
     * Main entry-point - Executes the Script
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        System.out.println("*** Starting to generate the sources...");
        long start, end;
        start = System.currentTimeMillis();
        new FontGenerator().exec();
        end = System.currentTimeMillis();
        // Mensagem de tempo decorrido
        System.out.println("Finished!. Time passed: " + (end - start) + " ms.");
    }

}
