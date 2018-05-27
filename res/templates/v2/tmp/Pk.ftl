/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * GENERATED SOURCE CODE! DON'T EDIT THAT.
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
 * Class ${entidade.nome}Pk
 *
 * @author joaovperin
 */
public class ${entidade.nome}Pk extends AbstractPk<${entidade.nome}Pk> {

<#list entidade.attrs as a>
<#if a.isPk>
    /** ${a.descricao?cap_first} */
    private ${a.tipo} ${a.nome?uncap_first};
</#if>
</#list>

    /** 
     * Class ${entidade.nome?cap_first}Pk Default Constructor
     */
    public ${entidade.nome}Pk() {}

    /** 
     * Class ${entidade.nome?cap_first}Pk Constructor
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
     * Returns the ${a.descricao} field value
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
     * Sets the ${a.descricao} field value
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
