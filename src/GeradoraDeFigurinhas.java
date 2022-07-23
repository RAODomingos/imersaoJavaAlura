import javax.imageio.ImageIO;
import java.awt.*;
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

        // Configurar a fonte
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
        graphics.setFont(fonte);
        graphics.setColor(Color.YELLOW);

        // Escrever uma frase na nova imagem.
        graphics.drawString("TOPZERA", 200, novaAltura - 100);
        
        // Escrever a nova imagem em um novo arquivo
        ImageIO.write(novaImagem, "png", new File("saida/figurinha.png"));
    }

    public static void main(String[] args) throws Exception {
        var geradora = new GeradoraDeFigurinhas();
        geradora.cria();
    }
}
