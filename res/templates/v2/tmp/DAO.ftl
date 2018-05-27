/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * GENERATED SOURCE CODE! DON'T EDIT THAT.
 */
package ${package}.dao;

import ${package}.bean.${entidade.nome}Bean;
import ${package}.pk.${entidade.nome}Pk;
import br.jpe.dallahits.generics.AbstractDAO;
import br.jpe.dallahits.util.db.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import br.jpe.dallahits.exception.DAOException;
import java.sql.SQLException;

/**
 * Class ${entidade.nome}DAO
 *
 * @author joaovperin
 */
public class ${entidade.nome}DAO {

    /** SELECT SQL */
    private static final String SQL_SELECT = "SELECT <#list entidade.attrs as a>${a.nome}<#if a_index < entidade.attrs?size - 1>, </#if></#list> FROM ${entidade.tableName}";
    /** INSERT SQL */
    private static final String SQL_INSERT = "INSERT INTO ${entidade.tableName} (<#list entidade.attrs as a><#if !a.autoIncrement>${a.nome}<#if a_index < entidade.attrs?size - 1>, </#if></#if></#list>) VALUES (<#list entidade.attrs as a><#if !a.autoIncrement> ?<#if a_index < entidade.attrs?size - 1>, </#if></#if></#list> )";
    /** UPDATE SQL */
    private static final String SQL_UPDATE = "UPDATE ${entidade.tableName} SET <#list entidade.attrs as a><#if !a.autoIncrement && !a.isPk>${a.nome} =  ?<#if a_index < entidade.attrs?size - 1>, </#if></#if></#list>";
    /** DELETE SQL */
    private static final String SQL_DELETE = "DELETE FROM ${entidade.tableName}";

    /** 
     * ${entidade.nome?cap_first}DAO Consctructor
     *
     * @param conn
     */
    public ${entidade.nome}DAO(Conexao conn) {
       super(conn);
    }

    @Override
    public void insert(${entidade.nome}Bean bean) throws DAOException {
        try {
           PreparedStatement pstmt = getPstmt(conn.prepareStatement(getSqlInsert()), bean);
           pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

<#list entidade.attrs as xxx>
<#if xxx.isAutoIncrement()>
    public ${entidade.nome}Bean insertAi(${entidade.nome}Bean bean) throws DAOException {
        try {
           PreparedStatement pstmt = getPstmt(conn.prepareStatementForAutoIncrement(getSqlInsert()), bean);
           pstmt.executeUpdate();
           ResultSet rs = pstmt.getGeneratedKeys();
           if (rs.next()){
<#assign idx = 1>
<#list entidade.attrs as a>
<#if a.isAutoIncrement()>
    <#if a.tipo = 'Date'>
              throw new UnsupportedOperationException("NÃO FUNCIONA CAMPOS DATA DE PK");
    <#else>
              bean.set${a.nome?cap_first}(rs.get${a.tipo?cap_first}(${idx}));
    </#if>
<#if a.isPk>
    <#assign idx++>
</#if>
</#if>
</#list>
           }
           return bean;
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

<#break>
</#if>
</#list>
    public ${entidade.nome?cap_first}Bean buscaPk(${entidade.nome?cap_first}Pk pk) throws DAOException {
        try {
            String sql = SQL_SELECT.concat(
            " WHERE <#list entidade.attrs as a><#if a.isPk>${a.nome}<#if a_index < entidade.lastKeyAtt>, </#if></#if></#list> = <#list entidade.attrs as a><#if a.isPk> ?<#if a_index < entidade.lastKeyAtt>, </#if></#if></#list>"
            );
            PreparedStatement pstmt = conn.prepareStatement(sql);
<#list entidade.attrs as a>
<#if a.isPk>
            pstmt.set${a.tipo?cap_first}(${a_index + 1}, pk.get${a.nome?cap_first}());
</#if>
</#list>
            return buscaPrimeiro(pstmt);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public void update(${entidade.nome}Bean bean) throws DAOException {
        try {
            String where = " WHERE <#list entidade.attrs as a><#if a.isPk>${a.nome}<#if a_index < entidade.lastKeyAtt>, </#if></#if></#list> = <#list entidade.attrs as a><#if a.isPk> ?<#if a_index < entidade.lastKeyAtt>, </#if></#if></#list>";
            PreparedStatement pstmt = getPstmt(conn.prepareStatement(getSqlUpdate(where)), bean);
<#assign idx = entidade.attrs?size>
<#list entidade.attrs as a>
<#if a.isPk>
            pstmt.set${a.tipo?cap_first}(${idx}, bean.get${a.nome?cap_first}());
<#assign idx++>
</#if>
</#list>
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public void delete(${entidade.nome}Bean bean) throws DAOException {
        try {
            String where = " WHERE <#list entidade.attrs as a><#if a.isPk>${a.nome}<#if a_index < entidade.lastKeyAtt>, </#if></#if></#list> = <#list entidade.attrs as a><#if a.isPk> ?<#if a_index < entidade.lastKeyAtt>, </#if></#if></#list>";
            PreparedStatement pstmt = getPstmt(conn.prepareStatement(getSqlDelete(where)), bean);
<#assign idx = 1>
<#list entidade.attrs as a>
<#if a.isPk>
            pstmt.set${a.tipo?cap_first}(${idx}, bean.get${a.nome?cap_first}());
<#assign idx++>
</#if>
</#list>
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    protected String getSqlSelect() {
        return SQL_SELECT;
    }

    @Override
    protected String getSqlInsert() {
        return SQL_INSERT;
    }

    @Override
    protected String getSqlUpdate(String where) {
        return SQL_UPDATE.concat(where);
    }

    @Override
    protected String getSqlDelete(String where) {
        return SQL_DELETE.concat(where);
    }
    
    protected ${entidade.nome}Bean beanFromResultSet(ResultSet rs) throws SQLException {
        ${entidade.nome}Bean bean = new ${entidade.nome}Bean();
<#list entidade.attrs as a>
        bean.set${a.nome?cap_first}(rs.get${a.tipo?cap_first}(${a_index + 1}));
</#list>
        return bean;
    }

    protected PreparedStatement beanToPreparedStatement(PreparedStatement pstmt, ${entidade.nome}Bean bean) throws SQLException {
<#assign idx = 1>
<#list entidade.attrs as a>
<#if !a.isPk>
    <#if a.tipo = 'Date'>
        if (bean.get${a.nome?cap_first}() == null){
           bean.set${a.nome?cap_first}(new java.util.Date());
        }
        pstmt.set${a.tipo?cap_first}(${idx}, new java.sql.Date(bean.get${a.nome?cap_first}().getTime()));
    <#else>
        pstmt.set${a.tipo?cap_first}(${idx}, bean.get${a.nome?cap_first}());
    </#if>
    <#assign idx++>
</#if>
</#list>
        return pstmt;
    }

}
