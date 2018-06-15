/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mar.mil.br.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

/**
 *
 * @author Junior
 */
@Entity
public class Manutencao implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    

@NumberFormat(pattern ="#,##0.00")
@DecimalMin(value = "0.01" , message="Valor não poder ser menor que 1 centavo!")
@DecimalMax(value="999999.99", message= "Valor não pode ser maior que 9.999.999.,99 !")
private BigDecimal orcamento;
       
  @NotNull(message = "Ano não pode ser vazio")  
   private String ano;
  
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
   private Date apresentacao;
    
  @DateTimeFormat(pattern = "dd/MM/yyyy")
  @Temporal(TemporalType.DATE)
    private Date dataPrintificacao;
    
    private String satisfeito;
    
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Date garantia;
 
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Date ultimaAtualizacao;
    
    private String atualizador;   
    
    private String observacao;
    
    private String nPS;
    private String pm;
    private String mes;
    
    @OneToOne
    @JoinColumn(name = "vtr_id")
    private Viatura viatura;

    public String getNPS() {
        return nPS;
    }

    public void setNPS(String nPS) {
        this.nPS = nPS;
    }

   

    public String getPm() {
        return pm;
    }

    public void setPm(String pm) {
        this.pm = pm;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

   
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(BigDecimal orcamento) {
        this.orcamento = orcamento;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    

    public Date getApresentacao() {
        return apresentacao;
    }

    public void setApresentacao(Date apresentacao) {
        this.apresentacao = apresentacao;
    }

    public Date getDataPrintificacao() {
        return dataPrintificacao;
    }

    public void setDataPrintificacao(Date dataPrintificacao) {
        this.dataPrintificacao = dataPrintificacao;
    }

    public String getSatisfeito() {
        return satisfeito;
    }

    public void setSatisfeito(String satisfeito) {
        this.satisfeito = satisfeito;
    }

    public Date getGarantia() {
        return garantia;
    }

    public void setGarantia(Date garantia) {
        this.garantia = garantia;
    }

    public Date getUltimaAtualizacao() {
        return ultimaAtualizacao;
    }

    public void setUltimaAtualizacao(Date ultimaAtualizacao) {
        this.ultimaAtualizacao = ultimaAtualizacao;
    }

    public String getAtualizador() {
        return atualizador;
    }

    public void setAtualizador(String atualizador) {
        this.atualizador = atualizador;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Viatura getViatura() {
        return viatura;
    }

    public void setViatura(Viatura viatura) {
        this.viatura = viatura;
    }

    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }

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
        final Manutencao other = (Manutencao) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Manutencao{" + "id=" + id + ", orcamento=" + orcamento + ", ano=" + ano + ", apresentacao=" + apresentacao + ", dataPrintificacao=" + dataPrintificacao + ", satisfeito=" + satisfeito + ", garantia=" + garantia + ", ultimaAtualizacao=" + ultimaAtualizacao + ", atualizador=" + atualizador + ", observacao=" + observacao + ", nPS=" + nPS + ", pm=" + pm + ", mes=" + mes + ", viatura=" + viatura + '}';
    }

    
}
