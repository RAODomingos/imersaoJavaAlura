import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {

	
	public void cria() throws Exception {
		
		// leitura da imagem
		BufferedImage imagemOriginal =  ImageIO.read(new File("entrada/img.jpg"));
	
		
		// criar nova image em memoria com transparencia e com tamanho novo
		int largura = imagemOriginal.getWidth();
		int altura = imagemOriginal.getHeight();
		int novaAltura = altura + 200;
		BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);
			
		
		
		// copiar a imagem original para novo imagem (em memoria) 
		Graphics2D graphics = (Graphics2D)  novaImagem.getGraphics();
		graphics.drawImage(imagemOriginal, 0, 0, null);
		
		
		
		// Escrever uma frase na nova imagem
	
		
		// salvar nova imagemk
		ImageIO.write(novaImagem, "png", new File("saida/figurinha.png"));
		
				
	}

    public static void main(String[] args) throws Exception {
        var geradora = new GeradoraDeFigurinhas();
        geradora.cria();
    
    }
}
