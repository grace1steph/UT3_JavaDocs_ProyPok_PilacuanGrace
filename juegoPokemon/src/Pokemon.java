import java.util.Random;

public class Pokemon {

    private String nombre;
    private String tipo;
    private int nivel;
    private int aguante;

// Añada los constructores********************
    public Pokemon(String nombre, String tipo){
        this.nombre = nombre;
        this.tipo = tipo;
        this.nivel = 1;
        this.actualizarStats();
    }

    public Pokemon (String nombre, String tipo, int nivel){
        this.nombre=nombre;
        this.tipo =tipo;
        this.nivel= nivel;
        this.actualizarStats();
    }



// ******************************************

    public int getAguante() {
        return aguante;
    }

    public void setAguante(int aguante) {
        this.aguante = aguante;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    //Metodo que calcula el poder
    public int calcularPoder(Pokemon contrincante) {
        Random random = new Random();
        int poder = 0;

        if (nivel == 1) {
            poder = random.nextInt(8) + 3;
        }else if (nivel == 2) {
            poder = random.nextInt(15) + 6;
        }else if (nivel == 3) {
            poder = random.nextInt(22) + 9;
        }else {
            poder = random.nextInt(29) + 12;
    }

        if (this.tipo.equals("agua") && contrincante.tipo.equals("fuego")) {
            poder += 2 * nivel;
        } else if (this.tipo.equals("agua") && contrincante.tipo.equals("tierra")){
            poder -= 2 * contrincante.nivel;
        } else if (this.tipo.equals("fuego") && contrincante.tipo.equals("tierra")) {
            poder += 2 * nivel;
        } else if (this.tipo.equals("fuego") && contrincante.tipo.equals("agua")) {
            poder -= 2 * contrincante.nivel;
        } else if (this.tipo.equals("tierra") && contrincante.tipo.equals("agua")) {
            poder += 2 * this.nivel;
        } else if (this.tipo.equals("tierra") && contrincante.tipo.equals("fuego")) {
            poder -= 2 * contrincante.nivel;
        }

        if (poder < 1) {
            poder = 1;
        }
            return poder;
        }


    public void subirNivel(){
        this.nivel++;
        this.actualizarStats();
    }

    public void actualizarStats(){
        this.aguante = (int) Math.round(nivel * 2.5);
    }

    public void disminuirAguante(){
        this.aguante--;
    }

    public String toString(){
        return "Nombre: " + this.nombre +
                "\n tipo: " + this.tipo +
                "\n nivel: " + this.nivel +
                "\n aguante " + this.aguante;
    }

}
