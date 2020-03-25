import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Generator {

    private Matrix dataset;


    public Generator(String filename){

        dataset = new Matrix();
        dataset.initialize(filename);
    }

    public void evolutiveTSP(Integer popSize, Integer nrSteps, String filename){
        Population population = new Population(popSize,dataset);
        Population lastPopulation = new Population(population);

        while(nrSteps > 0){
            Population newPopulation = new Population(population);

            for(int i=0; i< popSize; i++){
                Chromosome male = population.selection();
                Chromosome female = population.selection();
                Chromosome offspring = male.crossOver(female);
                Chromosome offspringMutant = offspring.mutation();
                newPopulation.addGeneration(offspringMutant);
            }
            nrSteps--;
            lastPopulation = new Population(newPopulation);
        }

        Chromosome theBest = lastPopulation.getTheBest();
        printToFile(theBest , filename);
    }


    public void printToFile(Chromosome x , String filename){

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            bw.write(x.getGeneration().size() + "\n");
            System.out.print("The best solution: ");
            for(Integer i : x.getGeneration()) {
                System.out.print(i + " ");
                bw.write(i + " ");
            }
            System.out.println();
            System.out.println("The best score: " + x.getFitness());
            bw.write("\n" + x.getFitness());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
