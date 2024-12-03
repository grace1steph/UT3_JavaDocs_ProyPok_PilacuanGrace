public class Combate {

    // Añada los atributos y el constructor *************
    private Pokemon pokemonJugador;
    private Pokemon pokemonRival;

    public Combate(Pokemon pokemonJugador, Pokemon pokemonRival){
        this.pokemonJugador = pokemonJugador;
        this.pokemonRival = pokemonRival;
    }



    //***************************************************


    public Pokemon Ronda(){
        int poderJugador = pokemonJugador.calcularPoder(pokemonRival);
        int poderRival = pokemonRival.calcularPoder(pokemonJugador);

        System.out.println(pokemonJugador.getNombre() + "genera un poder de :" + poderJugador);
        System.out.println(pokemonRival.getNombre() + "genera un poder:" + poderRival);

        if (poderJugador > poderRival) {
            pokemonRival.disminuirAguante();
            System.out.println("Gana la ronda:" + pokemonJugador.getNombre());
            return pokemonJugador;
        } else if (poderRival > poderJugador) {
            pokemonJugador.disminuirAguante();
            System.out.println("Gana la ronda: " + pokemonRival.getNombre());
            return pokemonRival;
        } else {
            System.out.println("Empate en esta ronda");
            return null;
        }
    }

    public Pokemon Ganador(){
        if (pokemonJugador.getAguante() <= 0) {
            return pokemonRival;
        } else if (pokemonRival.getAguante() <= 0) {
            return pokemonJugador;
        }
        return null;
    }
}
