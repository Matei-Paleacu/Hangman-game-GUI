import java.util.*;  
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

import javax.swing.*;
import java.awt.*;
import javax.swing.ImageIcon;

public class hangman {
    public ArrayList<String> words =new ArrayList<String>();
    public ArrayList<String> guesses =new ArrayList<String>();
    public ArrayList<String> making_word_1 =new ArrayList<String>();
    public String guesses_string;
    public String word;
    public String current_guess_word;
    public boolean correct_puzzel;
    public boolean correct_guess;
    public boolean flag = false;
    public int wrong_guesses;

    public void food_category(){
        try {
            File myObj = new File("food.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
              String data = myReader.nextLine();
              words.add(data);
            }
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
//          for(int i =0; i<words.size();i++){
//              System.out.println(words.get(i));
//          }
          double double_Rand_Num = Math.random()*words.size();
          int random_number = (int)double_Rand_Num;
          word = words.get(random_number);
//          System.out.println(word+ " random word");
    }

    public void sports_category(){
        try {
            File myObj = new File("sports.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
              String data = myReader.nextLine();
              words.add(data);
            }
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
//          for(int i =0; i<words.size();i++){
//              System.out.println(words.get(i));
//          }
          double double_Rand_Num = Math.random()*words.size();
          int random_number = (int)double_Rand_Num;
          word = words.get(random_number);
//          System.out.println(word+ " random word");
    }

    public void pets_category(){
        try {
            File myObj = new File("pets.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
              String data = myReader.nextLine();
              words.add(data);
            }
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
//          for(int i =0; i<words.size();i++){
//              System.out.println(words.get(i));
//          }
          double double_Rand_Num = Math.random()*words.size();
          int random_number = (int)double_Rand_Num;
          word = words.get(random_number);
//         System.out.println(word+ " random word");
    }

    public void check_input(String user_input){
//      making_word = new char[word.length()];
      if(flag == false){
        for(int i = 0; i<word.length();i++){
          making_word_1.add("_");
         }
        flag = true;
      }
      if(wrong_guesses < 6){
        if(user_input.length() > 1){
          if(word.equals(user_input)){
            correct_puzzel = true;
          }else{
            guesses.add(user_input);
            wrong_guesses++;
            correct_guess = false;

          }
        }else{
          guesses.add(user_input);
          if(word.contains(user_input)){
            for(int i = 0;i<word.length();i++){
              if(word.charAt(i) == user_input.charAt(0)){
                making_word_1.set(i,user_input);
                correct_guess = true;
                if(word.charAt(i) == word.charAt(word.length()-1)){
                  correct_puzzel = true;
                }
              }
            }
          }else{
            wrong_guesses++;
            correct_guess = false;

          }
        }
      }else{
        correct_puzzel = false;
      }
    }

    public void GUI(){
      JFrame frame_1 = new JFrame("Home Page");
      JFrame frame_2 = new JFrame("Game");
      frame_2.setVisible(false);
      frame_1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame_1.setSize(400, 400);
             //Creating the panel at bottom and adding components
             JPanel panel_1 = new JPanel();  
             JButton Cat_1 = new JButton("Food");
             JButton Cat_2 = new JButton("Sports");
             JButton Cat_3 = new JButton("Pets");
             JTextArea welcome = new JTextArea(5,30);
 
             welcome.append("Welcome to Matei's Hangman Game" + "\n");
             welcome.append("This game was coded in Java v.11.0.9" + "\n");
             welcome.append("After selecting a topic make sure to fullscreen the GUI" + "\n");

             panel_1.add(Cat_1);                                                                                                    // Components Added using Flow Layout
             panel_1.add(Cat_2);
             panel_1.add(Cat_3);
             panel_1.add(welcome);
             frame_1.getContentPane().add(BorderLayout.SOUTH, panel_1);
             frame_1.setVisible(true);

            hangman caller = new hangman();
            JPanel panel_2 = new JPanel();

            
            Cat_1.addActionListener(e -> {
            caller.food_category();
            frame_1.setVisible(false);
            frame_2.setVisible(true);
            frame_2.add(panel_2);


            JTextArea game_info = new JTextArea(5,20);
            game_info.append("In the category of Food" + "\n");
            game_info.append("You're word is " + caller.word.length() + " letters long \n");
            game_info.setEditable(false);
            panel_2.add(game_info);


            JOptionPane.showMessageDialog(null, "You have " + (6 - caller.guesses.size()) + " guesses left");

            });
            Cat_2.addActionListener(e -> {
            caller.sports_category();
            frame_1.setVisible(false);
            frame_2.setVisible(true);
            frame_2.add(panel_2);

            JTextArea game_info = new JTextArea(5,20);
            game_info.append("In the category of Sports" + "\n");
            game_info.append("You're word is " + caller.word.length() + " letters long");
            game_info.setEditable(false);
            panel_2.add(game_info);


            JOptionPane.showMessageDialog(null, "You have " + (6 - caller.guesses.size()) + " guesses left");

            });
            Cat_3.addActionListener(e -> {
            caller.pets_category();
            frame_1.setVisible(false);
            frame_2.setVisible(true);
            frame_2.add(panel_2);

 
            JTextArea game_info = new JTextArea(5,20);
            game_info.append("In the category of Pets" + "\n");
            game_info.append("You're word is " + caller.word.length() + " letters long \n");
            game_info.setEditable(false);
            panel_2.add(game_info);
            

            JOptionPane.showMessageDialog(null, "You have " + (6 - caller.guesses.size()) + " guesses left");
            });

      

          
      frame_2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame_2.setSize(400, 400);
             //Creating the panel at bottom and adding components
             JPanel panel_3 = new JPanel();                                                                                         // the panel is not visible in output
             JLabel label = new JLabel("Enter Guess");
             JTextField tf = new JTextField(10);                                                                                  // accepts up to 10 characters
             JButton send = new JButton("Send");
             JTextArea info = new JTextArea(5,20);
             JLabel label_image = new JLabel();
             ImageIcon hang_1 = new ImageIcon("H1.png");
             ImageIcon hang_2 = new ImageIcon("H2.png");
             ImageIcon hang_3 = new ImageIcon("H3.png");
             ImageIcon hang_4 = new ImageIcon("H4.png");
             ImageIcon hang_5 = new ImageIcon("H5.png");
             ImageIcon hang_6 = new ImageIcon("H6.png");
             ImageIcon hang_7 = new ImageIcon("H7.png");



             label_image.setIcon(hang_1);
             panel_3.add(label);                                                                                                    // Components Added using Flow Layout
             panel_3.add(tf);
             panel_3.add(send);
             panel_3.add(info);
             panel_3.add(label_image);

             frame_2.getContentPane().add(BorderLayout.SOUTH, panel_3);
              send.addActionListener(e -> {
                StringBuffer sb_1 = new StringBuffer();
                System.out.println(caller.guesses);
                String guess_for_user = tf.getText();
                Boolean invalid_input = false;
              for(int i =0; i<caller.guesses.size();i++){
                if(guess_for_user.equals(caller.guesses.get(i))){
                  invalid_input = true;
                  break;
                  }
                }
              if(invalid_input == true){
                JOptionPane.showMessageDialog(null, "You have already guessed that");
                }else{
                  info.setText(null); 
                  caller.check_input(guess_for_user);
                  info.append("You're previous guesses: " + caller.guesses);
                  if(caller.correct_puzzel == false && caller.wrong_guesses > 5){
                    frame_2.setVisible(false);
                    JOptionPane.showMessageDialog(null, "You Lost");
                  }else{
                    if(caller.correct_puzzel == true){
                      frame_2.setVisible(false);
                      JOptionPane.showMessageDialog(null, "YOU WIN!!");
                    }else{
                      if(caller.correct_guess == true){
                        JOptionPane.showMessageDialog(null, "You're guess was correct");
                      }else{
                        JOptionPane.showMessageDialog(null, "You're guess was wrong");
                      }
                      System.out.println(guess_for_user + "input");      
                      JOptionPane.showMessageDialog(null, "You have " + (6 - caller.wrong_guesses) + " guesses left");
                      for(int k =0; k<caller.making_word_1.size();k++){
                          sb_1.append(caller.making_word_1.get(k) + " ");
                      }
                      caller.current_guess_word = sb_1.toString();
                      JOptionPane.showMessageDialog(null, "You're current word is: " + caller.current_guess_word);
                      System.out.println(caller.wrong_guesses + "wrong");
                      if(caller.wrong_guesses == 1){
                        label_image.setIcon(hang_2);
                        panel_3.add(label_image);
                        frame_2.getContentPane().add(BorderLayout.SOUTH, panel_3);
                      }
                      if(caller.wrong_guesses == 2){
                        label_image.setIcon(hang_3);
                        panel_3.add(label_image);
                        frame_2.getContentPane().add(BorderLayout.SOUTH, panel_3);
                      }
                      if(caller.wrong_guesses == 3){
                        label_image.setIcon(hang_4);
                        panel_3.add(label_image);
                        frame_2.getContentPane().add(BorderLayout.SOUTH, panel_3);
                      }
                      if(caller.wrong_guesses == 4){
                        label_image.setIcon(hang_5);
                        panel_3.add(label_image);
                        frame_2.getContentPane().add(BorderLayout.SOUTH, panel_3);
                      }
                      if(caller.wrong_guesses == 5){
                        label_image.setIcon(hang_6);
                        panel_3.add(label_image);
                        frame_2.getContentPane().add(BorderLayout.SOUTH, panel_3);
                      }
                      if(caller.wrong_guesses == 6){
                        label_image.setIcon(hang_7);
                        panel_3.add(label_image);
                        frame_2.getContentPane().add(BorderLayout.SOUTH, panel_3);
                      }
                    }    
                  }
                }
              });            
    }
    public static void main(String[] args) {
        hangman caller = new hangman();
        caller.GUI();

        /*
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the category you would like to select from: Food,Sports,or Pets");
        String input = sc.nextLine();
      
        while(correct_input == false){
            if(input.toLowerCase().equals("food") || input.toLowerCase().equals("sports") || input.toLowerCase().equals("pets")){
                correct_input = true;
            }else{
                System.out.println("Enter the category you would like to select from: Food,Sports,or Pets");
                input = sc.nextLine();

            }
        }
        hangman caller = new hangman();
        if(input.toLowerCase().equals("food")){
            caller.food_category();
        }
        if(input.toLowerCase().equals("sports")){
            caller.sports_category();
        }
        if(input.toLowerCase().equals("pets")){
            caller.pets_category();
        }
        

        System.out.println("You're word is " + caller.word.length() + " letters long");
        System.out.println(" ");
        System.out.println("In the category of " + input);
        System.out.println(" ");
        System.out.println("You have " + (6 - caller.guesses.size()) + " guesses left");
        System.out.println(" ");
        System.out.println("Enter you're guess");
        String guess = sc.nextLine();
        char[] making_word = new char[caller.word.length()];
        for(int i = 0; i<making_word.length;i++){
          making_word[i] = '_';
        }
        while(caller.correct_puzzel == false){
          if(caller.guesses.size() < 5){
            caller.check_input(guess, making_word);
            System.out.println(" ");
            System.out.println("/ / / / / / / / / / / / / / / / / / / / / / /");
            System.out.println(" ");
            if(caller.correct_guess == false){
              System.out.println("Your guess was wrong");
            }else{
              System.out.println("Your guess was correct");
            }
            StringBuffer sb = new StringBuffer();
            for(int i =0; i<making_word.length;i++){
              sb.append(making_word[i]);
            }
            caller.current_guess_word = sb.toString();
            if(caller.current_guess_word.equals(caller.word)){
              caller.correct_puzzel = true;
            }
            System.out.println(caller.current_guess_word);
            if(caller.correct_puzzel == true){
              break;
            }
            caller.correct_guess = true;
            System.out.println(" ");
            System.out.println("previous gueses" + caller.guesses);
            System.out.println(" ");
            System.out.println("You have " + (6 - caller.guesses.size()) + " guesses left");
            System.out.println(" ");
            System.out.println("Enter you're guess");
            guess = sc.nextLine();
            for(int i =0; i<caller.guesses.size();i++){
              sb.append(caller.guesses.get(i));
            }
            caller.guesses_string = sb.toString();
            if(guess.length() < 2){
              while(caller.guesses_string.contains(guess)){
                System.out.println("You have already guessed, enter in a new value");
                System.out.println("Enter you're guess");
                guess = sc.nextLine();
              }
            }
          }else{
            break;
          }
        }
        if(caller.correct_puzzel == true){
          System.out.println("Congrats you win!!");
        }else{
          System.out.println("Unlucky, you didnt get it");
        }
        sc.close();
*/
  
    }
}
