package com.sae.sae.model;

import java.util.List;

public class Paciente {
    private String nome;
    private String sexo;
    private String dtnasc;
    private int idade;
    private String regInternacao;
    private String convenio;
    private String unidadeOrigem;
    private String alergias;
    private String medicamentos;
    private boolean comorbidades;
    private boolean usaDrogras;
    private boolean usaProteses;
    private boolean limitacaoMobilidade;
    private boolean deficienciaComunicacao;
    private List<String> classASA;
    private String pressaoArterial;

    public Paciente() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(String medicamentos) {
        this.medicamentos = medicamentos;
    }

    public boolean isComorbidades() {
        return comorbidades;
    }

    public void setComorbidades(boolean comorbidades) {
        this.comorbidades = comorbidades;
    }

    public boolean isUsaDrogras() {
        return usaDrogras;
    }

    public void setUsaDrogras(boolean usaDrogras) {
        this.usaDrogras = usaDrogras;
    }

    public boolean isUsaProteses() {
        return usaProteses;
    }

    public void setUsaProteses(boolean usaProteses) {
        this.usaProteses = usaProteses;
    }

    public boolean isLimitacaoMobilidade() {
        return limitacaoMobilidade;
    }

    public void setLimitacaoMobilidade(boolean limitacaoMobilidade) {
        this.limitacaoMobilidade = limitacaoMobilidade;
    }

    public boolean isDeficienciaComunicacao() {
        return deficienciaComunicacao;
    }

    public void setDeficienciaComunicacao(boolean deficienciaComunicacao) {
        this.deficienciaComunicacao = deficienciaComunicacao;
    }

    public List<String> getClassASA() {
        return classASA;
    }

    public void setClassASA(List<String> classASA) {
        this.classASA = classASA;
    }

    public String getPressaoArterial() {
        return pressaoArterial;
    }

    public void setPressaoArterial(String pressaoArterial) {
        this.pressaoArterial = pressaoArterial;
    }

    public String getDtnasc() {
        return dtnasc;
    }

    public void setDtnasc(String dtnasc) {
        this.dtnasc = dtnasc;
    }

    public String getRegInternacao() {
        return regInternacao;
    }

    public void setRegInternacao(String regInternacao) {
        this.regInternacao = regInternacao;
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    public String getUnidadeOrigem() {
        return unidadeOrigem;
    }

    public void setUnidadeOrigem(String unidadeOrigem) {
        this.unidadeOrigem = unidadeOrigem;
    }
}
