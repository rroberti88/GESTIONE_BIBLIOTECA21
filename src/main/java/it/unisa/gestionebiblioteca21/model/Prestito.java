/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.gestionebiblioteca21.model;
import java.time.LocalDate;
/**
 *
 * @author Felice Iandoli
 */
public class Prestito {
  private int idPrestito;
  private LocalDate dataInizio ; 
  private LocalDate dataFinePrevista;
  private LocalDate dataRestituzione;
 
  
  public Prestito(int idPrestito, LocalDate dataInizio, LocalDate dataFinePrevista, LocalDate dataRestituzione){
      this.idPrestito = idPrestito;
      this.dataInizio = dataInizio;
      this.dataFinePrevista = dataFinePrevista;
      this.dataRestituzione = dataRestituzione;
      
  }
  
  public int getIdPrestito(){
      return idPrestito;
  }

  public void setIdPrestito(int idPrestito){
      this.idPrestito = idPrestito;
  }
  
  public LocalDate getDataInizio(){
      return dataInizio;
  }

public void setDataInizio(LocalDate dataInizio){
      this.dataInizio = dataInizio;
  }
  
  public LocalDate getDataFinePrevista(){
      return dataFinePrevista;
  }

public void setDataFinePrevista(LocalDate dataFinePrevista){
      this.dataFinePrevista = dataFinePrevista;
  }
  
   public LocalDate getDataRestituzione(){
      return dataRestituzione;
  }
   
  public void setDataRestituzione(LocalDate dataRestituzione){
      this.dataRestituzione = dataRestituzione;
  }
  
   public boolean isOverdue(){
       return dataRestituzione== null && LocalDate.now().isAfter(dataFinePrevista);
            
}
   public boolean isLent(){
     return dataRestituzione== null;
}
   
}

