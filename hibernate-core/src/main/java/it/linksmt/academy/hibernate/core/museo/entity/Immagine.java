package it.linksmt.academy.hibernate.core.museo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "immagine")
public class Immagine implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_immagine")
    private Long id;

    @Column(name = "data_inserimento")
    private Date dataInserimento;

    @Column(name = "data_modifica")
    private Date dataModifica;

    @Column(name = "id_operatore")
    private Date idOperatore;

    private Byte[] foto;

    @ManyToOne(targetEntity = Articolo.class)
    @JoinColumn(name = "fk_id_articolo")
    private Articolo articolo;

    public Immagine() {
    }

    public Immagine(Long id, Date dataInserimento, Date dataModifica, Date idOperatore, Byte[] foto,
                    Articolo articolo) {
        super();
        this.id = id;
        this.dataInserimento = dataInserimento;
        this.dataModifica = dataModifica;
        this.idOperatore = idOperatore;
        this.foto = foto;
        this.articolo = articolo;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getIdOperatore() {
        return idOperatore;
    }

    public void setIdOperatore(Date idOperatore) {
        this.idOperatore = idOperatore;
    }

    public Byte[] getFoto() {
        return foto;
    }

    public void setFoto(Byte[] foto) {
        this.foto = foto;
    }

    public Articolo getArticolo() {
        return articolo;
    }

    public void setArticolo(Articolo articolo) {
        this.articolo = articolo;
    }

}