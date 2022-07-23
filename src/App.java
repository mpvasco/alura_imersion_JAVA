import java.io.InputStream;
import java.net.URL;
import java.util.List;


public class App {
    public static void main(String[] args) throws Exception {
        
        // fazer uma conexao http para buscar top 250
        String url = "https://imdb-api.com/en/API/Top250Movies/k_1dl7femf";
        var extractor = new ImdbContentExtractor();

        // String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/NASA-APOD.json";
        // var extractor = new NasaContentExtractor();
        
        var http = new ClientHttp();
        String json = http.getData(url);

        // exibir e manipular os dados como a gente quiser:
        List<Content> contents = extractor.extractContents(json);

            //importar a classe geradora de figurinhas
            var genarator = new StickerGenarator();

        for (int i = 0; i < 3; i++) {
            Content content = contents.get(i);
        
        
            InputStream inputStream = new URL(content.getUrlImagem()).openStream();

            genarator.creation(inputStream, content.getTitulo()+"2.png", "My texte goes here ✨");

            System.out.println(content.getTitulo());
            System.out.println();
            
        }
    }
}
