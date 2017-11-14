package com;
import com.domain.*;
import com.service.Personnel;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.*;

class Fenetre extends JFrame {
    private JPanel container = new JPanel();
    private JPanel containerAdd = new JPanel();
    private JPanel containerlist = new JPanel();
    private JButton boutonBack = new JButton("Back");
    private JButton boutonValide = new JButton("Valide");
    private JButton add = new JButton("Ajout");
    private JButton list = new JButton("liste");
    private JLabel label1 = new JLabel("Nom :");
    private JTextField nom = new JTextField("", 15);
    private JLabel label2 = new JLabel("Prénom :");
    private JTextField prenom = new JTextField("", 14);
    private JLabel label3 = new JLabel("Age :");
    private JTextField age = new JTextField("", 16);
    private JLabel label4 = new JLabel("Année :");
    private JTextField annee = new JTextField("", 15);
    private JLabel label5 = new JLabel("Productivité :");
    private JTextField produc = new JTextField("", 12);
    private JComboBox<String> boxJob = new JComboBox<>();
    private Table table = new Table();


    public Fenetre(){
        this.setTitle("Ma première fenêtre Java");
        this.setSize(250, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        container.add(add);
        container.add(list);
        this.getContentPane().add(container);
        add.addActionListener(this::actionPerformed);
        list.addActionListener(this::actionPerformedList);
        this.setVisible(true);
    }

    private void actionPerformedList(ActionEvent e) {
        System.out.println("je suis la");
        this.getContentPane().removeAll();
        this.getContentPane().add(containerlist);
        this.setSize(450, 500);
        JTable table1 = new JTable(table);
        containerlist.add(new JScrollPane(table1));
        containerlist.add(boutonBack);
        this.setVisible(true);
        boutonBack.addActionListener(this::actionPerformedBack);
    }

    private void actionPerformed(ActionEvent e) {
        System.out.println("je suis la");
        this.getContentPane().removeAll();
        this.getContentPane().add(containerAdd);
        containerAdd.add(label1);
        containerAdd.add(nom);
        containerAdd.add(label2);
        containerAdd.add(prenom);
        containerAdd.add(label3);
        containerAdd.add(age);
        containerAdd.add(label4);
        containerAdd.add(annee);
        containerAdd.add(label5);
        containerAdd.add(produc);
        boxJob.addItem("Vendeur");
        boxJob.addItem("Vendeur");
        boxJob.addItem("Representant");
        boxJob.addItem("Technicien");
        boxJob.addItem("Manutention");
        boxJob.addItem("TechnARisque");
        boxJob.addItem("ManutARisque");
        containerAdd.add(boxJob);
        containerAdd.add(boutonValide);
        containerAdd.add(boutonBack);
        this.setVisible(true);
        boutonBack.addActionListener(this::actionPerformedBack);
        boutonValide.addActionListener(this::actionPerformedValide);

    }

    private void actionPerformedValide(ActionEvent e) {
        String nom = this.nom.getText();
        String prenom = this.prenom.getText();
        String age1 = this.age.getText();
        int age = Integer.parseInt(age1);
        String annee = this.annee.getText();
        String produc1 = this.produc.getText();
        double produc = Double.parseDouble(produc1);
        int produc2 = Integer.parseInt(produc1);
        String job = boxJob.getSelectedItem().toString();

        System.out.println(job);
        Personnel p = new Personnel();
        switch(job)
        {
            case "Vendeur" : p.ajouterEmploye(new Vendeur(prenom, nom, age, annee, produc)); break;
            case "Representant" : p.ajouterEmploye(new Representant(prenom, nom, age, annee, produc)); break;
            case "Technicien" :  p.ajouterEmploye(new Technicien(prenom, nom, age, annee, produc2)); break;
            case "Manutention" : p.ajouterEmploye(new Manutentionnaire(prenom, nom, age, annee, produc2)); break;
            case "TechnARisque" : p.ajouterEmploye(new TechnARisque(prenom, nom, age, annee, produc2)); break;
            case "ManutARisque" : p.ajouterEmploye(new ManutARisque(prenom, nom, age, annee, produc2)); break;
        }
        this.getContentPane().removeAll();
        this.getContentPane().add(container);
        this.validate();
        this.repaint();
        this.setVisible(true);

    }

    private void actionPerformedBack(ActionEvent e) {
        this.getContentPane().removeAll();
        this.getContentPane().add(container);
        this.setSize(250, 500);
        this.validate();
        this.repaint();
        this.setVisible(true);

    }
}
