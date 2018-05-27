/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jpe.script.crd.utils;

/**
 * TemplateCampo
 *
 * @author joaovperin
 */
public class TemplateAttribute {

    /** Field name */
    private String nome;
    /** Field description */
    private String descricao;
    /** Field type */
    private String tipo;
    /** Field is Primary Key? */
    private boolean isPk;
    /** Field is Autoincremented? */
    private boolean autoIncrement;

    /**
     * Constructor
     *
     * @param f
     */
    public TemplateAttribute(Field f) {
        nome = Text.uncapitalize(f.getField());
        descricao = f.getComment();
        tipo = FieldConverter.get(f.getType());
        isPk = f.isPk();
        autoIncrement = f.isAutoIncrement();
    }

    /**
     * Gets
     *
     * @return String
     */
    public String getNome() {
        return nome;
    }

    /**
     * Sets
     *
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Gets
     *
     * @return String
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Sets
     *
     * @param descricao
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Gets
     *
     * @return String
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Sets
     *
     * @param tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Returns true if
     *
     * @return boolean
     */
    public boolean isIsPk() {
        return isPk;
    }

    /**
     * Sets
     *
     * @param isPk
     */
    public void setIsPk(boolean isPk) {
        this.isPk = isPk;
    }

    /**
     * Returns true if
     *
     * @return boolean
     */
    public boolean isAutoIncrement() {
        return autoIncrement;
    }

    /**
     * Sets
     *
     * @param autoIncrement
     */
    public void setAutoIncrement(boolean autoIncrement) {
        this.autoIncrement = autoIncrement;
    }

}
