import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class ClientHttp {

    public String getData(String url) {

      try {
        // String url = "https://imdb-api.com/en/API/Top250Movies/k_1dl7femf";
        URI endereço = URI.create(url); //criar uma URI associando a URL
        var client = HttpClient.newHttpClient();  // <- são a mesma coisa, isso é mais novo. esse é o mais antigo -> ::::::: HttpClient client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereço).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
        return body;

      } catch (IOException | InterruptedException ex){
          throw new RuntimeException(ex);
      }





    }
}
