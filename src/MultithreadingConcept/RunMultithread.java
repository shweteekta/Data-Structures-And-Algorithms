package MultithreadingConcept;

public class RunMultithread {
    public static void main(String[] args){

        for(int i=0;i<4;i++){
            MultithreadThing thing = new MultithreadThing(2);
            thing.start();
        }
    }
}
