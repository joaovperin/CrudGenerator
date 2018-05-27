/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jpe.script.crd.utils;

/**
 * Helper class to convert a database field into a Java field
 *
 * @author joaovperin
 */
public class FieldConverter {

    /**
     * Converts a field type from MySql to Java
     *
     * @param field
     * @return String
     */
    public static String get(String field) {
        if (field.startsWith("varchar(") || field.startsWith("string")) {
            return "String";
        }
        if (field.startsWith("text")) {
            return "String";
        }
        if (field.startsWith("bigint(")) {
            return "long";
        }
        if (field.startsWith("int(")) {
            return "int";
        }
        if (field.startsWith("tinyint(1)") || field.startsWith("bit(")) {
            return "boolean";
        }
        if (field.startsWith("decimal(") || field.startsWith("double(")) {
            return "double";
        }
        if (field.startsWith("datetime") || field.startsWith("date")) {
            return "Date";
        }
        throw new UnsupportedOperationException("Field type '".concat(field).
                concat("' is not supported yet! FieldConverter.java."));
    }

}
