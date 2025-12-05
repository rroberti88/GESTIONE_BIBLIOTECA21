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
  private boolean prestitoAttivo;
  
  public Prestito(int idPrestito, LocalDate dataInizio, LocalDate dataFinePrevista, LocalDate dataRestituzione, boolean prestitoAttivo){
      this.idPrestito = idPrestito;
      this.dataInizio = dataInizio;
      this.dataFinePrevista = dataFinePrevista;
      this.dataRestituzione = null;
      this.prestitoAttivo = false;
  }
  
  public int getIdPrestito(){
      return idPrestito;
  }
  
  public LocalDate getDataInizio(){
      return dataInizio;
  }
  
  public LocalDate getDataFinePrevista(){
      return dataFinePrevista;
  }
  
   public LocalDate getDataRestituzione(){
      return dataRestituzione;
  }
   
   public void setIdPrestito(){
      this.idPrestito = idPrestito;
  }
  
  public void setDataInizio(){
      this.dataInizio = dataInizio;
  }
  
  public void setDataFinePrevista(){
      this.dataFinePrevista = dataFinePrevista;
  }
  
   public void setDataRestituzione(){
      this.dataRestituzione = dataRestituzione;
  }
}
   public boolean isOverdue(){
      return ;
}
   public boolean isLent(){
      return prestitoAttivo;
}
   
}

