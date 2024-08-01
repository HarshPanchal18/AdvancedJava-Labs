package org.example.Assignment2;

public class Complex {
    public double real;
    public double imag;

    public Complex() {
    }

    public Complex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImag() {
        return imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    public static Complex add(Complex a, Complex b) {
        return new Complex(a.real + b.real, a.imag + b.imag);
    }

    public static Complex subtract(Complex a, Complex b) {
        return new Complex(a.real - b.real, a.imag - b.imag);
    }

    public static Complex multiply(Complex a, Complex b) {
        return new Complex(a.real * b.real, a.imag * b.imag);
    }

    public static Complex divide(Complex a, Complex b) {
        return new Complex(a.real / b.real, a.imag / b.imag);
    }
}