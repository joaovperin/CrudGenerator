/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * GENERATED SOURCE CODE! DON'T EDIT THAT.
 */
package ${package}.bean;

<#if entity.isTable()>
import ${package}.pk.${entity.name}Pk;
</#if>
import java.util.Objects;
<#list entity.attrs as a>
<#if a.type = 'Date'>
import java.util.Date;
<#break>
</#if>
</#list>

/**
 * Class ${entity.name}Bean
 *
 * @author joaovperin
 */
public class ${entity.name}Bean {

<#list entity.attrs as a>Joaov
    /** ${a.description?cap_first} */
    private ${a.type} ${a.name?uncap_first};
</#list>

    /** 
     * ${entity.name?cap_first}Bean Constructor
     */
    public ${entity.name}Bean() {}

<#list entity.attrs as a>

    /** 
     * Returns the ${a.description} field value
     * 
<#if a.type == "boolean">
     * @return boolean
     */
    public ${a.type} is${a.name?cap_first}() {
        return ${a.name?uncap_first};
    }
<#else>
     * @return ${a.type}
     */
    public ${a.type} get${a.name?cap_first}() {
        return ${a.name};
    }
</#if>

    /** 
     * Sets the ${a.description} field value
     * 
     * @param ${a.name?uncap_first}
     */
    public void set${a.name?cap_first}(${a.type} ${a.name?uncap_first}) {
        this.${a.name?uncap_first} = ${a.name?uncap_first};
    }
</#list>

    /**
     * Returns a hascode for this ${entity.name} instance
     *
     * @return int
     */
    @Override
    public int hashCode() {
        int hash = 7;
<#list entity.attrs as a>
        hash = 53 * hash + Objects.hashCode(this.${a.name});
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
        final ${entity.name}Bean other = (${entity.name}Bean) obj;
        <#list entity.attrs as a>
        if (!Objects.equals(this.${a.name}, other.${a.name})) {
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
        return "${entity.name}Bean{" +
<#list entity.attrs as a>
<#if a_has_next>
                    "${a.name}=" + ${a.name} + ", " +
<#else>
                    "${a.name}=" + ${a.name} + "}";
</#if>
</#list>
    }

}
