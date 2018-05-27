/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jpe.script.crd.processors;

import br.com.jpe.script.crd.utils.GeneratorException;
import br.com.jpe.script.crd.utils.Table;
import br.com.jpe.script.crd.utils.TemplateEntity;
import java.io.IOException;
import java.util.List;

/**
 * TemplateProcessor V2 Class
 *
 * @author joaovperin
 */
public class TemplateProcessorV2 extends AbstractTemplateProcessor {

    /** Folder of the templates */
    private static final String TPL_FOLDER = "res/templates/v2/";

    /**
     * Process the tables
     *
     * @param tables
     */
    @Override
    public void processTables(List<Table> tables) {
        tables.forEach((t) -> {
            createTemplateFor("Bean", "my.gen", new TemplateEntity(t));
        });
    }

    /**
     * Creates the template for a classe
     *
     * @param name
     * @param pack
     * @param entidade
     */
    public void createTemplateFor(String name, String pack, TemplateEntity entidade) {
        try {
            execute(pack, entidade, getConfig().getTemplate(TPL_FOLDER.concat(name.concat(".ftl"))), name);
        } catch (IOException e) {
            throw new GeneratorException(e);
        }
    }

}
