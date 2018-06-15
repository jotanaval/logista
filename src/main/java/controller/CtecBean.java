
package mar.mil.br.controller;

import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import mar.mil.br.entity.Ctec;
import mar.mil.br.entity.Viatura;
import mar.mil.br.repository.CtecRepository;
import mar.mil.br.repository.ViaturaRepository;
import org.springframework.security.core.context.SecurityContextHolder;

@ManagedBean
@RequestScoped
public class CtecBean {
    @EJB
    private CtecRepository ctecRepository;
    
    @EJB
    private ViaturaRepository viaturaRepository;
    
    private Ctec ctec = new Ctec();
     //este atributo é para fazer o relacionamento na hora da gravação
   Long viaturaID;
   
   //pegando usuario logado e adicionando o nome dele a atualização
   String modificador = SecurityContextHolder.getContext().getAuthentication().getName();
   
   public String salvar(){
       if (ctec.getId() == null) {
            Viatura v = viaturaRepository.findById(viaturaID);
            ctec.setViatura(v);
            ctec.setUltimaAtualizacao(new Date());
            ctec.setModificador(modificador);
            ctecRepository.save(ctec);
           
       } else {
           Viatura v = viaturaRepository.findById(viaturaID);
            ctec.setViatura(v);
            ctec.setUltimaAtualizacao(new Date());
            ctec.setModificador(modificador);
            ctecRepository.update(ctec);
       }
       return "CteC?faces-redirect=true";
   }
   public  String editar(){
       return "addCtec";
   }
   public String excluir(){
       this.ctecRepository.delete(ctec.getId());
       return null;
   }
   
   
   
   public List<Ctec>getCtecs(){
       List<Ctec>ctecs = this.ctecRepository.findAll();
       return ctecs;
       
   }

    public Ctec getCtec() {
        return ctec;
    }

    public void setCtec(Ctec ctec) {
        this.ctec = ctec;
    }

    public Long getViaturaID() {
        return viaturaID;
    }

    public void setViaturaID(Long viaturaID) {
        this.viaturaID = viaturaID;
    }
   
   
    
}
