import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {

	public static void main(String[] args) throws Exception {
	
		//Fazer uma conexão HTTP e buscar os tops 250 filmes
		String url = "https://alura-imdb-api.herokuapp.com/movies";
		URI endereco = URI.create(url);
		var client =  HttpClient.newHttpClient();
		var request = HttpRequest.newBuilder(endereco).GET().build();
		var response = client.send(request, BodyHandlers.ofString());
		String body = response.body();
				
		//extrair só os dados que interessa (titulo, poster, raking)
		var parser = new JsonParser();
		List<Map<String, String>> listaDeFilmes = parser.parse(body);
	
	   //exibir e manipular os dados.
		var geradora = new GeradoraDeFigurinhas();
		for (Map<String, String> filme : listaDeFilmes) {

			String urlImagem = filme.get("image");
			String titulo =  filme.get("title");

			InputStream inputStream = new URL(urlImagem).openStream();
			String nomeArquivo =  titulo + ".png";

			geradora.cria(inputStream, nomeArquivo);

			System.out.println(titulo);
			System.out.println(urlImagem);
			System.out.println(filme.get("imDbRating"));
			System.out.println();


			
		}
				
	}

}
