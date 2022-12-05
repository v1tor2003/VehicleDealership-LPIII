package models.people;

import services.Data;

public class Pessoa{
  
  private String nome;
  private String email;
  private String telefone;
  private Data dataNascimento;

  public Pessoa(String nome, String email, String telefone, int dia, int mes,int ano){    
    if(validateContact(nome, email, telefone)){
      this.nome = nome;
      this.email = email;
      this.telefone = telefone;
    }else{
      this.nome = "Nao informado";
      this.email = "Nao informado";
      this.telefone = "Nao informado";
    }

    this.dataNascimento = new Data(dia, mes, ano);
  }

  public Pessoa(String nome, String email, String telefone){
    this(nome, email, telefone, 0, 0, 0);
  }

  private boolean validateContact(String nome, String email, String telefone){
    return (validateName(nome) && ((validateEmail(email) || validatePhoneNumber(telefone))));
  }

  private boolean validateEmail(String email){
    String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
    if(email == null)
      return false;

    return (email.matches(regex));
  }

  private boolean validateName(String nome){  
    return (nome != null);
  }

  private boolean validatePhoneNumber(String telefone){
    final int phoneNumberSize = 10;
    
    if(telefone == null || telefone.length() != 10 )
      return false;
    
    boolean isEqualToANumber = false;
    final char phone [] = telefone.toCharArray();
    final char numbersAsChar [] = {'0','1', '2', '3', '4', '5', '6', '7', '8', '9'};
    
    for(int i = 0; i < phoneNumberSize; i++){
      for(int j = 0; j < numbersAsChar.length; j++){
        if(phone[i] == numbersAsChar[j]){
          isEqualToANumber = true;
          break;
        }
      }
      if (!isEqualToANumber)
        return false;
    }

    return true;
  }

  protected String getNome(){
    return nome;
  }

  protected String getEmail(){
    return email;
  }

  protected String getTelefone(){
    return telefone;
  }
  
  protected Data getDataNascimento(){
    return this.dataNascimento;
  }

  public boolean isEmailValid(){
    return validateEmail(this.email);
  }

  public boolean isPhoneValid(){
    return validatePhoneNumber(this.telefone);
  }

  public void setContato(String nome, String email, String telefone){
    this.nome = nome;
    this.email = email;
    this.telefone = telefone;
  }
  
  public void setDataNascimento(int dia, int mes, int ano){
    dataNascimento.setData(dia, mes, ano);
  }

  public String toString(){

    return String.format("Nome: %s\nEmail: %s\nTelefone: %s\nData de Nascimento: %s\n", this.nome, this.email, this.telefone, this.dataNascimento); 
  }
}
