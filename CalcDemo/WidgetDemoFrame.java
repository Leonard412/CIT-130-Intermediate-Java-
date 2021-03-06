/*

 */
package calcdemo;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class WidgetDemoFrame extends JFrame implements ActionListener{
    JTextField jb = new JTextField();
    
    JPanel[] row = new JPanel[5];
    JButton[] button = new JButton[17];
    String[] buttonString = {"7", "8", "9", "+",
                            "4", "5", "6", "-",
                            "1", "2", "3", "*",
                             ".", "/", "C", 
                             "=", "0"};
    int[] dimW = {300,45,100,90};
    int[] dimH = {35, 40};
    
    Dimension displayDimension = new Dimension(dimW[0], dimH[0]);
    Dimension regularDimension = new Dimension(dimW[1], dimH[1]);
    Dimension rColumnDimension = new Dimension(dimW[2], dimH[1]);
    Dimension zeroButDimension = new Dimension(dimW[3], dimH[1]);
    boolean[] function = new boolean[4];
    double[] temporary = {0, 0};
    JTextArea display = new JTextArea(1,20);
    Font font = new Font("Calibri", Font.BOLD, 14);

    WidgetDemoFrame() {
        super("Calculator");
        setDesign();
        setSize(380, 250);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        GridLayout grid = new GridLayout(5,5);
        setLayout(grid);
        for(int i = 0; i < 4; i++)
            function[i] = false;
        
        FlowLayout f1 = new FlowLayout(FlowLayout.CENTER);
        FlowLayout f2 = new FlowLayout(FlowLayout.CENTER,1,1);

        for(int i = 0; i < 5; i++)

            row[i] = new JPanel();

        row[0].setLayout(f1);

        for(int i = 1; i < 5; i++)
            row[i].setLayout(f2);

        for(int i = 0; i < 19; i++) {
            button[i] = new JButton();
            button[i].setText(buttonString[i]);
            button[i].setFont(font);
            button[i].addActionListener(this);
        }
        display.setFont(font);
        display.setEditable(false);
        display.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        display.setPreferredSize(displayDimension);
        for(int i = 0; i < 14; i++)
            button[i].setPreferredSize(regularDimension);
        for(int i = 14; i < 18; i++)

            button[i].setPreferredSize(rColumnDimension);

        button[18].setPreferredSize(zeroButDimension);
         
        row[0].add(display);
        add(row[0]);
         
        for(int i = 0; i < 4; i++)
            row[1].add(button[i]);
        row[1].add(button[14]);
        add(row[1]);
         
        for(int i = 4; i < 8; i++)
            row[2].add(button[i]);
        row[2].add(button[15]);
        add(row[2]);
        
        for(int i = 8; i < 12; i++)
            row[3].add(button[i]);
        row[3].add(button[16]);
        add(row[3]);
        row[4].add(button[18]);
        
        for(int i = 12; i < 14; i++)
            row[4].add(button[i]);
        row[4].add(button[17]);
        add(row[4]);
         
        setVisible(true);
    }
    
    public void clear() 
    {
        try 
        {
            display.setText("");
            for(int i = 0; i < 4; i++)
                function[i] = false;
            for(int i = 0; i < 2; i++)
                temporary[i] = 0;
        } 
        catch(NullPointerException e) { }
    }
    
    public void getResult() {
        double result = 0;
        temporary[1] = Double.parseDouble(display.getText());
        String temp0 = Double.toString(temporary[0]);
        String temp1 = Double.toString(temporary[1]);
        try {
            if(temp0.contains("-")) {
                String[] temp00 = temp0.split("-", 2);
                temporary[0] = (Double.parseDouble(temp00[1]) * -1);
            }
            if(temp1.contains("-")) {
                String[] temp11 = temp1.split("-", 2);
                temporary[1] = (Double.parseDouble(temp11[1]) * -1);
            }
        } 
        catch(ArrayIndexOutOfBoundsException e) {}
        try 
        {
            if(function[2] == true)
                result = temporary[0] * temporary[1];
            else if(function[3] == true)
                result = temporary[0] / temporary[1];
            else if(function[0] == true)
                result = temporary[0] + temporary[1];
            else if(function[1] == true)
                result = temporary[0] - temporary[1];
            display.setText(Double.toString(result));
            for(int i = 0; i < 4; i++)
                function[i] = false;
        } catch(NumberFormatException e) {}
    }
     
    public final void setDesign() {
        try 
        {
            UIManager.setLookAndFeel(
                    "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } 
        catch(Exception e) { }
    }





    /*public WidgetDemoFrame() {
                     

                
        JMenuBar menuBar = new JMenuBar();
        JMenu menuFile = new JMenu();
        JMenuItem menuFileExit = new JMenuItem();
        Container c = getContentPane();
        c.setBackground(Color.YELLOW);
        JButton b1 = new JButton("1");
        JButton b2 = new JButton("2");
        JButton b3 = new JButton("3");
        JButton b4 = new JButton("4");
        JButton b5 = new JButton("5");
        JButton b6 = new JButton("6");
        JButton b7 = new JButton("7");
        JButton b8 = new JButton("8");
        JButton b9 = new JButton("9");
        JButton b0 = new JButton("0");
        JButton plus = new JButton("+");
        JButton minus = new JButton("-");
        JButton divide = new JButton("/");
        JButton multiply = new JButton("*");
        JButton clear = new JButton("C");
        JButton equals = new JButton("=");
        

        
        setLayout(new GridLayout(5,1));
        JPanel r1 = new JPanel();
        r1.setBackground(Color.RED);
        JPanel r2 = new JPanel();
        r2.setBackground(Color.WHITE);
        JPanel r3 = new JPanel();
        r3.setBackground(Color.BLUE);
        JPanel r4 = new JPanel();
        r4.setBackground(Color.YELLOW);
        JPanel r5 = new JPanel();
        r5.setBackground(Color.CYAN);
        add(r1);
        add(r2);
        add(r3);
        add(r4);
        add(r5);
        r1.setLayout(new GridLayout(1,1));
        r1.add(jb);
        r2.setLayout(new GridLayout(1,4));
        r2.add(b1);
        r2.add(b2);
        r2.add(b3);
        r2.add(plus);
        r3.setLayout(new GridLayout(1,4));
        r3.add(b4);
        r3.add(b5);
        r3.add(b6);
        r3.add(minus);
        r4.setLayout(new GridLayout(1,4));
        r4.add(b7);
        r4.add(b8);
        r4.add(b9);
        r4.add(divide);
        r5.setLayout(new GridLayout(1,4));
        r5.add(clear);
        r5.add(b0);
        r5.add(equals);
        r5.add(multiply);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        b0.addActionListener(this);
        clear.addActionListener(this);
        equals.addActionListener(this);
        plus.addActionListener(this);
        minus.addActionListener(this);
        divide.addActionListener(this);
        multiply.addActionListener(this);
        
        menuFile.setLabel("File");
        menuFileExit.setLabel("Exit");
        
        // Add action listener.for the menu button
        menuFileExit.addActionListener
        (
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    WidgetDemoFrame.this.windowClosed();
                }
            }
        ); 
        menuFile.add(menuFileExit);
        menuBar.add(menuFile);
        
        setTitle("WidgetDemo");
        setJMenuBar(menuBar);
        setSize(new Dimension(400, 400));
        
        // Add window listener.
        this.addWindowListener
        (
            new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    WidgetDemoFrame.this.windowClosed();
                }
            }
        );  
    }*/
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == button[0])
            display.append("7");
        if(ae.getSource() == button[1])
            display.append("8");
        if(ae.getSource() == button[2])
            display.append("9");
        if(ae.getSource() == button[3]) {
            //add function[0]
            temporary[0] = Double.parseDouble(display.getText());
            function[0] = true;
            display.setText("");
        }
        if(ae.getSource() == button[4])
            display.append("4");
        if(ae.getSource() == button[5])
            display.append("5");
        if(ae.getSource() == button[6])
            display.append("6");
        if(ae.getSource() == button[7]) {
            //subtract function[1]
            temporary[0] = Double.parseDouble(display.getText());
            function[1] = true;
            display.setText("");
        }
        if(ae.getSource() == button[8])
            display.append("1");
        if(ae.getSource() == button[9])
            display.append("2");
        if(ae.getSource() == button[10])
            display.append("3");
        if(ae.getSource() == button[11]) {
            //multiply function[2]
            temporary[0] = Double.parseDouble(display.getText());
            function[2] = true;
            display.setText("");
        }
        if(ae.getSource() == button[12])
            display.append(".");
        if(ae.getSource() == button[13]) {
            //divide function[3]
            temporary[0] = Double.parseDouble(display.getText());
            function[3] = true;
            display.setText("");
        }
        if(ae.getSource() == button[14])
            clear();
        if(ae.getSource() == button[15])
            getResult();
        if(ae.getSource() == button[16])
            display.append("0");
    }

    
 
       public static void main(String[] arguments) {
        WidgetDemoFrame c = new WidgetDemoFrame();
    }

     
    protected void windowClosed() {
    	
    	// TODO: Check if it is safe to close the application
    	
        // Exit application.
        System.exit(0);
    }
    
}
