/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import modele.Client;
import modele.Compte;
import modele.CompteCheque;
import modele.CompteEpargne;
import services.CompteServiceBD;
import services.CompteServiceListe;
import services.ICompte;

/**
 * FXML Controller class
 *
 * @author Madoo Ndiaye
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private ComboBox<String> cboType;
    @FXML
    private TextField txtTaux;
    @FXML
    private TextField txtNumero;
    @FXML
    private TextField txtPrenom;
    @FXML
    private TextField txtNom;
    @FXML
    private Button btnSearchClient;
    
    private ICompte service;
    @FXML
    private TableView<Compte> tblvCompte;
    @FXML
    private TableColumn<Compte, String> tblcNumero;
    @FXML
    private TableColumn<Compte, Date> tblcDate;
    @FXML
    private TableColumn<Compte, String> tblcSolde;
    @FXML
    private TableColumn<Compte, String> tblcType;
    @FXML
    private TableColumn<Compte, Client> tblcClient;
    
    ObservableList<Compte> obComptes;
    @FXML
    private TextField txtSolde;
    @FXML
    private Button btnCreerCompte;
    
    private Client cl;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cboType.getItems().add("Chèque");
        cboType.getItems().add("Epargne");
        
        service=new CompteServiceBD();
         ArrayList<Compte>comptes= service.listerCompte();
        obComptes= FXCollections.observableArrayList(comptes);
        tblcNumero.setCellValueFactory(new  PropertyValueFactory<>("numero"));
        tblcDate.setCellValueFactory(new  PropertyValueFactory<>("createAt"));
        tblcSolde.setCellValueFactory(new  PropertyValueFactory<>("solde"));
        tblcType.setCellValueFactory(new  PropertyValueFactory<>("type"));
        tblcClient.setCellValueFactory(new  PropertyValueFactory<>("client"));
        tblvCompte.setItems(obComptes);
    }    

    @FXML
    private void handleActiveTaux(ActionEvent event) {
        System.out.println("test");
       String selected= cboType.getSelectionModel().getSelectedItem();
       txtTaux.setDisable(true);
       if(selected.compareTo("Epargne")==0){
           txtTaux.setDisable(false);
     
       }
    }

    @FXML
    private void handleSearchClientByNum(ActionEvent event) {
        
        String numero= txtNumero.getText();
        cl= service.rechercherClient(numero);
        if (cl!=null){
        txtNom.setText(cl.getNom());
        txtPrenom.setText(cl.getPrenom());
    } else{
            txtNom.setText("");
            txtPrenom.setText("");
        }
    
    }

    @FXML
    private void handleCreerCompte(ActionEvent event) {
        if (cl==null){
            cl= new Client();
            cl.setNumero(txtNumero.getText());
            cl.setNom(txtNom.getText());
            cl.setPrenom(txtPrenom.getText());
        } 
        Compte cp = null;
         String selected= cboType.getSelectionModel().getSelectedItem();
         
         
       // cp.setSolde(Double.parseDouble(txtSolde.getText());
           if(selected.compareTo("Epargne")==0){
           cp= new CompteEpargne();
         ((CompteEpargne)cp).setTaux(Integer.parseInt(txtTaux.getText()));
         ((CompteEpargne)cp).setDateDeblocage(new Date());
       }    else{
               cp= new CompteCheque();
           }
           cp.setSolde(Double.parseDouble(txtSolde.getText()));        
           cp.setCreateAt(new Date());
           cp.setClient(cl);
           service.creerCompte(cp);
           Alert alert=new Alert(Alert.AlertType.INFORMATION);
           alert.setContentText("Compte Enregisté avec succees");
           alert.showAndWait();
           obComptes.add(cp);
    }
}
