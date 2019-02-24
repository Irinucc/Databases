package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    /**
     * Variabile utilizate pentru interfata grafica
     */
    @FXML private TableView<Categorii> tabCategorie;
    @FXML private TableColumn<Categorii, String> idCategorii, numeCategorie, durataPreparare;
    @FXML private TextField numeCategorieField, durataPreparareField;
    @FXML private Text mesajEroare;

    @FXML private TableView<AdreseLivrare> tabAdresa;
    @FXML private TableColumn <AdreseLivrare, String> idAdreseLivrare, strada, numar, bloc, scara, etaj, apartament;
    @FXML private TextField stradaField, numarField, blocField, scaraField, etajField, apartamentField;

    @FXML private TableView<Query1> tabQuery1;
    @FXML private TableColumn<Query1, String> numeQuery1, prenumeQuery1, timpLivrareQuery1;
    @FXML private TextField timpLivrareQuery1Field;

    @FXML private TableView<Query2> tabQuery2;
    @FXML private TableColumn<Query2, String> numeProdusQuery2, numeCategorieQuery2;
    @FXML private ComboBox<String> listaQuery2;

    @FXML private TableView<Query3> tabQuery3;
    @FXML private TableColumn<Query3, String> numeQuery3, prenumeQuery3, stradaQuery3;
    @FXML private ComboBox<String> listaQuery3;

    @FXML private TableView<Query4> tabQuery4;
    @FXML private TableColumn<Query4, String> numeProdusQuery4, numeCategorieQuery4, durataPreparareQuery4;
    @FXML private TextField durataPreparareQuery4Field;

    @FXML private TableView<Query5> tabQuery5;
    @FXML private TableColumn<Query5, String> statusQuery5, numeQuery5, prenumeQuery5;
    @FXML private ComboBox<String> listaQuery5;

    @FXML private TableView<Query6> tabQuery6;
    @FXML private TableColumn<Query6, String> prenumeQuery6, emailQuery6, stradaQuery6, numarQuery6;
    @FXML private ComboBox<String> listaQuery6;

    @FXML private TableView<Complex1> tabComplex1;
    @FXML private TableColumn<Complex1, String> numeProdusComplex1, numeCategorieComplex1, pretComplex1;

    @FXML private TableView<Complex2> tabComplex2;
    @FXML private TableColumn<Complex2, String> numeCategorieComplex2, numarProduseComplex2;

    @FXML private TableView<Complex3> tabComplex3;
    @FXML private TableColumn<Complex3, String> numeComplex3, prenumeComplex3, telefonComplex3, emailComplex3;

    @FXML private TableView<Complex4> tabComplex4;
    @FXML private TableColumn<Complex4, String> numeProdusComplex4, numeCategorieComplex4;
    @FXML private ComboBox<String> listaComplex4;

    private MySql mySql = MySql.getMySql();

    private int i = 0, j = 0;

    /*
    Functiile de Afisare, INSERT, UPDATE si DELETE pentru tabela categorii
     */
    public void afisareCategorie() {
        ObservableList<Categorii> listaCategorie = FXCollections.observableArrayList();
        idCategorii.setCellValueFactory(new PropertyValueFactory<Categorii, String>("idCategorii"));
        numeCategorie.setCellValueFactory(new PropertyValueFactory<Categorii, String>("numeCategorie"));
        durataPreparare.setCellValueFactory(new PropertyValueFactory<Categorii, String>("durataPreparare"));
        try {
            mySql.query = "SELECT * FROM catering.categorii";
            mySql.statement = mySql.connection.createStatement();
            mySql.resultSet = mySql.statement.executeQuery(mySql.query);
            while (mySql.resultSet.next()) {
                listaCategorie.add(new Categorii(mySql.resultSet.getString("idCategorii"), mySql.resultSet.getString("numeCategorie"), mySql.resultSet.getString("durataPreparare")));
                i = Integer.parseInt(mySql.resultSet.getString("idCategorii"));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        tabCategorie.getItems().clear();
        tabCategorie.getItems().addAll(listaCategorie);
        modificaListaQuerys("numeCategorie", "categorii", listaQuery2);
    }

    public void insereazaCategorie() {
        String numeCategorieAux = numeCategorieField.getText();
        String durataPreparareAux = durataPreparareField.getText();
        try {
            mySql.query = "SELECT * FROM catering.categorii";
            mySql.statement = mySql.connection.createStatement();
            mySql.resultSet = mySql.statement.executeQuery(mySql.query);
            while (mySql.resultSet.next()) {
                if(numeCategorieAux.equals(mySql.resultSet.getString("numeCategorie")) && durataPreparareAux.equals(mySql.resultSet.getString("durataPreparare"))) {
                    mesajEroare.setText("Inserare duplicata");
                    return;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        String query = "INSERT INTO catering.`categorii`(idCategorii, numeCategorie, durataPreparare) VALUES ('" + (++i) + "', '" + numeCategorieAux + "', '" + durataPreparareAux + "');";
        i = 0;
        try {
            mySql.insereaza(query);
        } catch (Exception e) {
            e.printStackTrace();
            mesajEroare.setText("Inserare invalida");
        }
        afisareCategorie();
    }

    public void modificaCategorie() {
        String numeCategorieAux = numeCategorieField.getText();
        String durataPreparareAux = durataPreparareField.getText();
        String idAux = tabCategorie.getSelectionModel().getSelectedItem().getIdCategorii();
        String query = "UPDATE catering.`categorii` SET `idCategorii`='"+ idAux +"', `numeCategorie`='"+ numeCategorieAux +"', `durataPreparare`='"+ durataPreparareAux +"' WHERE `idCategorii`='"+ idAux +"';";
        try {
            mySql.insereaza(query);
        } catch (Exception e) {
            e.printStackTrace();
            mesajEroare.setText("Eroare de modificare");
        }
        afisareCategorie();
    }

    public void stergeCategorie() {
        String idAux = tabCategorie.getSelectionModel().getSelectedItem().getIdCategorii();
        String query = "DELETE FROM catering.`categorii` WHERE `idCategorii`='" + idAux + "';";
        try {
            mySql.insereaza(query);
        } catch (Exception e) {
            e.printStackTrace();
            mesajEroare.setText("Eroare de stergere");
        }
        afisareCategorie();
    }

    /*
    Functiile de Afisare, INSERT, UPDATE si DELETE pentru tabela adreselivrare
    */
    public void afisareAdresa() {
        ObservableList<AdreseLivrare> listaAdrese = FXCollections.observableArrayList();
        idAdreseLivrare.setCellValueFactory(new PropertyValueFactory<AdreseLivrare, String>("idAdreseLivrare"));
        strada.setCellValueFactory(new PropertyValueFactory<AdreseLivrare, String>("strada"));
        numar.setCellValueFactory(new PropertyValueFactory<AdreseLivrare, String>("numar"));
        bloc.setCellValueFactory(new PropertyValueFactory<AdreseLivrare, String>("bloc"));
        scara.setCellValueFactory(new PropertyValueFactory<AdreseLivrare, String>("scara"));
        etaj.setCellValueFactory(new PropertyValueFactory<AdreseLivrare, String>("etaj"));
        apartament.setCellValueFactory(new PropertyValueFactory<AdreseLivrare, String>("apartament"));
        try {
            mySql.query = "SELECT * FROM catering.adreselivrare; ";
            mySql.statement = mySql.connection.createStatement();
            mySql.resultSet = mySql.statement.executeQuery(mySql.query);
            while (mySql.resultSet.next()) {
                listaAdrese.add(new AdreseLivrare(mySql.resultSet.getString("idAdreseLivrare"), mySql.resultSet.getString("strada"), mySql.resultSet.getString("numar"), mySql.resultSet.getString("bloc"), mySql.resultSet.getString("scara"), mySql.resultSet.getString("etaj"), mySql.resultSet.getString("apartament")));
                j = Integer.parseInt(mySql.resultSet.getString("idAdreseLivrare"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        tabAdresa.getItems().clear();
        tabAdresa.getItems().addAll(listaAdrese);
        modificaListaQuerys("strada", "adreselivrare", listaQuery3);
    }

    public void insereazaAdresa() {
        String stradaAux = stradaField.getText();
        String numarAux = numarField.getText();
        String blocAux = blocField.getText();
        String scaraAux = scaraField.getText();
        String etajAux = etajField.getText();
        String apartamentAux = apartamentField.getText();
        try {
            mySql.query = "SELECT * FROM catering.adreselivrare";
            mySql.statement = mySql.connection.createStatement();
            mySql.resultSet = mySql.statement.executeQuery(mySql.query);
            while (mySql.resultSet.next()) {
                if(stradaAux.equals(mySql.resultSet.getString("strada")) && numarAux.equals(mySql.resultSet.getString("numar")) && blocAux.equals(mySql.resultSet.getString("bloc")) && scaraAux.equals(mySql.resultSet.getString("scara")) && etajAux.equals(mySql.resultSet.getString("etaj")) && apartamentAux.equals(mySql.resultSet.getString("apartament"))) {
                    mesajEroare.setText("Inserare duplicata");
                    return;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        String query = "INSERT INTO catering.`adreselivrare`(idAdreseLivrare, strada, numar, bloc, scara, etaj, apartament) VALUES ('" + (++j) + "', '" + stradaAux + "', '" + numarAux + "', '" + blocAux + "', '" + scaraAux + "', '" + etajAux + "', '" + apartamentAux + "');";
        j = 0;
        try {
            mySql.insereaza(query);
        } catch (Exception e) {
            e.printStackTrace();
            mesajEroare.setText("Inserare invalida");
        }
        afisareAdresa();
    }

    public void modificaAdresa() {
        String stradaAux = stradaField.getText();
        String numarAux = numarField.getText();
        String blocAux = blocField.getText();
        String scaraAux = scaraField.getText();
        String etajAux = etajField.getText();
        String apartamentAux = apartamentField.getText();
        String idAux = tabAdresa.getSelectionModel().getSelectedItem().getIdAdreseLivrare();
        String query = "UPDATE catering.`adreselivrare` SET `idAdreseLivrare`='"+ idAux +"', `strada`='"+ stradaAux +"', `numar`='"+ numarAux +"' , `bloc`='"+ blocAux +"', `scara`='"+ scaraAux +"', `etaj`='"+ etajAux +"', `apartament`='"+ apartamentAux +"' WHERE `idAdreseLivrare`='"+ idAux +"';";
        try {
            mySql.insereaza(query);
        } catch (Exception e) {
            e.printStackTrace();
            mesajEroare.setText("Eroare de modificare");
        }
        afisareAdresa();
    }

    public void stergeAdresa() {
        String idAux = tabAdresa.getSelectionModel().getSelectedItem().getIdAdreseLivrare();
        String query = "DELETE FROM catering.`adreselivrare` WHERE `idAdreseLivrare`='" + idAux + "';";
        try {
            mySql.insereaza(query);
        } catch (Exception e) {
            e.printStackTrace();
            mesajEroare.setText("Eroare de stergere");
        }
        afisareAdresa();
    }

    /*
    Functiile de afisare al interogarilor simple
     */
    public void afisareQuery1() {
        ObservableList<Query1> lista = FXCollections.observableArrayList();
        numeQuery1.setCellValueFactory(new PropertyValueFactory<Query1, String>("nume"));
        prenumeQuery1.setCellValueFactory(new PropertyValueFactory<Query1, String>("prenume"));
        timpLivrareQuery1.setCellValueFactory(new PropertyValueFactory<Query1, String>("timpLivrare"));
        String timpLivrareAux = timpLivrareQuery1Field.getText();
        try {
            mySql.query = "SELECT nume, prenume, timpLivrare FROM clienti, comenzi WHERE Clienti_idClient = idClient AND (timpLivrare > " + timpLivrareAux + ");";
            mySql.statement = mySql.connection.createStatement();
            mySql.resultSet = mySql.statement.executeQuery(mySql.query);
            while (mySql.resultSet.next()) {
                lista.add(new Query1(mySql.resultSet.getString("nume"), mySql.resultSet.getString("prenume"), mySql.resultSet.getString("timpLivrare")));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        tabQuery1.getItems().clear();
        tabQuery1.getItems().addAll(lista);
    }

    public void afisareQuery2() {
        ObservableList<Query2> lista = FXCollections.observableArrayList();
        numeProdusQuery2.setCellValueFactory(new PropertyValueFactory<Query2, String>("numeProdus"));
        numeCategorieQuery2.setCellValueFactory(new PropertyValueFactory<Query2, String>("numeCategorie"));
        String numeCategorieAux = listaQuery2.getValue();
        try {
            mySql.query = "SELECT numeProdus, numeCategorie FROM produse, categorii WHERE Categorii_idCategorii = idCategorii AND numeCategorie = \"" + numeCategorieAux + "\";";
            mySql.statement = mySql.connection.createStatement();
            mySql.resultSet = mySql.statement.executeQuery(mySql.query);
            while (mySql.resultSet.next()) {
                lista.add(new Query2(mySql.resultSet.getString("numeProdus"), mySql.resultSet.getString("numeCategorie")));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        tabQuery2.getItems().clear();
        tabQuery2.getItems().addAll(lista);
    }

    public void afisareQuery3() {
        ObservableList<Query3> lista = FXCollections.observableArrayList();
        numeQuery3.setCellValueFactory(new PropertyValueFactory<Query3, String>("nume"));
        prenumeQuery3.setCellValueFactory(new PropertyValueFactory<Query3, String>("prenume"));
        stradaQuery3.setCellValueFactory(new PropertyValueFactory<Query3, String>("strada"));
        String stradaAux = listaQuery3.getValue();
        try {
            mySql.query = "SELECT nume, prenume, strada FROM clienti, adreselivrare WHERE AdreseLivrare_idAdreseLivrare = idAdreseLivrare AND strada = \"" + stradaAux + "\";";
            mySql.statement = mySql.connection.createStatement();
            mySql.resultSet = mySql.statement.executeQuery(mySql.query);
            while (mySql.resultSet.next()) {
                lista.add(new Query3(mySql.resultSet.getString("nume"), mySql.resultSet.getString("prenume"), mySql.resultSet.getString("strada")));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        tabQuery3.getItems().clear();
        tabQuery3.getItems().addAll(lista);
    }

    public void afisareQuery4() {
        ObservableList<Query4> lista = FXCollections.observableArrayList();
        numeProdusQuery4.setCellValueFactory(new PropertyValueFactory<Query4, String>("numeProdus"));
        numeCategorieQuery4.setCellValueFactory(new PropertyValueFactory<Query4, String>("numeCategorie"));
        durataPreparareQuery4.setCellValueFactory(new PropertyValueFactory<Query4, String>("durataPreparare"));
        String durataPreparareAux = durataPreparareQuery4Field.getText();
        try {
            mySql.query = "SELECT numeProdus, numeCategorie, durataPreparare FROM produse, categorii WHERE Categorii_idCategorii = idCategorii AND (durataPreparare >= " + durataPreparareAux + ")";
            mySql.statement = mySql.connection.createStatement();
            mySql.resultSet = mySql.statement.executeQuery(mySql.query);
            while (mySql.resultSet.next()) {
                lista.add(new Query4(mySql.resultSet.getString("numeProdus"), mySql.resultSet.getString("numeCategorie"), mySql.resultSet.getString("durataPreparare")));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        tabQuery4.getItems().clear();
        tabQuery4.getItems().addAll(lista);
    }

    public void afisareQuery5() {
        ObservableList<Query5> lista = FXCollections.observableArrayList();
        statusQuery5.setCellValueFactory(new PropertyValueFactory<Query5, String>("status"));
        numeQuery5.setCellValueFactory(new PropertyValueFactory<Query5, String>("nume"));
        prenumeQuery5.setCellValueFactory(new PropertyValueFactory<Query5, String>("prenume"));
        String statusAux = listaQuery5.getValue();
        try {
            mySql.query = "SELECT status, nume, prenume FROM comenzi, clienti WHERE Clienti_idClient = idClient AND status = \"" + statusAux + "\";";
            mySql.statement = mySql.connection.createStatement();
            mySql.resultSet = mySql.statement.executeQuery(mySql.query);
            while (mySql.resultSet.next()) {
                lista.add(new Query5(mySql.resultSet.getString("status"), mySql.resultSet.getString("nume"), mySql.resultSet.getString("prenume")));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        tabQuery5.getItems().clear();
        tabQuery5.getItems().addAll(lista);
    }

    /*
    Functia cu ajutorul careia se construieste dorpdown list-ul pentru a 6-ea interogare simpla
     */
    public void modificaListaQuery6() {
        try {
            String query = "SELECT DISTINCT(status) FROM catering.comenzi;";
            mySql.getResultSet(query);
            listaQuery6.getItems().clear();
            listaQuery6.getItems().add("Google");
            listaQuery6.getItems().add("Yahoo");
            listaQuery6.setValue("Google");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void afisareQuery6() {
        ObservableList<Query6> lista = FXCollections.observableArrayList();
        prenumeQuery6.setCellValueFactory(new PropertyValueFactory<Query6, String>("prenume"));
        emailQuery6.setCellValueFactory(new PropertyValueFactory<Query6, String>("email"));
        stradaQuery6.setCellValueFactory(new PropertyValueFactory<Query6, String>("strada"));
        numarQuery6.setCellValueFactory(new PropertyValueFactory<Query6, String>("numar"));
        String emailAux = listaQuery6.getValue();
        try {
            switch (emailAux) {
                case "Google": {
                    mySql.query = "SELECT prenume, email, strada, numar FROM clienti, adreselivrare WHERE AdreseLivrare_idAdreseLivrare = idAdreseLivrare AND (email LIKE \"%@gmail.com\")";
                    break;
                }
                case "Yahoo": {
                    mySql.query = "SELECT prenume, email, strada, numar FROM clienti, adreselivrare WHERE AdreseLivrare_idAdreseLivrare = idAdreseLivrare AND (email LIKE \"%@yahoo.com\" OR email LIKE \"%ymail.com\")";
                    break;
                }
                default: break;
            }
            mySql.statement = mySql.connection.createStatement();
            mySql.resultSet = mySql.statement.executeQuery(mySql.query);
            while (mySql.resultSet.next()) {
                lista.add(new Query6(mySql.resultSet.getString("prenume"), mySql.resultSet.getString("email"), mySql.resultSet.getString("strada"), mySql.resultSet.getString("numar")));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        tabQuery6.getItems().clear();
        tabQuery6.getItems().addAll(lista);
    }

    /*
    Functiile de afisare al interogarilor complexe
     */
    public void afisareComplex1() {
        ObservableList<Complex1> lista = FXCollections.observableArrayList();
        numeProdusComplex1.setCellValueFactory(new PropertyValueFactory<Complex1, String>("numeProdus"));
        numeCategorieComplex1.setCellValueFactory(new PropertyValueFactory<Complex1, String>("numeCategorie"));
        pretComplex1.setCellValueFactory(new PropertyValueFactory<Complex1, String>("pret"));
        try {
                mySql.query = "SELECT p.numeProdus, c.numeCategorie, p.pret\n" +
                        "FROM produse p, categorii c\n" +
                        "WHERE Categorii_idCategorii = idCategorii AND p.pret IN \n" +
                        "(SELECT MAX(pp.pret)\n" +
                        "FROM produse pp\n" +
                        "WHERE p.Categorii_idCategorii = pp.Categorii_idCategorii\n" +
                        "GROUP BY Categorii_idCategorii)\n";
                mySql.statement = mySql.connection.createStatement();
                mySql.resultSet = mySql.statement.executeQuery(mySql.query);
                while (mySql.resultSet.next()) {
                lista.add(new Complex1(mySql.resultSet.getString("numeProdus"), mySql.resultSet.getString("numeCategorie"), mySql.resultSet.getString("pret")));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        tabComplex1.getItems().clear();
        tabComplex1.getItems().addAll(lista);
    }

    public void afisareComplex2() {
        ObservableList<Complex2> lista = FXCollections.observableArrayList();
        numeCategorieComplex2.setCellValueFactory(new PropertyValueFactory<Complex2, String>("numeCategorie"));
        numarProduseComplex2.setCellValueFactory(new PropertyValueFactory<Complex2, String>("numarProduse"));
        try {
            mySql.query = "SELECT C.numeCategorie, (\n" +
                    "SELECT COUNT(*) \n" +
                    "FROM Produse P\n" +
                    "WHERE P.Categorii_idCategorii = C.idCategorii) AS numarProduse\n" +
                    "FROM Categorii C";
            mySql.statement = mySql.connection.createStatement();
            mySql.resultSet = mySql.statement.executeQuery(mySql.query);
            while (mySql.resultSet.next()) {
                lista.add(new Complex2(mySql.resultSet.getString("numeCategorie"), mySql.resultSet.getString("numarProduse")));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        tabComplex2.getItems().clear();
        tabComplex2.getItems().addAll(lista);
    }

    public void afisareComplex3() {
        ObservableList<Complex3> lista = FXCollections.observableArrayList();
        numeComplex3.setCellValueFactory(new PropertyValueFactory<Complex3, String>("nume"));
        prenumeComplex3.setCellValueFactory(new PropertyValueFactory<Complex3, String>("prenume"));
        telefonComplex3.setCellValueFactory(new PropertyValueFactory<Complex3, String>("telefon"));
        emailComplex3.setCellValueFactory(new PropertyValueFactory<Complex3, String>("email"));
        try {
            mySql.query = "SELECT nume, prenume, telefon, email \n" +
                    "FROM clienti\n" +
                    "WHERE AdreseLivrare_idAdreseLivrare IN ( SELECT idAdreseLivrare\n" +
                    "FROM adreselivrare\n" +
                    "WHERE strada LIKE \"%ii\")";
            mySql.statement = mySql.connection.createStatement();
            mySql.resultSet = mySql.statement.executeQuery(mySql.query);
            while (mySql.resultSet.next()) {
                lista.add(new Complex3(mySql.resultSet.getString("nume"), mySql.resultSet.getString("prenume"), mySql.resultSet.getString("telefon"), mySql.resultSet.getString("email")));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        tabComplex3.getItems().clear();
        tabComplex3.getItems().addAll(lista);
    }

    /*
    Functia cu ajutorul careia se construieste dorpdown list-ul pentru a 4-a interogare complexa
     */
    public void modificaListaComplex4() {
        try {
            String query = "SELECT Distinct(concat(nume,' ', prenume)) AS numeComplet\n" +
                    "FROM clienti";
            mySql.getResultSet(query);
            listaComplex4.getItems().clear();
            mySql.resultSet.next();
            String tmp = mySql.resultSet.getString("numeComplet");
            listaComplex4.getItems().add(tmp);
            while(mySql.resultSet.next()) {
                listaComplex4.getItems().add(mySql.resultSet.getString("numeComplet"));
            }
            listaComplex4.setValue(tmp);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void afisareComplex4() {
        ObservableList<Complex4> lista = FXCollections.observableArrayList();
        numeProdusComplex4.setCellValueFactory(new PropertyValueFactory<Complex4, String>("numeProdus"));
        numeCategorieComplex4.setCellValueFactory(new PropertyValueFactory<Complex4, String>("numeCategorie"));
        String numeAux = listaComplex4.getValue();
        numeAux = numeAux.substring(0, numeAux.indexOf(' '));
        String idAux = "";
       try{
        mySql.query = "SELECT idClient\n" +
                "FROM clienti\n" +
                "WHERE nume = \"" + numeAux + "\"";
        mySql.statement = mySql.connection.createStatement();
        mySql.resultSet = mySql.statement.executeQuery(mySql.query);
        mySql.resultSet.next();
        idAux = mySql.resultSet.getString("idClient");
        System.out.println(idAux);
       } catch (Exception e) {
           System.out.println(e);
       }
        try {
            mySql.query = "SELECT P.numeProdus, C.numeCategorie\n" +
                    "FROM produse P, categorii C\n" +
                    "WHERE P.Categorii_idCategorii = C.idCategorii AND P.idProduse IN (SELECT cp.Produse_idProduse\n" +
                    "FROM  comenzi_has_produse cp\n" +
                    "WHERE cp.Comenzi_idComenzi = '" + idAux + "' )";
            mySql.statement = mySql.connection.createStatement();
            mySql.resultSet = mySql.statement.executeQuery(mySql.query);
            while (mySql.resultSet.next()) {
                lista.add(new Complex4(mySql.resultSet.getString("numeProdus"), mySql.resultSet.getString("numeCategorie")));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        tabComplex4.getItems().clear();
        tabComplex4.getItems().addAll(lista);
    }

    /*
    Functia cu ajutorul careia se construiesc dropdown list-urile pentru interogarile simple: 2, 3, 5
     */
    public void modificaListaQuerys(String coloana, String tabela, ComboBox<String> lista) {
        try {
            String query = "SELECT DISTINCT(" + coloana + ") FROM catering." + tabela ;
            mySql.getResultSet(query);
            lista.getItems().clear();
            mySql.resultSet.next();
            String tmp = mySql.resultSet.getString(coloana);
            lista.getItems().add(tmp);
            while(mySql.resultSet.next()) {
                lista.getItems().add(mySql.resultSet.getString(coloana));
            }
            lista.setValue(tmp);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /*
        Functii folosite pentru a putea afisa un dropdown list in conformitate cu tabelele pe care le putem modifica.
         */
        modificaListaQuerys("numeCategorie", "categorii", listaQuery2);
        modificaListaQuerys("strada", "adreselivrare", listaQuery3);
        modificaListaQuerys("status", "comenzi", listaQuery5);
        modificaListaQuery6();
        modificaListaComplex4();
    }
}
