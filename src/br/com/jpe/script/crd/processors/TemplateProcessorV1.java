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

import freemarker.template.Template;
import java.util.List;

/**
 * TemplateProcessor V1 Class
 *
 * @author joaovperin
 */
public class TemplateProcessorV1 extends AbstractTemplateProcessor {

    @Override
    public void processTables(List<Table> tables) {
        tables.forEach((t) -> {
            criaTplPk("br.jpe.dallahits.gen", new TemplateEntity(t));
            criaTplBean("br.jpe.dallahits.gen", new TemplateEntity(t));
            criaTplDAO("br.jpe.dallahits.gen", new TemplateEntity(t));
            criaTplEntidade("br.jpe.dallahits.gen", new TemplateEntity(t));
        });
    }

    @Override
    public void processViews(List<Table> views) {
        views.forEach((t) -> {
            criaTplBean("br.jpe.dallahits.gen.view", new TemplateEntity(t));
            criaTplViewDAO("br.jpe.dallahits.gen.view", new TemplateEntity(t));
            criaTplEntidade("br.jpe.dallahits.gen.view", new TemplateEntity(t));
        });
    }

    private static final String TPL_FOLDER = "res/templates/v1/";

    public void criaTplPk(String pack, TemplateEntity entidade) {
        try {
            Template template = getConfig().getTemplate(TPL_FOLDER.concat("tpPk.ftl"));
            execute(pack, entidade, template, "Pk");
        } catch (IOException e) {
            throw new GeneratorException(e);
        }
    }

    public void criaTplBean(String pack, TemplateEntity entidade) {
        try {
            Template template = getConfig().getTemplate(TPL_FOLDER.concat("tpBean.ftl"));
            execute(pack, entidade, template, "Bean");
        } catch (IOException e) {
            throw new GeneratorException(e);
        }
    }

    public void criaTplDAO(String pack, TemplateEntity entidade) throws GeneratorException {
        try {
            Template template = getConfig().getTemplate(TPL_FOLDER.concat("tpDAO.ftl"));
            execute(pack, entidade, template, "DAO");
        } catch (IOException e) {
            throw new GeneratorException(e);
        }
    }

    /**
     * Cria template para uma Entidade
     *
     * @param pack
     * @param entidade
     * @throws GeneratorException Problemas ao gerar templates
     */
    public void criaTplEntidade(String pack, TemplateEntity entidade) throws GeneratorException {
        try {
            Template template = getConfig().getTemplate(TPL_FOLDER.concat("tpEntidade.ftl"));
            execute(pack, entidade, template, "Entidade");
        } catch (IOException e) {
            throw new GeneratorException(e);
        }
    }

    /**
     * Cria template para um ViewDAO
     *
     * @param pack
     * @param entidade
     * @throws GeneratorException Problemas ao gerar templates
     */
    public void criaTplViewDAO(String pack, TemplateEntity entidade) throws GeneratorException {
        try {
            //Load template from source folder
            Template template = getConfig().getTemplate(TPL_FOLDER.concat("tpViewDAO.ftl"));
            execute(pack, entidade, template, "DAO");
        } catch (IOException e) {
            throw new GeneratorException(e);
        }
    }

}
