/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.unisa.gestionebiblioteca21.model;

import java.time.LocalDate;

public class Prestito {
  private String libro;
  private String utente;
  private LocalDate dataPrestito ; 
  private LocalDate dataScadenza;
  private LocalDate dataRestituzione;
 
  
  public Prestito(String libro, String utente, LocalDate dataPrestito, LocalDate dataScadenza, LocalDate dataRestituzione){
      this.libro = libro;
      this.utente = utente;
      this.dataPrestito = dataPrestito;
      this.dataScadenza = dataScadenza;
      this.dataRestituzione = dataRestituzione;
      
  }

    public String getLibro() {
        return libro;
    }

    public void setLibro(String libro) {
        this.libro = libro;
    }

    public String getUtente() {
        return utente;
    }

    public void setUtente(String utente) {
        this.utente = utente;
    }

    public LocalDate getDataPrestito() {
        return dataPrestito;
    }

    public void setDataPrestito(LocalDate dataPrestito) {
        this.dataPrestito = dataPrestito;
    }

    public LocalDate getDataScadenza() {
        return dataScadenza;
    }

    public void setDataScadenza(LocalDate dataScadenza) {
        this.dataScadenza = dataScadenza;
    }


    public LocalDate getDataRestituzione() {
        return dataRestituzione;
    }

    public void setDataRestituzione(LocalDate dataRestituzione) {
        this.dataRestituzione = dataRestituzione;
    }
  
 
   public boolean isOverdue(){
       return dataRestituzione== null && LocalDate.now().isAfter(dataScadenza);
            
}
   public boolean isLent(){
     return dataRestituzione== null;
}
   
}

