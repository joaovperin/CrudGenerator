/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jpe.script.crd.utils;

/**
 * A class that represents a Field
 *
 * @author joaovperin
 */
public class Field {

    /** Database field name */
    private String field;
    /** Database field type */
    private String type;
    /** Database comment of the field */
    private String comment;
    /** Is the field part of the primary key? */
    private boolean pk;
    /** Is the field auto-incremented? */
    private boolean autoIncrement;

    /**
     * Gets the database field name
     *
     * @return String
     */
    public String getField() {
        return field;
    }

    /**
     * Sets the database field name
     *
     * @param field
     */
    public void setField(String field) {
        this.field = field;
    }

    /**
     * Gets the field type
     *
     * @return String
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the field type
     *
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets the field comment
     *
     * @return String
     */
    public String getComment() {
        return comment;
    }

    /**
     * Sets the field comment
     *
     * @param comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * Returns true if the field is part of the primary key
     *
     * @return boolean
     */
    public boolean isPk() {
        return pk;
    }

    /**
     * Sets if the field is part of the primary key
     *
     * @param pk
     */
    public void setPk(boolean pk) {
        this.pk = pk;
    }

    /**
     * Returns true if the field is auto incrementated
     *
     * @return boolean
     */
    public boolean isAutoIncrement() {
        return autoIncrement;
    }

    /**
     * Sets it the field is auto incrementated
     *
     * @param autoIncrement
     */
    public void setAutoIncrement(boolean autoIncrement) {
        this.autoIncrement = autoIncrement;
    }

    /**
     * Serializes the field
     * 
     * @return String
     */
    @Override
    public String toString() {
        return "Field{" + "field=" + field + ", type=" + type + ", comment=" + comment + ", pk=" + pk
                + ", autoIncrement=" + autoIncrement + '}';
    }

}
