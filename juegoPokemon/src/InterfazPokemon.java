import java.util.Scanner;
public class InterfazPokemon {
    private Scanner teclado;

    public InterfazPokemon(){
        teclado = new Scanner(System.in);
    }

    public void Juego() {
        System.out.println("Bienvenido al juego de Pokemón");
    Pokemon pokemonJugador = menuCreacionPokemonJugador();

    for (int i = 1; i <=3; i++) {
        System.out.println("\n--- COMBATE " + i + "---");

        Pokemon pokemonRival = siguientePokemonRival(i);
        System.out.println("Te enfrentas a:");
        System.out.println(pokemonRival);

        Pokemon ganador = Partida(pokemonJugador, pokemonRival);

        if (ganador == pokemonJugador) {
            System.out.println("\n¡Has ganado el combate! Tu Pokemón sube de nivel");
            pokemonJugador.subirNivel();

            if (i == 3) {
                mostrarJuegoSuperado();
                return;
            }
        } else {
            mostrarFinPartida();
            return;
        }
    }
    }

    private Pokemon Partida(Pokemon pokemonJugador, Pokemon pokemonRival) {
        Combate combate = new Combate(pokemonJugador, pokemonRival);

        while (combate.Ganador() == null) {
            combate.Ronda();
        }
        return combate.Ganador();
    }

    private Pokemon menuCreacionPokemonJugador() {
        System.out.println("Crea tu Pokemón");
        System.out.println("Introduce un nombre: ");
        String nombre = teclado.nextLine();

        System.out.println("Elige su tipo: ");
        System.out.println("1. Agua");
        System.out.println("2. Tierra");
        System.out.println("3. Fuego");

        int opcion = teclado.nextInt();
        teclado.nextLine();

        String tipo;
        switch (opcion) {
            case 1:
                tipo = "agua";
                break;
            case 2:
                tipo = "tierra";
                break;
            case 3:
                tipo = "fuego";
                break;
            default:
                System.out.println("Opción inválida. Se asignará tipo fuego por defecto");
                tipo = "fuego";
                break;
        }
        return new Pokemon(nombre, tipo);
    }

    public Pokemon siguientePokemonRival(int numero) {
        switch (numero) {
            case 1:
                return new Pokemon("Caterpie", "tierra", 1);
            case 2:
                return new Pokemon("Bulbasur", "agua", 2);
            case 3:
                return new Pokemon("Charmander", "fuego", 3);
            default:

                System.out.println("Número inválido, asignando Caterpie por defecto.");
                return new Pokemon("Caterpie", "tierra", 1);
        }
    }

    private void mostrarJuegoSuperado(){
        System.out.println("++++++++++ ENHORABUENA +++++++++++");
        System.out.println("+++++ HAS SUPERADO EL JUEGO ++++++");
        System.out.println("++++ ERES UN MAESTRO POKEMON +++++");
    }

    private void mostrarFinPartida(){
        System.out.println("++++++++++ LO SIENTO +++++++++++");
        System.out.println("+++++ HAS SIDO ELIMINADO ++++++");
        System.out.println("+++++ VUELVE A INTENTARLO +++++");
    }

}
