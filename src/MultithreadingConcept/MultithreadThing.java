package MultithreadingConcept;

public class MultithreadThing extends Thread{

    private final int threadNumber;

    public MultithreadThing(int threadNumber){
        this.threadNumber = threadNumber;
    }

    @Override
    public void run(){
        for(int i=0;i<4;i++){
            System.out.println(i + "from" +threadNumber);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
