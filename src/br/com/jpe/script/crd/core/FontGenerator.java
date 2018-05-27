/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jpe.script.crd.core;

import br.com.jpe.script.crd.utils.ConexaoFactory;
import br.com.jpe.script.crd.utils.Field;
import br.com.jpe.script.crd.utils.Table;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Font Generator core
 *
 * @author joaovperin
 */
public class FontGenerator {

    /** Properties */
    private final Properties pt;

    /**
     * Default constructor
     *
     * @param properties
     */
    public FontGenerator(Properties properties) {
        this.pt = properties;
    }

    /**
     * Executes the Script in a database
     *
     * @throws SQLException
     * @throws java.io.IOException
     */
    public void exec() throws SQLException, IOException {
        try (Connection conn = ConexaoFactory.getConnection()) {
            String dbName = pt.getProperty("database");
            TemplateProcessor g = TemplateProcessorFactory.get(pt.getProperty("version"), pt);
            g.processTables(getTables(conn, dbName));
            g.processViews(getTables(conn, dbName));
        }
    }

    /**
     * Queries the Tables from a Schema
     *
     * @param conn
     * @param dbName
     * @return List
     * @throws DAOException
     */
    private List<Table> getTables(Connection conn, String dbName) throws SQLException {
        return getEntities(conn, dbName, "BASE_TABLE");
    }

    /**
     * Queries the Views from a Schema
     *
     * @param conn
     * @param dbName
     * @return List
     * @throws DAOException
     */
    private List<Table> getViews(Connection conn, String dbName) throws SQLException {
        return getEntities(conn, dbName, "VIEW");
    }

    /**
     * Queries the Tables or Views from a database schema
     *
     * @param conn
     * @param databaseName
     * @return List
     * @throws DAOException
     */
    private List<Table> getEntities(Connection conn, String databaseName, String tType) throws SQLException {
        List<Table> list = new ArrayList<>();
        ResultSet rs = conn.createStatement().executeQuery("SHOW FULL TABLES FROM " + databaseName + " WHERE TABLE_TYPE LIKE '" + tType + "'");
        while (rs.next()) {
            Table tb = getTabelaFromRs(rs);
            tb.setTableFields(getFields(conn, tb.getName()));
            list.add(tb);
        }
        return list;
    }

    /**
     * Queries the fields from a table or view
     *
     * @param conn
     * @param name
     * @return List
     * @throws DAOException
     */
    private List<Field> getFields(Connection conn, String name) throws SQLException {
        List<Field> list = new ArrayList<>();
        ResultSet rs = conn.createStatement().executeQuery("SHOW FULL FIELDS FROM " + name);
        while (rs.next()) {
            list.add(getFieldFromRs(rs));
        }
        return list;
    }

    /**
     * Creates a Table Object from a ResultSet
     *
     * @param rs
     * @return Table
     */
    private Table getTabelaFromRs(ResultSet rs) throws SQLException {
        Table tabela = new Table();
        tabela.setName(rs.getString(1));
        tabela.setType(rs.getString(2));
        return tabela;
    }

    /**
     * Creates a Field Object from a ResultSet
     *
     * @param rs
     * @return Field
     */
    private Field getFieldFromRs(ResultSet rs) throws SQLException {
        Field field = new Field();
        field.setField(rs.getString(1));
        field.setType(rs.getString(2));
        field.setPk(rs.getString(5).equalsIgnoreCase("PRI"));
        field.setAutoIncrement(rs.getString(7).equalsIgnoreCase("auto_increment"));
        field.setComment(rs.getString(9));
        return field;
    }

}
