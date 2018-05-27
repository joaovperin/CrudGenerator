/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * ESTE FONTE É GERADO E NÃO DEVE SER ALTERADO.
 */
package ${package}.pk;

import br.jpe.dallahits.generics.AbstractPk;
<#list entidade.attrs as a>
<#if a.tipo = 'Date'>
import java.util.Date;
<#break>
</#if>
</#list>

/**
 * Classe ${entidade.nome}Pk
 *
 * @author Joaov
 */
public class ${entidade.nome}Pk extends AbstractPk<${entidade.nome}Pk> {

<#list entidade.attrs as a>
<#if a.isPk>
    /** ${a.descricao?cap_first} */
    private ${a.tipo} ${a.nome?uncap_first};
</#if>
</#list>

    /** 
     * Construtor da classe ${entidade.nome?cap_first}Pk
     */
    public ${entidade.nome}Pk() {}

    /** 
     * Construtor da classe ${entidade.nome?cap_first}Pk
     * 
<#list entidade.attrs as a>
<#if a.isPk>
     * @param  ${a.nome?uncap_first}
</#if>
</#list>
     */
    public ${entidade.nome}Pk(<#list entidade.attrs as a><#if a.isPk>${a.tipo} ${a.nome?uncap_first}<#if a_index < entidade.lastKeyAtt>, </#if></#if></#list>) {
    <#list entidade.attrs as a>
       <#if a.isPk>
       this.${a.nome} = ${a.nome};
       </#if>
    </#list>
    }
<#list entidade.attrs as a>
<#if a.isPk>

    /** 
     * Retorna o valor do campo ${a.descricao}
     * 
    <#if a.tipo == "boolean">
     * @return boolean
     */
    public ${a.tipo} is${a.nome?cap_first}() {
        return ${a.nome?uncap_first};
    }
    <#else>
     * @return ${a.tipo}
     */
    public ${a.tipo} get${a.nome?cap_first}() {
        return ${a.nome};
    }

    /** 
     * Define o valor do campo ${a.descricao}
     * 
     * @param ${a.nome?uncap_first}
     */
    public void set${a.nome?cap_first}(${a.tipo} ${a.nome?uncap_first}) {
        this.${a.nome?uncap_first} = ${a.nome?uncap_first};
    }
    </#if>
</#if>
</#list>

}
