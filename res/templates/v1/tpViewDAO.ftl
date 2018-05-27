/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * ESTE FONTE É GERADO E NÃO DEVE SER ALTERADO.
 */
package ${package}.dao;

import ${package}.bean.${entidade.nome}Bean;
import br.jpe.dallahits.generics.AbstractViewDAO;
import br.jpe.dallahits.generics.AbstractPk;
import br.jpe.dallahits.util.db.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Classe ${entidade.nome}DAO
 *
 * @author Joaov
 */
public class ${entidade.nome}DAO extends AbstractViewDAO<${entidade.nome}Bean, AbstractPk> {

    /** SQL para SELECT */
    private static final String SQL_SELECT = "SELECT <#list entidade.attrs as a>${a.nome}<#if a_index < entidade.attrs?size - 1>, </#if></#list> FROM ${entidade.tableName}";

    /** 
     * Construtor da classe ${entidade.nome?cap_first}Pk
     *
     * @param conn
     */
    public ${entidade.nome}DAO(Conexao conn) {
       super(conn);
    }

    /** 
     * Retorna o comando SQL para executar uma SELECT
     *
     * @return String
     */
    @Override
    protected String getSqlSelect() {
        return SQL_SELECT;
    }
    
    /** 
     * Retorna um Bean à partir de um ResultSet
     *
     * @return ${entidade.nome?cap_first}Bean
     * @throws java.sql.SQLException
     */
    @Override
    protected ${entidade.nome}Bean getBeanFromResultSet(ResultSet rs) throws SQLException {
        ${entidade.nome}Bean bean = new ${entidade.nome}Bean();
<#list entidade.attrs as a>
        bean.set${a.nome?cap_first}(rs.get${a.tipo?cap_first}(${a_index + 1}));
</#list>
        return bean;
    }

    /** 
     * Preenche um PreparedStatement à partir de um Bean
     *
     * @param pstmt PreparedStatement recém criado (vazio)
     * @param bean Objeto com os dados a popular
     * @return PreparedStatement Dados populados
     * @throws java.sql.SQLException
     */
    @Override
    protected PreparedStatement getPstmt(PreparedStatement pstmt, ${entidade.nome}Bean bean) throws SQLException {
<#assign idx = 1>
<#list entidade.attrs as a>
<#if !a.isPk>
    <#if a.tipo = 'Date'>
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
