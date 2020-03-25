public class Main {

    public static void main(String[] args) {

        Generator graph = new Generator("C:\\Users\\Serban\\Desktop\\Anul3Sem2\\AI\\Lab4\\src\\files\\medium_01_tsp.txt");
        graph.evolutiveTSP(500,500, "C:\\Users\\Serban\\Desktop\\Anul3Sem2\\AI\\Lab4\\src\\files\\Singeorzan_medium");
    }
}
