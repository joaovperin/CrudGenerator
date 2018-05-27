/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jpe.script.crd.processors;

import br.com.jpe.script.crd.core.TemplateProcessor;
import br.com.jpe.script.crd.utils.Table;
import br.com.jpe.script.crd.utils.TemplateEntity;
import br.com.jpe.script.crd.utils.Text;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.Version;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Abstract template processor
 *
 * @author joaovperin
 */
public abstract class AbstractTemplateProcessor implements TemplateProcessor {

    protected Properties properties;

    @Override
    public void processViews(List<Table> views) {

    }

    protected void addPropertiesToMap(Map<String, Object> data) {

    }

    @Override
    public void setProperties(Properties pt) {
        this.properties = pt;
    }

    /**
     * Proccessed a template
     *
     * @param pack
     * @param entidade
     * @param template
     * @param sufixo
     */
    protected void execute(String pack, TemplateEntity entidade, Template template, String sufixo) {
        execute(pack, entidade, template, "", sufixo);
    }

    /**
     * Process the template
     *
     * @param pack
     * @param entity
     * @param template
     * @param prefix
     * @param suffix
     */
    protected void execute(String pack, TemplateEntity entity, Template template, String prefix, String suffix) {
        try {
            // Builds the data-model object to inject on freemarker
            Map<String, Object> data = new HashMap<>();
            data.put("package", pack);
            data.put("entity", entity);
            addPropertiesToMap(data);

            // Console output
            if (Boolean.valueOf(properties.getProperty("writeonfile", "true"))) {
                Writer out = new OutputStreamWriter(System.out);
                template.process(data, out);
                out.flush();
            }

            // If writes on file
            if (Boolean.valueOf(properties.getProperty("writeonfile", String.valueOf(properties.getProperty("basepath") != null)))) {
                try (Writer file = new FileWriter(getOutputFile(pack, entity.getName(), prefix, suffix))) {
                    template.process(data, file);
                    file.flush();
                }
            }

        } catch (IOException | TemplateException e) {
            e.printStackTrace(System.out);
        }
    }

    /**
     * Returns the output file
     *
     * @param pack
     * @param table
     * @param prefix
     * @param suffix
     * @return File
     */
    protected File getOutputFile(String pack, String table, String prefix, String suffix) {
        String base = properties.getProperty("basepath");
        StringBuilder sb = new StringBuilder(base);
        if (!base.endsWith("/")) {
            sb.append("/");
        }
        sb.append(pack.replaceAll("\\.", "/").concat("/"));
        sb.append(suffix.toLowerCase().concat("/"));
        sb.append(getFileName(table, prefix, suffix).concat(".java"));
        return new File(sb.toString().concat("/"));
    }

    /**
     * Returns the file name
     *
     * @param table
     * @param prefix
     * @param suffix
     * @return String
     */
    protected String getFileName(String table, String prefix, String suffix) {
        return prefix.concat(Text.capitalize(table).concat(Text.capitalize(suffix)));
    }

    /**
     * Returns the configuration object for FreeMarker
     *
     * @return Configuraion
     */
    protected Configuration getConfig() {
        return new Configuration(new Version("2.3"));
    }

}
