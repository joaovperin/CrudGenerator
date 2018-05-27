/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * GENERATED SOURCE CODE! DON'T EDIT THAT.
 */
package ${package}.bean;

<#if entidade.isTable()>
import ${package}.pk.${entidade.nome}Pk;
</#if>
import java.util.Objects;
<#list entidade.attrs as a>
<#if a.tipo = 'Date'>
import java.util.Date;
<#break>
</#if>
</#list>

/**
 * Class ${entidade.nome}Bean
 *
 * @author joaovperin
 */
public class ${entidade.nome}Bean {

<#list entidade.attrs as a>Joaov
    /** ${a.descricao?cap_first} */
    private ${a.tipo} ${a.nome?uncap_first};
</#list>

    /** 
     * ${entidade.nome?cap_first}Bean Constructor
     */
    public ${entidade.nome}Bean() {}

<#list entidade.attrs as a>

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
</#if>

    /** 
     * Sets the ${a.descricao} field value
     * 
     * @param ${a.nome?uncap_first}
     */
    public void set${a.nome?cap_first}(${a.tipo} ${a.nome?uncap_first}) {
        this.${a.nome?uncap_first} = ${a.nome?uncap_first};
    }
</#list>

    /**
     * Returns a hascode for this ${entidade.nome} instance
     *
     * @return int
     */
    @Override
    public int hashCode() {
        int hash = 7;
<#list entidade.attrs as a>
        hash = 53 * hash + Objects.hashCode(this.${a.nome});
</#list>
        return hash;
    }

    /**
     * Returns true if the two objects are equal
     *
     * @param obj
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ${entidade.nome}Bean other = (${entidade.nome}Bean) obj;
        <#list entidade.attrs as a>
        if (!Objects.equals(this.${a.nome}, other.${a.nome})) {
            return false;
        }
        </#list>
        return true;
    }

    /**
     * Returns the serialized object
     *
     * @return String
     */
    @Override
    public String toString() {
        return "${entidade.nome}Bean{" +
<#list entidade.attrs as a>
<#if a_has_next>
                    "${a.nome}=" + ${a.nome} + ", " +
<#else>
                    "${a.nome}=" + ${a.nome} + "}";
</#if>
</#list>
    }

}
