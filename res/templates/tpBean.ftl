/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * ESTE FONTE É GERADO E NÃO DEVE SER ALTERADO.
 */
package ${package}.bean;

import br.jpe.dallahits.generics.AbstractBean;
<#if entidade.isTable()>
import ${package}.pk.${entidade.nome}Pk;
</#if>
import java.util.Objects;
import org.json.simple.JSONArray;
<#list entidade.attrs as a>
<#if a.tipo = 'Date'>
import java.util.Date;
<#break>
</#if>
</#list>

/**
 * Classe ${entidade.nome}Bean
 *
 * @author Joaov
 */
public class ${entidade.nome}Bean extends AbstractBean<${entidade.nome}Bean> {

<#list entidade.attrs as a>
    /** ${a.descricao?cap_first} */
    private ${a.tipo} ${a.nome?uncap_first};
</#list>

    /** 
     * Construtor da classe ${entidade.nome?cap_first}Bean
     */
    public ${entidade.nome}Bean() {}
 <#if entidade.isTable()>
   
    /** 
     * Retorna a chave primária da entidade ${entidade.nome?cap_first}
     * 
     * @return ${entidade.nome}Pk
     */
    public ${entidade.nome}Pk getPk() {
        return new ${entidade.nome}Pk(<#list entidade.attrs as a><#if a.isPk>get${a.nome?cap_first}()<#if a_index < entidade.lastKeyAtt>, </#if></#if></#list>);
    }    
</#if>
<#list entidade.attrs as a>

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
</#if>

    /** 
     * Define o valor do campo ${a.descricao}
     * 
     * @param ${a.nome?uncap_first}
     */
    public void set${a.nome?cap_first}(${a.tipo} ${a.nome?uncap_first}) {
        this.${a.nome?uncap_first} = ${a.nome?uncap_first};
    }
</#list>

    /**
     * Retorna o valor das propriedades do bean em um JSONArray
     * 
     * @return JSONArray
     */
    @Override
    public JSONArray toArray() {
        JSONArray obj = new JSONArray();
<#list entidade.attrs as a>
        obj.add(<#if a.tipo == "boolean">is<#else>get</#if>${a.nome?cap_first}());
</#list>
        return obj;
    }

    /**
     * Gera e retorna um código hash para essa instância de ${entidade.nome}
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
     * Retorna verdadeiro se os dois objetos forem iguais
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
     * Retorna a representação do campo em String
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
