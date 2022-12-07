package labrepop1_josebendana;

public class Carro {
    public String VIN;
    public String marca;
    public String modelo;
    public String color;
    public int year;

    public Carro(String VIN, String marca, String modelo, String color, int year) {
        this.VIN = VIN;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.year = year;
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return  "VIN:" + VIN + ", marca:" + marca + ", modelo:" + modelo + ", color:" + color + ", year:" + year;
    }
    
    
}
