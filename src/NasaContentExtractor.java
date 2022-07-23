import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NasaContentExtractor {
  
  public List<Content> extractContents(String json) {

      // extrair os dados que vamos usar (titulo, poster, classificação)
      var parser = new JsonParser();
      List<Map<String,String>> atributesList = parser.parse(json);

      List<Content> contents = new ArrayList<>();

      //popular a lsita de conteudos
      for (Map<String,String> atributes : atributesList ){
        String titulo = atributes.get("title");
        String urlImagem = atributes.get("url");
        var content = new Content(titulo, urlImagem);

        contents.add(content);
      }


      return contents;
  }
}
