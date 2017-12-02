/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toko_bunga;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javax.swing.JOptionPane;

/**
 *
 * @author SMK TELKOM
 */
public class FXMLDocumentController implements Initializable {
           @FXML
    private JFXTextField nama;

    @FXML
    private JFXTextField no_tlp;

    @FXML
    private JFXTextField tgl_pesan;

    @FXML
    private JFXTextField alamat;

    @FXML
    private RadioButton rdBucket;

    @FXML
    private RadioButton rdTangkai;

    @FXML
    private RadioButton rdTulip;

    @FXML
    private RadioButton rdLili;

    @FXML
    private RadioButton rdMatahari;

    @FXML
    private RadioButton rdAnggrek;
    
    @FXML
    private RadioButton rdMawar;

    @FXML
    private Button done;

    @FXML
    private Button reset;

    @FXML
    private Button exit;

    @FXML
    private TextArea tampil;

    @FXML
    private Label label;

    @FXML
    void handleButtonAction(ActionEvent event) {
         String paket = null;
         String jenisBunga = null;
        int harga = 0;
        
        if(rdBucket.isSelected())
        paket = "Buket";
        else if (rdTangkai.isSelected())
        paket = "Tangkai";
        else{
            JOptionPane.showMessageDialog(null, "Harap pilih paket jenis pesanan");
        }
        
        if (rdAnggrek.isSelected())
        jenisBunga = "Bunga Anggrek";
        else if (rdLili.isSelected())
        jenisBunga = "Bunga Lili";
        else if (rdMatahari.isSelected())
        jenisBunga = "Bunga Matahari";
        else if (rdTulip.isSelected())
        jenisBunga = "Bunga Tulip";
        else if (rdMawar.isSelected())
        jenisBunga = "Bunga Mawar";
        
        if(nama.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Harap inputkan Nama");
        }else if(no_tlp.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Harap inputkan No Telpon");
        }else if(tgl_pesan.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Harap inputkan Tanggal Pesanan");
        }else if(alamat.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Harap inputkan Alamat");
        }else if(!(rdTulip.isSelected() || rdAnggrek.isSelected() || rdLili.isSelected() || rdMatahari.isSelected() 
                || rdMawar.isSelected())){
            JOptionPane.showMessageDialog(null, "Harap pilih Bunga");
        }else{
        String name = nama.getText();
        String telpon = no_tlp.getText();
        String tgl = tgl_pesan.getText();
        String alamate = alamat.getText();
        
        tampil.setText("Nama : " +name+"\n"+"Telpon : " +telpon+"\n"+"Tanggal Pesanan : " +tgl+"\n"+"Alamat : "+ 
                alamate+"\n"+"Jenis Paket  : "+paket+"\n"+"Jenis Bunga  : "+jenisBunga);
        
    }
    }

    @FXML
    void handleButtonActionExit(ActionEvent event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    void handleButtonActionReset(ActionEvent event) {     
        nama.setText("");
        no_tlp.setText("");
        tgl_pesan.setText("");
        alamat.setText("");
        rdBucket.setSelected(false);
        rdTangkai.setSelected(false);
        rdLili.setSelected(false);
        rdTulip.setSelected(false);
        rdAnggrek.setSelected(false);
        rdMatahari.setSelected(false);
        rdMawar.setSelected(false);
        tampil.setText("");
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
