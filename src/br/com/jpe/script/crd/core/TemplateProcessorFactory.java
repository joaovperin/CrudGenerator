/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jpe.script.crd.core;

import br.com.jpe.script.crd.processors.TemplateProcessorV2;
import java.util.Properties;

/**
 *
 * @author joaovperin
 */
public class TemplateProcessorFactory {

    public static TemplateProcessor get(String version, Properties pt) {
        TemplateProcessor processor = new TemplateProcessorV2();
        processor.setProperties(pt);
        return processor;
    }

}
