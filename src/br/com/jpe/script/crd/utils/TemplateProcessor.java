/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jpe.script.crd.utils;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.Version;

/**
 * TemplateProcessor Class
 *
 * @author joaovperin
 */
public class TemplateProcessor {

    private static final String TPL_FOLDER = "res/templates/";

    public void criaTplPk(String pack, TemplateEntity entidade) {
        try {
            Template template = getConfig().getTemplate(TPL_FOLDER.concat("tpPk.ftl"));
            execute(pack, entidade, template, "Pk");
        } catch (Exception e) {
            throw new GeneratorException(e);
        }
    }

    public void criaTplBean(String pack, TemplateEntity entidade) {
        try {
            Template template = getConfig().getTemplate(TPL_FOLDER.concat("tpBean.ftl"));
            execute(pack, entidade, template, "Bean");
        } catch (Exception e) {
            throw new GeneratorException(e);
        }
    }

    public void criaTplDAO(String pack, TemplateEntity entidade) throws GeneratorException {
        try {
            Template template = getConfig().getTemplate(TPL_FOLDER.concat("tpDAO.ftl"));
            execute(pack, entidade, template, "DAO");
        } catch (Exception e) {
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
        } catch (Exception e) {
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
        } catch (Exception e) {
            throw new GeneratorException(e);
        }
    }

    /**
     * Proccessed a template
     *
     * @param pack
     * @param entidade
     * @param template
     * @param sufixo
     */
    private void execute(String pack, TemplateEntity entidade, Template template, String sufixo) {
        execute(pack, entidade, template, "", sufixo);
    }

    /**
     * Processa um template e gera o arquivo de saída
     *
     * @param pack
     * @param entidade
     * @param template
     * @param prefixo
     * @param sufixo
     */
    private void execute(String pack, TemplateEntity entidade, Template template, String prefix, String sufixo) {
        try {
            // Monta o data-model esperado pelo FreeMarker
            Map<String, Object> data = new HashMap<>();
            data.put("package", pack);
            data.put("entidade", entidade);

            // Saída no Console
            Writer out = new OutputStreamWriter(System.out);
            template.process(data, out);
            out.flush();

        } catch (IOException | TemplateException e) {
            e.printStackTrace(System.out);
        }
    }

    /**
     * Retorna a configuração do Template Engine
     *
     * @return Configuration
     */
    private Configuration getConfig() {
        return new Configuration(new Version("2.3"));
    }
}
