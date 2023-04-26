package com.feuji.ecommerce.entity;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class PaymentProcessor implements Runnable, ActionListener {
   private Random random;
   private JLabel statusLabel;
   private JFrame frame;
   private JButton paymentButton;
   
   public PaymentProcessor() {
      random = new Random();
      createUI();
   }
   
   private void createUI() {
      statusLabel = new JLabel("Click 'Process Payment' to start");
      paymentButton = new JButton("Process Payment");
      paymentButton.addActionListener(this);
      
      JPanel panel = new JPanel();
      panel.add(paymentButton);
      
      frame = new JFrame("Payment Processor");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.add(statusLabel, BorderLayout.CENTER);
      frame.add(panel, BorderLayout.SOUTH);
      frame.pack();
      frame.setVisible(true);
   }
   
   public void actionPerformed(ActionEvent e) {
      paymentButton.setEnabled(false);
      Thread thread = new Thread(this);
      thread.start();
   }
   
   public void run() {
      int var = random.nextInt(10);
      if(var == 9 || var == 6) {
         updateStatusLabel("Payment Cancelled");
      } else if(var == 2 || var == 5) {
         updateStatusLabel("Payment is in progress");
         // Wait for 2 seconds before processing the payment
         try {
            Thread.sleep(2000);
         } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
         }
         // Generate a new random number
         var = random.nextInt(10);
         if(var == 9 || var == 6) {
            updateStatusLabel("Payment Cancelled");
         } else {
            updateStatusLabel("Payment Successful");
         }
      } else {
         updateStatusLabel("Payment Successful");
      }
      paymentButton.setEnabled(true);
   }
   
   private void updateStatusLabel(final String text) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            statusLabel.setText(text);
         }
      });
   }
   
//   public static void main(String[] args) {
//      PaymentProcessor processor = new PaymentProcessor();
//   }
}

