import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements Runnable, ActionListener{

  // Class Variables  
  JPanel mainPanel;

  JLabel counterLabel;

  JTextField countDownInput;

  JButton countDownButton;
  JButton resetButton;

  Font biggerText;

  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Title");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);
 
    // initialize the main panal
    mainPanel = new JPanel();

    // disable any layout helpers
    mainPanel.setLayout(null);

    // create the left side counterLabel
    counterLabel = new JLabel("Counter");

    // layout the counterLabel by setting the coordinate and setsize 
    counterLabel.setBounds(50, 100, 150, 70);

    // add the label to the main mainPanel
    mainPanel.add(counterLabel);

    // initialize the countDownInput
    countDownInput = new JTextField("10");

    // make the text box uneditable
    countDownInput.setEnabled(false);

    // layout the counterLabel by setting the coordinate and setsize
    countDownInput.setBounds(220, 90, 350, 90);

    // add the text field to the mainPanel
    mainPanel.add(countDownInput);

    // initialize the buttons
    countDownButton = new JButton("Count Down");
    resetButton = new JButton("Reset");

    // layout the counterLabel by setting the coordinate and setsize
    countDownButton.setBounds(50, 270, 245, 50);
    resetButton.setBounds(325, 270, 245, 50);

    // add an action listener to the buttons
    countDownButton.addActionListener(this);
    resetButton.addActionListener(this);

    // set the action command on the buttons
    countDownButton.setActionCommand("Count Down");
    resetButton.setActionCommand("Reset");

    // add the buttons to the main panel 
    mainPanel.add(countDownButton);
    mainPanel.add(resetButton);

    // create a bigger font to use
    biggerText = new Font("arial",Font. PLAIN, 25);

    // set the font on the areas I want to use it
    counterLabel.setFont(biggerText);
    countDownInput.setFont(biggerText);
    countDownButton.setFont(biggerText);
    resetButton.setFont(biggerText);

    // add the panel to the window
    frame.add(mainPanel);    
  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();

    // if the user presses the count down button
    if (command.equals("Count Down")){

      // get the text from the text box
      String countDownText = countDownInput.getText();

      // change the string into an integer
      int countDown = Integer.parseInt(countDownText);

      if (countDown > 0){
        // calculate the new number
        int number = countDown - 1;

        // output the value to the text box
        countDownInput.setText("" + number);
      }
     
    // if the user presses the reset button
    }else if(command.equals("Reset")){

      // set the countDownInput variable to 10
      countDownInput.setText("10");
    }
  }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}
