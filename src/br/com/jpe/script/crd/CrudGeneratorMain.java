/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jpe.script.crd;

import br.com.jpe.script.crd.core.FontGenerator;
import java.util.Arrays;
import java.util.Properties;

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
        new FontGenerator(getPropertiesFromCommandLineArgs(args)).exec();
        end = System.currentTimeMillis();
        // Mensagem de tempo decorrido
        System.out.println("Finished!. Time passed: " + (end - start) + " ms.");
    }

    /**
     * Gets properties from command line args
     *
     * @param args
     * @return Properties
     */
    private static Properties getPropertiesFromCommandLineArgs(String... args) {
        Properties pt = new Properties();
        Arrays.asList(args).forEach((a) -> {
            // Key/Value args
            int i = a.indexOf("=");
            if (i != -1) {
                pt.put(a.substring(0, i), a.subSequence(i + 1, a.length()));
            }
            // Version arg in the format --v1 --v2 --v15
            int indexOf = a.indexOf("--v");
            if (indexOf == 0) {
                pt.put("version", a.subSequence(indexOf + 1, a.length()));
            }
        });
        return pt;
    }

}
