package br.com.leonardo.transacao.cartao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Cartao {

    @Id
    String id;

    String Email;

    @Column(unique = true)
    private String numero;

    @Deprecated
    public Cartao() {
    }


    public Cartao(String id, String email) {
        this.id = id;
        Email = email;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return Email;
    }
}
