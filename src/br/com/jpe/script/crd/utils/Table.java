/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jpe.script.crd.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that represents a database table
 *
 * @author joaovperin
 */
public class Table {

    /** Table name on the database */
    private String name;
    /** Table tyope on the database */
    private String type;
    /** Table fields */
    private List<Field> tableFields;

    /**
     * Default constructor
     */
    public Table() {
        tableFields = new ArrayList<>();
    }

    /**
     * Gets the table name
     *
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the table name
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the table type
     *
     * @return String
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the table type
     *
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets the table fields
     *
     * @return List
     */
    public List<Field> getTableFields() {
        return tableFields;
    }

    /**
     * Sets the table fields
     *
     * @param tableFields
     */
    public void setTableFields(List<Field> tableFields) {
        this.tableFields = tableFields;
    }

    /**
     * Adds a field on the table
     *
     * @param field
     */
    public void addField(Field field) {
        tableFields.add(field);
    }

    /**
     * Serializes the object
     *
     * @return String
     */
    @Override
    public String toString() {
        return "Table{" + "name=" + name + ", type=" + type + ", tableFields=" + tableFields + '}';
    }

}
