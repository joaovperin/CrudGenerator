/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jpe.script.crd.core;

import br.com.jpe.script.crd.utils.Table;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author joaovperin
 */
public interface TemplateProcessor {

    public void processTables(List<Table> tables);

    public void processViews(List<Table> views);

    public void setProperties(Properties pt);

}
