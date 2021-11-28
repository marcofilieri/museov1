package it.linksmt.academy.hibernate.core.museo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "museo")
public class Museo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_museo")
    private Long id;

    private String descrizione;
    private Byte[] logo;
    private String nome;

    @Column(name = "data_inserimento")
    private Date dataInserimento;

    @Column(name = "data_modifica")
    private Date dataModifica;

    @Column(name = "id_operatore")
    private Long idOperatore;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "museo")
    private List<Sede> sede;

    public Museo() {
    }

    public Museo(Long id, String descrizione, Byte[] logo, String nome, Date dataInserimento, Date dataModifica,
                 Long idOperatore, List<Sede> sede) {
        this.id = id;
        this.descrizione = descrizione;
        this.logo = logo;
        this.nome = nome;
        this.dataInserimento = dataInserimento;
        this.dataModifica = dataModifica;
        this.idOperatore = idOperatore;
        this.sede = sede;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Byte[] getLogo() {
        return logo;
    }

    public void setLogo(Byte[] logo) {
        this.logo = logo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataInserimento() {
        return dataInserimento;
    }

    public void setDataInserimento(Date dataInserimento) {
        this.dataInserimento = dataInserimento;
    }

    public Date getDataModifica() {
        return dataModifica;
    }

    public void setDataModifica(Date dataModifica) {
        this.dataModifica = dataModifica;
    }

    public Long getIdOperatore() {
        return idOperatore;
    }

    public void setIdOperatore(Long idOperatore) {
        this.idOperatore = idOperatore;
    }

    public List<Sede> getSede() {
        return sede;
    }

    public void setSede(List<Sede> sede) {
        this.sede = sede;
    }
}
