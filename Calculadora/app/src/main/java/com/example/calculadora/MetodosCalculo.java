package com.example.calculadora;

public class MetodosCalculo
{
    public Double AreaQuadrado(double v)
    {
        return Math.pow(v,2);
    }
    public Double AreaRetangulo(double v,double v2)
    {
        return v * v2;
    }
    public Double AreaTriangulo(double v,double v2) { return (v * v2)/2; }
    public Double AreaCirculo(double v)
    {
        return v * Math.PI;
    }
}
