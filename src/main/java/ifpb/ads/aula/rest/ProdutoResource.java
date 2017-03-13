package ifpb.ads.aula.rest;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import javax.json.Json;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 15/02/2017, 10:07:46
 */
@Path("produto")
public class ProdutoResource {

    private final List<Produto> lista = Arrays.asList(new Produto("tv"), new Produto("caneta"));

    @GET
    @Produces({MediaType.APPLICATION_XML})
    public List<Produto> todos() {
        return lista;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Produto exibirUmProduto(@PathParam("id") int id) {
        return lista.get(id);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_XML)
//    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response salvarProduto(Produto produto) {
        URI uri = URI
                .create("http://localhost:8080/aula-rest/api/produto/3");

        return Response
                .created(uri)
                //                .entity(produto)
                .entity(Json
                        .createObjectBuilder()
                        .add("nome", produto.getNome())
                        .build())
                .build();
    }

    @POST
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public List<Produto> atualizarProdutoPath(
            @PathParam("id") int id,
            @FormParam("nomeProduto") String nomeProduto) {

        Produto produto = lista.get(id);
        produto.setNome(nomeProduto);
        lista.set(id, produto);
        
        return lista;

    }
    
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public List<Produto> atualizarProduto(
            @QueryParam("id") int id,
            @FormParam("nomeProduto") String nomeProduto) {

        Produto produto = lista.get(id);
        produto.setNome(nomeProduto);
        lista.set(id, produto);
        
        return lista;
//        return Response
//                .ok(produto)
//                .build();

    }
}
