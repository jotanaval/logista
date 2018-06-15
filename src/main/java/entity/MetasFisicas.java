package mar.mil.br.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MetasFisicas implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mtNome;
    private String anoMetas;
    private Integer qtd;
    private Integer lvad;
    private Integer retiradas;
    private Long porcentagem;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMtNome() {
        return mtNome;
    }

    public void setMtNome(String mtNome) {
        this.mtNome = mtNome;
    }

    public String getAnoMetas() {
        return anoMetas;
    }

    public void setAnoMetas(String anoMetas) {
        this.anoMetas = anoMetas;
    }

    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }

    public Integer getLvad() {
        return lvad;
    }

    public void setLvad(Integer lvad) {
        this.lvad = lvad;
    }

    public Integer getRetiradas() {
        return retiradas;
    }

    public void setRetiradas(Integer retiradas) {
        this.retiradas = retiradas;
    }

    public Long getPorcentagem() {
        return porcentagem;
    }

    public void setPorcentagem(Long porcentagem) {
        this.porcentagem = porcentagem;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.id);
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
        final MetasFisicas other = (MetasFisicas) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MetasFisicas{" + "id=" + id + ", mtNome=" + mtNome + ", anoMetas=" + anoMetas + ", qtd=" + qtd + ", lvad=" + lvad + ", retiradas=" + retiradas + ", porcentagem=" + porcentagem + '}';
    }

  
    
    
}
