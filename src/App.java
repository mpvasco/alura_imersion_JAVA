import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        
        // fazer uma conexao http para buscar top 250
        String url = "https://imdb-api.com/en/API/Top250Movies/k_1dl7femf";
        URI endereço = URI.create(url); //criar uma URI associando a URL
        var client = HttpClient.newHttpClient();  // <- são a mesma coisa, isso é mais novo. esse é o mais antigo -> ::::::: HttpClient client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereço).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
        
        
        
        // extrair os dados que vamos usar (titulo, poster, classificação)
        var parser = new JsonParser();
        List<Map<String,String>> listaDeFilmes = parser.parse(body);
        System.out.println(listaDeFilmes.size());

        // exibir e manipular os dados como a gente quiser:
            //importar a classe geradora de figurinhas
            var genarator = new StickerGenarator();
        for (Map<String,String> filme : listaDeFilmes) {
            

            String title = filme.get("title");
            String rating = filme.get("imDbRating");
            // System.out.println(filme.get("image"));   // thumbnail
            String[] maxSize = filme.get("image").split("@._V1_");
            var newUrl = maxSize[0] + "@.png";
            InputStream inputStream = new URL(newUrl).openStream();

            genarator.creation(inputStream, title+".png", "Rating: "+rating+" ✨");

            System.out.println(title);
            System.out.println();
            
        }
    }
}
