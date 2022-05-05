package folha2.ex2a;

import javax.swing.*;
import java.awt.*;

public class DrawCircles extends JFrame {

    Circulo circulo1;
    Circulo circulo2;

    public DrawCircles(Circulo circulo1,Circulo circulo2){
        this.circulo1 = circulo1;
        this.circulo2 = circulo2;

        setTitle("Circulos");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setAlwaysOnTop(true);
        setAlwaysOnTop(false);
    }

    @Override
    public void paint(Graphics g){

        Graphics2D g2d = (Graphics2D) g;

        Color color1;
        switch (circulo1.getCor()){
            case "azul":
                color1 = Color.blue;
                break;
            case "verde":
                color1 = Color.green;
                break;
            case "vermelho":
                color1 = Color.red;
                break;
            case "preto":
                color1 = Color.black;
                break;
            default:
                color1 = Color.black;
                break;
        }

        Color color2;
        switch (circulo2.getCor()){
            case "azul":
                color2 = Color.blue;
                break;
            case "verde":
                color2 = Color.green;
                break;
            case "vermelho":
                color2 = Color.red;
                break;
            case "preto":
                color2 = Color.black;
                break;
            default:
                color2 = Color.black;
                break;
        }

        g2d.setColor(color1);
        g2d.setStroke(new BasicStroke(10));
        g2d.drawOval(getWidth()/2-(circulo1.getRaio()/2),getHeight()/2-(circulo1.getRaio()/2),circulo1.getRaio(),circulo1.getRaio());

        g2d.setColor(color2);
        g2d.drawOval(getWidth()/2-(circulo2.getRaio()/2),getHeight()/2-(circulo2.getRaio()/2),circulo2.getRaio(),circulo2.getRaio());


        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("default",Font.BOLD,20));
        g2d.drawString("Primeiro circulo:",100,100);
        g2d.drawString("Raio: " + circulo1.getRaio(),100,130);
        g2d.drawString("Área: " + circulo1.areaCirculo(),100,160);

        g2d.drawString("Segundo circulo:",100,200);
        g2d.drawString("Raio: " + circulo2.getRaio(),100,230);
        g2d.drawString("Área: " + circulo2.areaCirculo(),100,260);



    }


}
