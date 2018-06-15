/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mar.mil.br.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "viatura")
public class Viatura implements  Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String cfn;
    private String om;
    private String escalacao;
    private String fer;
    @Temporal(TemporalType.DATE)
    private Date ultimaAtualizacao;
    private String modificador;
    @Column(name = "situacao")
    private String situacao;
    
    private String anoFabricacao;
    private String chassi;
    
    @ManyToOne
    @JoinColumn(name = "modelo_id")
      private Modelo modelo;
    
    

    public Viatura() {
        super();
    }

    public Viatura(Long id, String cfn, String om, String escalacao, String fer, Date ultimaAtualizacao, String modificador, String situacao, String anoFabricacao, String chassi, Modelo modelo) {
       
        this.cfn = cfn;
        this.om = om;
        this.escalacao = escalacao;
        this.fer = fer;
        this.ultimaAtualizacao = ultimaAtualizacao;
        this.modificador = modificador;
        this.situacao = situacao;
        this.anoFabricacao = anoFabricacao;
        this.chassi = chassi;
       
    }

    

  
    
    

    public String getModificador() {
        return modificador;
    }

    public void setModificador(String modificador) {
        this.modificador = modificador;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCfn() {
        return cfn;
    }

    public void setCfn(String cfn) {
        this.cfn = cfn;
    }


    public String getOm() {
        return om;
    }

    public void setOm(String om) {
        this.om = om;
    }

    public String getEscalacao() {
        return escalacao;
    }

    public void setEscalacao(String escalacao) {
        this.escalacao = escalacao;
    }

    public String getFer() {
        return fer;
    }

    public void setFer(String fer) {
        this.fer = fer;
    }

   

    public Date getUltimaAtualizacao() {
        return ultimaAtualizacao;
    }

    public void setUltimaAtualizacao(Date ultimaAtualizacao) {
        this.ultimaAtualizacao = ultimaAtualizacao;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(String anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }
    
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.id);
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
        final Viatura other = (Viatura) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Viatura{" + "id=" + id + ", cfn=" + cfn + ", om=" + om + ", escalacao=" + escalacao + ", fer=" + fer + ", ultimaAtualizacao=" + ultimaAtualizacao + ", modificador=" + modificador + ", situacao=" + situacao + ", anoFabricacao=" + anoFabricacao + ", chassi=" + chassi + ", modelo=" + modelo + '}';
    }

   

    
    
}
