package tic_tac_toe;

import java.awt.*;
import java.awt.event.MouseListener;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.JFrame;

import org.w3c.dom.events.MouseEvent;

import java.awt.image.BufferedImage;


public class TicTacToe implements Runnable{

    private String ip = "localhost";
    private int port = 22222;
    private Scanner scanner = new Scanner(System.in);
    private JFrame frame;
    private final int WIDTH = 506;
    private final int HEIGHT = 527;
    private Thread thread;

    private Painter painter;
    private Socket socket;
    private DataOutputStream dos;
    private DataInputStream dis;
    
    private ServerSocket serverSocket;
    
    private BufferedImage board;
    private BufferedImage redX;
    private BufferedImage blueX;
    private BufferedImage redCircle;
    private BufferedImage blueCircle;

    private String[] spaces = new String[0];

    private boolean yourTurn = false;
    private boolean circle = true;
    private boolean accepted = false;
    private boolean unableToCommunicateWithOpponent = false;
    private boolean won = false;
    private boolean enemyWon = false;

    private int lnegthOfSpace = 160;
    private int errors = 0;
    private int firstSpot = -1;
    private int secondSpot = -1;

    private Font font = new Font("Verdana", Font.BOLD, 32);
    private Font smallerFont = new Font("Verdana", Font.BOLD, 20);
    private Font largerFont = new Font("Verdana", Font.BOLD, 50);

    private String waitingString = "Waiting for another player";
    private String unableToCommunicateWithOpponentString = "Unable to communicate with oponent.";
    private String wonString = "You won!";
    private String enemyWonString = "Oponent won!";

    public TicTacToe(){
        System.out.println("Please input the IP: ");
        ip = scanner.nextLine();
        System.out.println("Please input the port: ");
        port  = scanner.nextInt();
        while(port < 1 || port > 65535){
            System.out.println("The port you entered was invalid, please input another port: ");
            port = scanner.nextInt();
        }

        loadImages();

        painter = new Painter();
        painter.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        
    }

    public void run(){

    }

    private void loadImages(){
        try {
            board = ImageIO.read(getClass().getResourceAsStream("tic_tac_toe/board.png"));
            redX = ImageIO.read(getClass().getResourceAsStream("tic_tac_toe.redX.png"));
            redCircle = ImageIO.read(getClass().getResourceAsStream("tic_tac_toe.redCircle.png"));
            blueX = ImageIO.read(getClass().getResourceAsStream("tic_tac_toe.blueX.png"));
            blueCircle = ImageIO.read(getClass().getResourceAsStream("tic_tac_toe.blueCircle.png"));

        
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unused")
    public static void main(String[] args){
       TicTacToe ticTacToe = new TicTacToe(); 
    }

    private class Painter extends JPanel implements MouseListener{

        private static final long serialVersionUID = 1L;

        public Painter(){
            setFocusable(true);
            requestFocus();
            setBackground(Color.WHITE);
            addMouseListener(this);
        }

        @Override
        public void painterComponent(Graphics g){
            
        }
        
        @Override
        public void mouseClicked(java.awt.event.MouseEvent e) {

        }

        @Override
        public void mousePressed(java.awt.event.MouseEvent e) {

        }

        @Override
        public void mouseReleased(java.awt.event.MouseEvent e) {

        }

        @Override
        public void mouseEntered(java.awt.event.MouseEvent e) {

        }

        @Override
        public void mouseExited(java.awt.event.MouseEvent e) {

        }

    }
}

// 20 minutes