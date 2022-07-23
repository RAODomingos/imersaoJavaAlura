import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;


public class GeradoraDeFigurinhas {
    public void cria() throws Exception {
        
        // Leitura da imagem
        BufferedImage imagemOriginal = ImageIO.read(new File("entrada/img.jpg"));

        // cria nova imagem em memoria com transparencia e com tamanho novo
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);


        // copiar a imagem original para nova imagem (em memoria) 
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null );
        // Escrever uma frase na nova imagem.
        
        
        // Escrever a nova imagem em um novo arquivo
        ImageIO.write(novaImagem, "png", new File("saida/figurinha.png"));
    }

    public static void main(String[] args) throws Exception {
        var geradora = new GeradoraDeFigurinhas();
        geradora.cria();
    }
}
