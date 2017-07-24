// Filename: GUIDice.java
// Author: Brad Marlowe
// Date: 7-12-17
// Purpose: CMIS242 Week 4 Graded Discussion:
// Example of GUI with input text, output text, and a button

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class GUIDice extends JFrame implements ActionListener {

//variables
    private static javax.swing.JRadioButton customBtn;
    private static javax.swing.JRadioButton d10;
    private static javax.swing.JRadioButton d12;
    private static javax.swing.JRadioButton d20;
    private static javax.swing.JRadioButton d4;
    private static javax.swing.JRadioButton d6;
    private static javax.swing.JRadioButton d8;
    private static javax.swing.JPanel ioPanel;
    private static javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JCheckBox modCheckBtn;
    private static javax.swing.JLabel modCheckLbl;
    private static javax.swing.ButtonGroup modGrp;
    private static javax.swing.JLabel modLbl;
    private static javax.swing.JRadioButton modMinusBtn;
    private static javax.swing.JRadioButton modPlusBtn;
    private static javax.swing.JTextField modTxt;
    private static javax.swing.JLabel numDiceLbl;
    private static javax.swing.JTextField numDiceTxt;
    private static javax.swing.JLabel numSidesLbl;
    private static javax.swing.JTextField numSidesTxt;
    private static javax.swing.ButtonGroup quickRollGrp;
    private static javax.swing.JLabel quickRollLbl;
    private static javax.swing.JPanel quickRollPanel;
    private static javax.swing.JLabel resultsLbl;
    private static javax.swing.JPanel resultsPanel;
    private static javax.swing.JTextPane resultsTxt;
    private static javax.swing.JButton rollBtn;
    private static int quickOption = 0;
    private static boolean modCheck = false;
    private static int modType = 0; //Set to 1 for Plus, 2 for Minus

   private void initComponents() {

        quickRollGrp = new javax.swing.ButtonGroup();
        modGrp = new javax.swing.ButtonGroup();
        quickRollPanel = new javax.swing.JPanel();
        d20 = new javax.swing.JRadioButton();
        d12 = new javax.swing.JRadioButton();
        d10 = new javax.swing.JRadioButton();
        d4 = new javax.swing.JRadioButton();
        d8 = new javax.swing.JRadioButton();
        d6 = new javax.swing.JRadioButton();
        quickRollLbl = new javax.swing.JLabel();
        customBtn = new javax.swing.JRadioButton();
        ioPanel = new javax.swing.JPanel();
        numDiceTxt = new javax.swing.JTextField();
        numDiceLbl = new javax.swing.JLabel();
        numSidesLbl = new javax.swing.JLabel();
        numSidesTxt = new javax.swing.JTextField();
        modCheckLbl = new javax.swing.JLabel();
        modCheckBtn = new javax.swing.JCheckBox();
        modTxt = new javax.swing.JTextField();
        modMinusBtn = new javax.swing.JRadioButton();
        modPlusBtn = new javax.swing.JRadioButton();
        modLbl = new javax.swing.JLabel();
        resultsPanel = new javax.swing.JPanel();
        rollBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultsTxt = new javax.swing.JTextPane();
        resultsLbl = new javax.swing.JLabel();
        
        //ButtonListener btnPress = new ButtonListener();
        //rollBtn.addActionListener(btnPress);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(500, 400));

        quickRollPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        quickRollGrp.add(d20);
        d20.setText("1d20");

        quickRollGrp.add(d12);
        d12.setText("1d12");

        quickRollGrp.add(d10);
        d10.setText("1d10");

        quickRollGrp.add(d4);
        d4.setText("1d4");

        quickRollGrp.add(d8);
        d8.setText("1d8");

        quickRollGrp.add(d6);
        d6.setText("1d6");

        quickRollLbl.setText("Quick Rolls:");
        
        quickRollGrp.add(customBtn);
        customBtn.setText("Use Custom:");
        
        d20.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent d20) {
               setQuickBtn(20);
            }
        });
        d12.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent d12) {
               setQuickBtn(12);
            }
        });
        d10.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent d10) {
               setQuickBtn(10);
            }
        });
        d8.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent d8) {
               setQuickBtn(8);
            }
        });
        d6.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent d6) {
               setQuickBtn(6);
            }
        });
        d4.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent d4) {
               setQuickBtn(4);
            }
        });
        customBtn.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent custom) {
               setQuickBtn(0);
            }
        });
        
        modCheckBtn.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent modCheck) {
               if (modCheckBtn.isSelected()) {
                  setModBtn(true);
               }
               else {
                  setModBtn(false);
               }
            }
        });
        modPlusBtn.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent modPlus) {
               setModType(1);
            }
        });
        modMinusBtn.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent modMinus) {
               setModType(2);
            }
        });

        javax.swing.GroupLayout quickRollPanelLayout = new javax.swing.GroupLayout(quickRollPanel);
        quickRollPanel.setLayout(quickRollPanelLayout);
        quickRollPanelLayout.setHorizontalGroup(
            quickRollPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(d20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(d12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(d10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(d8, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
            .addComponent(d6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(d4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(quickRollPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(quickRollLbl)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(quickRollPanelLayout.createSequentialGroup()
                .addComponent(customBtn)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        quickRollPanelLayout.setVerticalGroup(
            quickRollPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, quickRollPanelLayout.createSequentialGroup()
                .addComponent(quickRollLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(customBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(d20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(d12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(d10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(d8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(d6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(d4)
                .addContainerGap())
        );

        ioPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        numDiceTxt.setText("");

        numDiceLbl.setText("Number of dice to roll:");

        numSidesLbl.setText("Number of sides per die:");

        numSidesTxt.setText("");

        modCheckLbl.setText("Use Modifier?");

        modCheckBtn.setText("");

        modTxt.setText("");

        modGrp.add(modMinusBtn);
        modMinusBtn.setText("-");

        modGrp.add(modPlusBtn);
        modPlusBtn.setText("+");

        modLbl.setText("Modifier:");

        javax.swing.GroupLayout ioPanelLayout = new javax.swing.GroupLayout(ioPanel);
        ioPanel.setLayout(ioPanelLayout);
        ioPanelLayout.setHorizontalGroup(
            ioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ioPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ioPanelLayout.createSequentialGroup()
                        .addComponent(numDiceTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(numSidesTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ioPanelLayout.createSequentialGroup()
                        .addGroup(ioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(modCheckLbl)
                            .addComponent(numDiceLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(modCheckBtn)
                        .addGap(18, 18, 18)
                        .addGroup(ioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(modMinusBtn)
                            .addComponent(modPlusBtn))
                        .addGap(18, 18, 18)
                        .addGroup(ioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ioPanelLayout.createSequentialGroup()
                                .addGap(0, 44, Short.MAX_VALUE)
                                .addComponent(numSidesLbl))
                            .addGroup(ioPanelLayout.createSequentialGroup()
                                .addGroup(ioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(modLbl)
                                    .addComponent(modTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        ioPanelLayout.setVerticalGroup(
            ioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ioPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(ioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numDiceLbl)
                    .addComponent(numSidesLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numDiceTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numSidesTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(ioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ioPanelLayout.createSequentialGroup()
                        .addComponent(modLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(modCheckLbl)
                            .addComponent(modCheckBtn)
                            .addComponent(modTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(ioPanelLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(modPlusBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(modMinusBtn)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        resultsPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        rollBtn.setText("Roll");

        resultsTxt.setEditable(false);
        jScrollPane1.setViewportView(resultsTxt);

        resultsLbl.setText("Results:");

        javax.swing.GroupLayout resultsPanelLayout = new javax.swing.GroupLayout(resultsPanel);
        resultsPanel.setLayout(resultsPanelLayout);
        resultsPanelLayout.setHorizontalGroup(
            resultsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(resultsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rollBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(resultsLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        resultsPanelLayout.setVerticalGroup(
            resultsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, resultsPanelLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(resultsLbl)
                .addGap(20, 20, 20))
            .addComponent(rollBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(resultsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(quickRollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ioPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ioPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(quickRollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(resultsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }

   public GUIDice() {
      initComponents();
   }	
   public void display() {
      setVisible(true);
   }
   public static int getNumDiceTxt() {
      return Integer.parseInt(numDiceTxt.getText());
   } 
   public static int getDieNumSidesTxt() {
      return Integer.parseInt(numSidesTxt.getText());
   }
   public static int getModTxt() {
      return Integer.parseInt(modTxt.getText());
   }
   public void setModBtn(boolean input) {
      modCheck = input;
   }
   public static boolean getModBtn() {
      return modCheck;
   }
   public void setModType(int input) {
      modType = input;
   }
   public static int getModType() {
      return modType;
   }
   public static void setResultsTxt(int result) {
      resultsTxt.setText(String.valueOf(result));
   }
   public static String resultsToString(int[] results) {
      String resultsStr = "";
      for(int c=0; c<results.length; c++) {
         resultsStr += String.valueOf(results[c]);
         if(c != (results.length-1)) {
            resultsStr += ", ";
         }
      }
      return resultsStr;
   }
   public static int[] rollDice(int numDice, int numSides) { //Generate random numbers for each die roll and return them as an int array

      int[] results = new int[numDice];
      
      for (int c=0; c<numDice; c++) {
         for (int d=0; d<numSides; d++) {
            Random randomRoll = new Random();
            int currentResult = randomRoll.nextInt(numSides) + 1;
            results[c] = currentResult;
         }
      }
      return results;
   }
   
   public static int[] includeMod(int[] results) {
      for (int c=0; c<results.length; c++) {
         if (modType == 1) {
            results[c] += getModTxt();
         }
         else if (modType == 2) {
            results[c] -= getModTxt();
            if (results[c] < 1) {
               results[c] = 1;
            }
         }
      }
      return results;
   }
   
   @Override
   public void actionPerformed(ActionEvent e) { 

   }
   
   public void setQuickBtn(int input) {
      switch (input) {
         case 20: quickOption = 20;
                  break;
         case 12: quickOption = 12;
                  break;
         case 10: quickOption = 10;
                  break;
         case 8: quickOption = 8;
                  break;
         case 6: quickOption = 6;
                  break;
         case 4: quickOption = 4;
                  break;
         case 0: quickOption = 0;
                  break;
         default: quickOption = 0;
                  break;
      }
   }
   
   public static int getQuickBtn() {
      return quickOption;
   }
   
   public static boolean inputValidCheck(String toCheck) { //Check to make sure inputs are integers
      boolean success = false;
      
      try {
         Integer.parseInt(toCheck);
         success = true;
      }
      catch(NumberFormatException e) {
         JOptionPane.showMessageDialog(null, "Make sure both inputs are numbers.");
      }
      return success;
   }
   
   public static void main(String[] args)  {
      GUIDice diceRoller = new GUIDice();
      diceRoller.display();
      
      rollBtn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            int[] results;
            String resultsStr;
            if(getQuickBtn() != 0) {
               switch (getQuickBtn()) {
                  case 20: results = rollDice(1, 20);
                     break;
                  case 12: results = rollDice(1, 12);
                     break;
                  case 10: results = rollDice(1, 10);
                     break;
                  case 8: results = rollDice(1, 8);
                     break;
                  case 6: results = rollDice(1, 6);
                     break;
                  case 4: results = rollDice(1, 4);
                     break;
                  default: results = new int[0];
                     break;
               }
               if (modCheck) {
                  results = includeMod(results);
               }
               resultsStr = resultsToString(results);
            }
         
            else if(inputValidCheck(numDiceTxt.getText()) &&
                     inputValidCheck(numSidesTxt.getText())) {
               results = rollDice(getNumDiceTxt(), getDieNumSidesTxt());
               if (modCheck) {
                  results = includeMod(results);
               }
               resultsStr = resultsToString(results);
            }
            
            else {
               resultsStr = "Error";
            }
            resultsTxt.setText(resultsStr);
         }
      });
   }

}