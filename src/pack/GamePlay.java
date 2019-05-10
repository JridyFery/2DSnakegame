package pack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePlay extends JPanel implements KeyListener, ActionListener {


    private int[] snakexlength=new int[750];
    private int[] snakeylength=new int[750];

    private boolean left=false;
    private boolean right=false;
    private boolean up=false;
    private boolean down=false;

    private ImageIcon leftmouth;
    private ImageIcon rightmouth;
    private ImageIcon upmouth;
    private ImageIcon downmouth;

    private int lengthofsnake=3;

    private Timer timer;
    private int delay=100;
    private int moves=0;

    private ImageIcon snakeimage;


    private ImageIcon titleimage;



    public GamePlay(){
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer=new Timer(delay,this);
        timer.start();
    }


    public void paint(Graphics g){
        if(moves==0){
        snakexlength[2]=50;
        snakexlength[1]=75;
        snakexlength[0]=100;

        snakeylength[2]=100;
        snakeylength[1]=100;
        snakeylength[0]=100;
    }
    //draw title image border
        g.setColor(Color.white);
        g.drawRect(24,10,851,55);


        //draw the title image
        titleimage=new ImageIcon("snaketitle.jpg");
        titleimage.paintIcon(this,g,25,11);


        //draw border for GamePlay
        g.setColor(Color.white);
        g.drawRect(24,74,851,577);


         //drawing background for the GamePlay
        g.setColor(Color.black);
        g.fillRect(25,75,850,575);
        rightmouth=new ImageIcon("rightmouth.png");
        rightmouth.paintIcon(this,g,snakexlength[0],snakeylength[0]);
        for(int i=0;i<lengthofsnake;i++){
            if(i==0 && right){
                rightmouth=new ImageIcon("rightmouth.png");
                rightmouth.paintIcon(this,g,snakexlength[i],snakeylength[i]);
            }
            if(i==0 && left){
                leftmouth=new ImageIcon("leftmouth.png");
                leftmouth.paintIcon(this,g,snakexlength[i],snakeylength[i]);
            }
            if(i==0 && down){
                downmouth=new ImageIcon("downmouth.png");
                downmouth.paintIcon(this,g,snakexlength[i],snakeylength[i]);
            }
            if(i==0 && up){
                upmouth=new ImageIcon("upmouth.png");
                upmouth.paintIcon(this,g,snakexlength[i],snakeylength[i]);
            }
            if(i!=0){
                snakeimage=new ImageIcon("snakeimage.png");
                snakeimage.paintIcon(this,g,snakexlength[i],snakeylength[i]);
            }
        }


    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if(keyEvent.getKeyCode() == KeyEvent.VK_RIGHT){

            moves++;
            right=true;
            if(!left){
                right=true;
            }
            else { right=false;
            left=true;}

            down=false;
            up=false;
        }
        if(keyEvent.getKeyCode() == KeyEvent.VK_LEFT){

            moves++;
            left=true;
            if(!right){
                left=true;
            }
            else { left=false;
                right=true;}

            down=false;
            up=false;
        }
        if(keyEvent.getKeyCode() == KeyEvent.VK_UP){

            moves++;
            up=true;
            if(!down){
                up=true;
            }
            else { up=false;
                down=true;}

            left=false;
            right=false;
        }
        if(keyEvent.getKeyCode() == KeyEvent.VK_DOWN){

            moves++;
            down=true;
            if(!up){
                down=true;
            }
            else { down=false;
                up=true;}

            left=false;
            right=false;
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {


    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        timer.start();
        if(right) {
            for (int r = lengthofsnake - 1; r >= 0; r--) {
                snakeylength[r + 1] = snakeylength[r];
            }
            for (int r = lengthofsnake; r >= 0; r--) {
                if (r == 0) {
                    snakexlength[r] = snakexlength[r] + 25;
                } else
                    snakexlength[r] = snakexlength[r - 1];

                if (snakexlength[r] > 850) {
                    snakexlength[r] = 25;
                }
            }
            repaint();
        }
        if(left) {
            for (int r = lengthofsnake - 1; r >= 0; r--) {
                snakeylength[r + 1] = snakeylength[r];
            }
            for (int r = lengthofsnake; r >= 0; r--) {
                if (r == 0) {
                    snakexlength[r] = snakexlength[r] - 25;
                } else
                    snakexlength[r] = snakexlength[r - 1];

                if (snakexlength[r] < 25) {
                    snakexlength[r] = 850;
                }
            }
            repaint();
        }
        if(down) {
            for (int r = lengthofsnake - 1; r >= 0; r--) {
                snakexlength[r + 1] = snakexlength[r];
            }
            for (int r = lengthofsnake; r >= 0; r--) {

                if (r == 0) {
                    snakeylength[r] = snakeylength[r] + 25;
                } else
                    snakeylength[r] = snakeylength[r - 1];

                if (snakeylength[r] > 625) {
                    snakeylength[r] = 75;
                }
            }
            repaint();
        }
        if(up) {
            for (int r = lengthofsnake - 1; r >= 0; r--) {
                snakexlength[r + 1] = snakexlength[r];
            }
            for (int r = lengthofsnake; r >= 0; r--) {

                if (r == 0) {
                    snakeylength[r] = snakeylength[r] - 25;
                } else
                    snakeylength[r] = snakeylength[r - 1];

                if (snakeylength[r] < 75) {
                    snakeylength[r] =625;
                }
            }
            repaint();
        }

    }
}
