package ifpb.ads.aula.rest;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 15/02/2017, 14:01:10
 */
@XmlRootElement
public class Produto implements Serializable{

    private String nome;

    public Produto(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Produto() {
    }

}
