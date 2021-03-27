/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

public class Triangulo {
    private double base;
    private double altura;
    
    public Triangulo(double base, double altura){
        this.base = base;
        this.altura = altura;
    }
    
    public Double getArea(){
        return (this.base*this.altura)/2;
    }
    
    public Double getPerimetro(){
        return this.base * 3;
    }
}
