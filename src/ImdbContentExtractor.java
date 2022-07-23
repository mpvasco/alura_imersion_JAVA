import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ImdbContentExtractor {

  public List<Content> extractContents(String json) {

    // extrair os dados que vamos usar (titulo, poster, classificação)
      var parser = new JsonParser();
      List<Map<String,String>> atributesList = parser.parse(json);

      List<Content> contents = new ArrayList<>();

      //popular a lsita de conteudos
      for (Map<String,String> atributes : atributesList ){
        String titulo = atributes.get("title");
          String[] maxSize = atributes.get("image").split("@._V1_");
          var newUrl = maxSize[0] + "@.png";
        String urlImagem = newUrl;

        // InputStream inputStream = new URL(newUrl).openStream();


        var content = new Content(titulo, urlImagem);

        contents.add(content);
      }


      return contents;

    
  }
}
