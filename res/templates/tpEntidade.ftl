/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * ESTE FONTE É GERADO E NÃO DEVE SER ALTERADO.
 */
package ${package}.entidade;

<#if entidade.isTable()>
import br.jpe.dallahits.generics.AbstractEntidade;
import ${package}.pk.${entidade.nome}Pk;
<#else>
import br.jpe.dallahits.generics.AbstractViewEntidade;
</#if>
import ${package}.bean.${entidade.nome}Bean;
import org.json.simple.JSONArray;

/**
 * Classe ${entidade.nome}Entidade
 *
 * @author Joaov
 */
<#if entidade.isTable()>
public class ${entidade.nome}Entidade extends AbstractEntidade<${entidade.nome}Bean, ${entidade.nome}Pk> {
<#else>
public class ${entidade.nome}Entidade extends AbstractViewEntidade<${entidade.nome}Bean> {
</#if>

    /** 
     * Construtor da classe ${entidade.nome?cap_first}Entidade
     */
    public ${entidade.nome}Entidade() {}
    
    @Override
    public JSONArray getTitulos() {
       JSONArray titulos = new JSONArray();       
<#list entidade.attrs as a>
        titulos.add("${a.descricao?cap_first}");
</#list>
       return titulos;
    }
     
    @Override
    public JSONArray getColunas() {
       JSONArray colunas = new JSONArray();
<#list entidade.attrs as a>
        colunas.add("${a.nome}");
</#list>
       return colunas;
    }

}
