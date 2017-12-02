/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toko_bunga;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.awt.HeadlessException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author SMK TELKOM
 */
public class LoginController implements Initializable {
     
    @FXML
    private JFXTextField username;

    @FXML
    private JFXTextField pass;

    @FXML
    private Button btnlogin;
    public String user="neisya";
    public String password="1234";
    @FXML
    private JFXButton signup;

   @FXML
    void handleButtonAction(ActionEvent event) throws IOException {
         Connection con;
        Statement stat;
        ResultSet rs;
        String sql;

        Koneksi DB = new Koneksi();
        DB.config();
        con = DB.con;
        stat = (Statement) DB.stm;
        
        
        if(username.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Tuliskan Username Anda");
        }
        else if(pass.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Tuliskan Password Anda");
        }
        else{
        try {
            sql = "SELECT * FROM tb_akun WHERE username='"+username.getText()+"' AND password='"+pass.getText()+"'";
            rs = stat.executeQuery(sql);
            if(rs.next()){
                if(username.getText().equals(rs.getString("username")) && pass.getText().equals(rs.getString("password"))){
                    JOptionPane.showMessageDialog(null, "Berhasil Login");
                    // Hide this current window (if this is what you want)
                    ((Node)(event.getSource())).getScene().getWindow().hide();

                    // Load the new fxml
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("FXMLDocument.fxml"));
                    Scene scene = new Scene(fxmlLoader.load());

                    // Create new stage (window), then set the new Scene
                    Stage stage = new Stage();
                    stage.setResizable(false);
                    stage.setScene(scene);
                    stage.setTitle("Toko Bunga");
                    stage.show();
                }
            }else{
                    JOptionPane.showMessageDialog(null, "Username Atau Password Salah");
                }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void SignUp(ActionEvent event) throws IOException {
         FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("SignUp.fxml"));
                    Scene scene = new Scene(fxmlLoader.load());

                    // Create new stage (window), then set the new Scene
                    ((Node)(event.getSource())).getScene().getWindow().hide();
                    Stage stage = new Stage();
                    stage.setResizable(false);
                    stage.setScene(scene);
                    stage.setTitle("Toko Bunga");
                    stage.show();
    }

   
    }
    

