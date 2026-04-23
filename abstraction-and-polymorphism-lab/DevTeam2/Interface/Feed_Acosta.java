//Interface by Acosta
//Has 1 abstract and concrete method

public interface Feed_Acosta {
    void feedAnimal(); //abstract
    
    default void selectTreat(String treat) { // concrete
        System.out.println("Selected treat is "+treat);
    }
    
}
