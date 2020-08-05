
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class main implements ActionListener {
    public TextField coin;
    public Label coin_lb;

    public Checkbox ship1;
    public Label ship1_lb;

    public Checkbox ship2;
    public Label ship2_lb;

    public Checkbox ship3;
    public Label ship3_lb;

    public Checkbox ship4;
    public Label ship4_lb;

    public Checkbox ship5;
    public Label ship5_lb;

    public Checkbox ship6;
    public Label ship6_lb;

    public Checkbox ship7;
    public Label ship7_lb;

    public TextField finalpoint;
    public Label finalpoint_lb;

    public Button where_is;
    public Button submit;

    byte[] original = decoder.get_file(decoder.get_save_path());
    public main(){
        //Create Frame
        JFrame pnl = new JFrame();

        //Define where is leader border modered
        where_is = new Button("Leaderboard Mod");
        where_is.setBounds(40,360,100,20);
        where_is.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        infoBox("Get your own highscore", "Ur Lazy");
                    }
                }
        );

        //Define coin field
        coin_lb = new Label("Coins:");
        coin=new TextField();

        coin_lb.setBounds(20,40,40,20);
        coin.setBounds(80,40,40,20);
        coin.setText( String.valueOf( decoder.read_coins(original) ) );

        //Define submit button
        submit=new Button("Set");
        submit.setBounds(70,380,40,20);
        submit.addActionListener(this);

        //Define ship1 check
        ship1 = new Checkbox();
        ship1_lb = new Label("Ship 2:");

        ship1.setBounds(80,80,40,20);
        ship1_lb.setBounds(20,80,40,20);

        //Define ship2 check
        ship2 = new Checkbox();
        ship2_lb = new Label("Ship 3:");

        ship2.setBounds(80,120,40,20);
        ship2_lb.setBounds(20,120,40,20);

        //Define ship3 check
        ship3 = new Checkbox();
        ship3_lb = new Label("Ship 4:");

        ship3.setBounds(80,160,40,20);
        ship3_lb.setBounds(20,160,40,20);

        //Define ship4 check
        ship4 = new Checkbox();
        ship4_lb = new Label("Ship 5:");

        ship4.setBounds(80,200,40,20);
        ship4_lb.setBounds(20,200,40,20);

        //Define ship5 check
        ship5 = new Checkbox();
        ship5_lb = new Label("Ship 6:");

        ship5.setBounds(80,240,40,20);
        ship5_lb.setBounds(20,240,40,20);

        //Define ship6 check
        ship6 = new Checkbox();
        ship6_lb = new Label("Ship 7:");

        ship6.setBounds(80,280,40,20);
        ship6_lb.setBounds(20,280,40,20);

        //Define ship7 check
        ship7 = new Checkbox();
        ship7_lb = new Label("Ship 8:");

        ship7.setBounds(80,320,40,20);
        ship7_lb.setBounds(20,320,40,20);

        //Define Total point box
        finalpoint = new TextField();
        finalpoint_lb = new Label("Total Points:");

        finalpoint_lb.setBounds(140,40,80,20);
        finalpoint.setBounds(250,40,80,20);


        //Add objects to Frame
        pnl.add(coin);
        pnl.add(coin_lb);

        //pnl.add(finalpoint);
        //pnl.add(finalpoint_lb);

        pnl.add(ship1);
        pnl.add(ship1_lb);

        pnl.add(ship2);
        pnl.add(ship2_lb);

        pnl.add(ship3);
        pnl.add(ship3_lb);

        pnl.add(ship4);
        pnl.add(ship4_lb);

        pnl.add(ship5);
        pnl.add(ship5_lb);

        pnl.add(ship6);
        pnl.add(ship6_lb);

        pnl.add(ship7);
        pnl.add(ship7_lb);

        pnl.add(submit);

        pnl.add(where_is);

        //Define parts of frame
        pnl.setSize(200,450);
        pnl.setTitle("Save Editor");
        pnl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pnl.setLocationRelativeTo(null);
        pnl.setLayout(null);
        pnl.setVisible(true);
    }
    public static void main(String[] args){
        new main();
        byte[] file = decoder.get_file(decoder.get_save_path());
        System.out.println(decoder.read_coins(decoder.get_file(decoder.get_save_path())));
        Scanner scn = new Scanner(System.in);
        while (true) {
            int scan = scn.nextInt();
            System.out.println(file[scan]);
            System.out.println(Integer.toHexString((int) file[scan]));
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        try {
            byte[] file = decoder.get_file(decoder.get_save_path());

            System.out.println(decoder.read_coins(decoder.get_file(decoder.get_save_path())));
            if (Integer.parseInt(coin.getText()) <= 255) { file[16] = (byte) Integer.parseInt(coin.getText()); } else{ infoBox("Coin count must be less than 255", "WARNING");}
            file[163] = (byte) (ship1.getState() ? 1 : 0); //ship v2
            file[142] = (byte) (ship2.getState() ? 1 : 0); //ship v3
            file[121] = (byte) (ship3.getState() ? 1 : 0); //ship v4
            file[100] = (byte) (ship4.getState() ? 1 : 0); //ship v5
            file[79] = (byte) (ship5.getState() ? 1 : 0); //ship v6
            file[58] = (byte) (ship6.getState() ? 1 : 0); //ship v7
            file[37] = (byte) (ship7.getState() ? 1 : 0); //ship v8


            System.out.println(file[163]);
            decoder.write_data(file);
        }
        catch (Exception E){
            E.printStackTrace();
        }
    }

    // I stole this from here because I'm lazy https://stackoverflow.com/questions/7080205/popup-message-boxes
    public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "Notice: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
}
