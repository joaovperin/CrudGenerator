/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jpe.script.crd.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe TemplateTabela
 *
 * @author Joaov
 */
public class TemplateEntity {

    /** Table name on the database */
    private String tableName;
    /** Table type */
    private String tableType;
    /** Table name for showing */
    private String name;
    /** Index of the last attribute from the primary key */
    private int lastKeyAtt;
    /** Attributes list of the table */
    private List<TemplateAttribute> attrs;

    /**
     * Builds an entity from a MySQL table
     *
     * @param table MySQL Table
     */
    public TemplateEntity(Table table) {
        this.attrs = new ArrayList<>();
        this.lastKeyAtt = -1;
        table.getTableFields().forEach((f) -> {
            attrs.add(new TemplateAttribute(f));
            if (f.isPk()) {
                lastKeyAtt++;
            }
        });
        this.tableName = table.getName();
        this.tableType = table.getType();
        this.name = Text.toCamelCase(table.getName(), true);
    }

    /**
     * Gets the table name
     *
     * @return String
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * Sets the table name
     *
     * @param tableName
     */
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    /**
     * Gets the table type
     *
     * @return String
     */
    public String getTableType() {
        return tableType;
    }

    /**
     * Gets the table type
     *
     * @param tableType
     */
    public void setTableType(String tableType) {
        this.tableType = tableType;
    }

    /**
     * Returns true if the table is a view
     *
     * @return boolean
     */
    public boolean isView() {
        return getTableType().equals("VIEW");
    }

    /**
     * Returns true if the table is a table
     *
     * @return boolean
     */
    public boolean isTable() {
        return getTableType().equals("BASE_TABLE");
    }

    /**
     * Gets the database table name
     *
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the database table name
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the table attributes list
     *
     * @return List
     */
    public List<TemplateAttribute> getAttrs() {
        return attrs;
    }

    /**
     * Sets the table attributes list
     *
     * @param attrs
     */
    public void setAttrs(List<TemplateAttribute> attrs) {
        this.attrs = attrs;
    }

    /**
     * Adds a tabble attribute to the list
     *
     * @param attr
     */
    public void addAttr(TemplateAttribute attr) {
        attrs.add(attr);
    }

    /**
     * Gets the last key attribute index
     *
     * @return int
     */
    public int getLastKeyAtt() {
        return lastKeyAtt;
    }

    /**
     * Sets the last key attribute index
     *
     * @param lastKeyAtt
     */
    public void setLastKeyAtt(int lastKeyAtt) {
        this.lastKeyAtt = lastKeyAtt;
    }

}
