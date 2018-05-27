/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jpe.script.crd.utils;

/**
 * TemplateCampo
 *
 * @author joaovperin
 */
public class TemplateAttribute {

    /** Field name */
    private String name;
    /** Field description */
    private String description;
    /** Field type */
    private String type;
    /** Field is Primary Key? */
    private boolean isPk;
    /** Field is Autoincremented? */
    private boolean autoIncrement;

    /**
     * Constructor
     *
     * @param f
     */
    public TemplateAttribute(Field f) {
        name = Text.uncapitalize(f.getField());
        description = f.getComment();
        type = FieldConverter.get(f.getType());
        isPk = f.isPk();
        autoIncrement = f.isAutoIncrement();
    }

    /**
     * Gets the name
     *
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the description
     *
     * @return String
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the type
     *
     * @return String
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type
     *
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Returns true if it's part of the primary key
     *
     * @return boolean
     */
    public boolean isIsPk() {
        return isPk;
    }

    /**
     * Sets if it's part of the primary key
     *
     * @param isPk
     */
    public void setIsPk(boolean isPk) {
        this.isPk = isPk;
    }

    /**
     * Returns true if it's auto incrementated
     *
     * @return boolean
     */
    public boolean isAutoIncrement() {
        return autoIncrement;
    }

    /**
     * Sets if it's auto incrementated
     *
     * @param autoIncrement
     */
    public void setAutoIncrement(boolean autoIncrement) {
        this.autoIncrement = autoIncrement;
    }

}
